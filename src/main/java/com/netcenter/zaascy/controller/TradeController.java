package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.*;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import com.netcenter.zaascy.util.ZaascyStub;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/trade")
public class TradeController{

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "commonService")
    private CommonService commonService;

    private static Log log = LogFactory.getLog(TradeController.class);

    @RequestMapping(value = "/newFirst")
    public ModelAndView newFirst(String codeType,HttpSession session){
        ModelAndView mav = new ModelAndView();
        List<Depart> departList = commonService.getInstituteList();
        List<TradeResource> zaasTechTypeList = commonService.getResourceByType("zaasTechType");

        Integer departId = 0;

        User user = (User)session.getAttribute("user");
        if(user!=null){
            departId = user.getDanwId().intValue();
        }
        mav.addObject("departId",departId);
        mav.addObject("departList",departList);
        mav.addObject("zaasTechTypeList",zaasTechTypeList);
        mav.addObject("codeType",codeType);
        mav.setViewName("trade_first");
        return mav;
    }

    @RequestMapping(value = "/newNext")
    public ModelAndView newNext(String codeType,String zaasCode, String zaasTechType, HttpSession session){
        ModelAndView mav = new ModelAndView();

        User user = (User)session.getAttribute("user");
        Long departId = new Long(0);
       if(user!=null){
           departId = user.getDanwId();
        }

        List<Depart> departList = commonService.getDepartList();
        List<TradeResource> projectTypeList = commonService.getResourceByType("projectType");
        List<TradeResource> zaasTechTypeList = commonService.getResourceByType("zaasTechType");
        List<TradeResource> otherDepartList = commonService.getResourceByType("otherDepart");
        mav.addObject("projectTypeList",projectTypeList);
        mav.addObject("zaasTechTypeList",zaasTechTypeList);
        mav.addObject("otherDepartList",otherDepartList);
        mav.addObject("departList",departList);
        mav.addObject("departId",departId);
        mav.addObject("zaasCode",zaasCode);
        mav.addObject("zaasTechType",zaasTechType);
        mav.addObject("codeType",codeType);
        mav.setViewName("trade_next");
        return mav;
    }

    @RequestMapping(value = "/getDepartFullName")
    @ResponseBody
    public String getDepartFullName(Integer departId){
        String departFullName = commonService.getDepartFullNameById(departId);
        //将得到list转化为json对象
        JSONObject result = new JSONObject();
        try {
            result.put("departFullName", departFullName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/getProjectNum")
    @ResponseBody
    public String getProjectNum(String year, Integer departId, String projectTypeCode){

        if(departId==null){
            return "";
        }
        String departNum = commonService.getDepartNumBydepartId(departId);
        if(year==null||departNum==null||projectTypeCode==null){
            return "";
        }
        String mark = year.trim() + departNum.trim() + projectTypeCode.trim();
        String serialNum = tradeService.getSerialNum(mark);

        //将得到list转化为json对象
        JSONObject result = new JSONObject();
        try {
            result.put("projectNum", mark+serialNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/getZaasCodeList")
    @ResponseBody
    public String getZaasCodeList(String zaasTechType,Integer departId,Integer year){

        //声明需要用到的两个编码列表
        List<String> list_mis;
        List<String> list_njy = new ArrayList<String>();

        //获取mis库中符合条件的编码列表
        list_mis = tradeService.getZaasCodeListByZaasTechType(zaasTechType,departId,year);

        //调用接口获取对应的51农业技术库的编码列表
        try {
            ZaascyStub zaasStub = new ZaascyStub();
            ZaascyStub.GetZaasCodeListByZaasTechType zsg = new ZaascyStub.GetZaasCodeListByZaasTechType();
            zsg.setZaasTechType(zaasTechType);
            zsg.setDepartId(departId);
            zsg.setYear(year);
            String[] str = zaasStub.getZaasCodeListByZaasTechType(zsg).get_return();
            if(str==null||str.length==0){
                log.info("没有找到对应的编码集");
            }else{
                list_njy =  Arrays.asList(str);
            }
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //将两个列表合并去重
        list_mis.removeAll(list_njy);
        list_mis.addAll(list_njy);

        //将合并后的列表重新排序
        Collections.sort(list_mis,new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null){
                    return -1;
                }
                if(o1.length() > o2.length()){
                    return 1;
                }
                if(o1.length() < o2.length()){
                    return -1;
                }
                if(o1.compareTo(o2) > 0){
                    return 1;
                }
                if(o1.compareTo(o2) < 0){
                    return -1;
                }
                if(o1.compareTo(o2) == 0){
                    return 0;
                }
                return 0;
            }
        });

        //将得到list转化为json对象
        JSONObject result = new JSONObject();
        try {
            result.put("size", list_mis.size());
            result.put("list", list_mis);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //利用字符串将json对象返回前台
        return result.toString();
    }

    @RequestMapping(value = "/getTechName")
    @ResponseBody
    public String getTechName(String zaasCode){

        // 编码大小写标准化
        zaasCode = zaasCode.toUpperCase();

        String name_mis;
        String name_njy = "";

        name_mis = tradeService.getNameByZaasCode(zaasCode);

        //调用接口获取对应的51农业技术库的编码列表
        try {
            ZaascyStub zaasStub = new ZaascyStub();
            ZaascyStub.GetZaasTechNameByZaascode zsgz = new ZaascyStub.GetZaasTechNameByZaascode();
            zsgz.setZaasCode(zaasCode);
            name_njy = zaasStub.getZaasTechNameByZaascode(zsgz).get_return();

        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        JSONObject result = new JSONObject();
        try {
            result.put("name_mis", name_mis);
            result.put("name_njy", name_njy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/list")
    public ModelAndView list(String codeType,HttpSession session){
        User user = (User) session.getAttribute("user");
        ModelAndView mav = new ModelAndView();
        if(codeType==null||codeType.equals("")){
            mav.setViewName("index");
        }else{
            List<Trade> tradeList = tradeService.getListByType(codeType,user.getYonghId());
            mav.addObject("tradeList",tradeList);
            mav.addObject("codeType",codeType);
            mav.setViewName("trade_list");
        }

        return mav;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView detail(Long id,String codeType){
        ModelAndView mav = new ModelAndView();
        if(id!=0){
            Trade trade = tradeService.selectByPrimaryKey(id);
            mav.addObject("trade",trade);

            if(trade!=null){
                List<TradeSubsidiary> otherZaasCodes = tradeService.getSubsidiaryList(id);
                mav.addObject("otherZaasCodes",otherZaasCodes);

            }
            List<TradeSubsidiary> otherZaasCodes = tradeService.getOtherZaasCodes(id);
            mav.addObject("otherZaasCodes",otherZaasCodes);

        }
        mav.addObject("codeType",codeType);
        mav.setViewName("trade_detail");
        return mav;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(Long id,String codeType){
        ModelAndView mav = new ModelAndView();
        if(id!=0){
            Trade trade = tradeService.selectByPrimaryKey(id);
            mav.addObject("trade",trade);
        }
        List<Depart> departList = commonService.getInstituteList();
        List<TradeResource> projectTypeList = commonService.getResourceByType("projectType");
        List<TradeResource> zaasTechTypeList = commonService.getResourceByType("zaasTechType");
        List<TradeResource> otherDepartList = commonService.getResourceByType("otherDepart");
        List<TradeSubsidiary> otherZaasCodes = tradeService.getOtherZaasCodes(id);
        mav.addObject("projectTypeList",projectTypeList);
        mav.addObject("zaasTechTypeList",zaasTechTypeList);
        mav.addObject("departList",departList);
        mav.addObject("otherDepartList",otherDepartList);
        mav.addObject("otherZaasCodes",otherZaasCodes);
        mav.addObject("codeType",codeType);
        mav.setViewName("trade_edit");
        return mav;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(Trade trade, RedirectAttributes attr, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if(trade==null){
            log.error("TradeController-->save-->trade is null");
            return mav;
        }
        User user = (User) session.getAttribute("user");
        if(user!=null){
            trade.setOperatorId(user.getRenyId());
            trade.setOperator(user.getXingm());
        }
        //System.out.println(trade.toString());
        tradeService.saveTrade(trade);

        Trade trade2 = tradeService.selectByPrimaryKey(trade.getId());
        if(trade2.getJoinState()!=null&&trade2.getJoinState()==1&&trade2.getSignAmount()!=null){
            //同步至51技术库
            String str_nyj = sendNjy(trade2);
            System.out.println(str_nyj);
        }
        attr.addAttribute("codeType",trade.getProjectTypeCode());
        mav.setViewName("redirect:/trade/list.do");
        return mav;
    }

    @RequestMapping(value = "/beforeDel")
    @ResponseBody
    public String beforeDel(Long id){
        JSONObject result = new JSONObject();
        if(id==null){
            return result.toString();
        }
        Integer fundsCount = tradeService.getFundsCountByProjectId(id);
        Integer memberCount = tradeService.getMembersCountByProjectId(id);
        Integer subsidiaryCount = tradeService.getSubsidiaryCountByProjectId(id);

        try {
            result.put("fundsCount", fundsCount);
            result.put("memberCount", memberCount);
            result.put("subsidiaryCount", subsidiaryCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/del")
    public ModelAndView del(Long id,RedirectAttributes attr,String codeType){
        ModelAndView mav = new ModelAndView();
        if(id!=null){
            tradeService.delChildByProjectId(id);
            tradeService.deleteByPrimaryKey(id);
            tradeService.delFundsByProjectId(id);
            tradeService.delMemberByProjectId(id);
            tradeService.delSubsidiaryByProjectId(id);

        }
        attr.addAttribute("codeType",codeType);
        mav.setViewName("redirect:/trade/list.do");
        return mav;
    }

    @RequestMapping(value = "/checkChildExist")
    @ResponseBody
    public String checkChildExist(Integer year, String quarter){
        JSONObject result = new JSONObject();
        Integer childCount = tradeService.getChildCount(year,quarter);
        Integer tradeCount = 0;
        if(childCount>0){
            tradeCount = tradeService.getTradeCount(year,quarter);
        }
        try {
            result.put("childCount", childCount);
            result.put("tradeCount", tradeCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/goChildImport")
    public ModelAndView goChildImport(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("trade_child_import");
        return mav;
    }

    @RequestMapping(value = "/childImport")
    @ResponseBody
    public String childImport(MultipartHttpServletRequest request, @RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile, HttpSession session){
        JSONObject result = new JSONObject();
        User user = (User)session.getAttribute("user");

        String year = request.getParameter("year");
        String quarter = request.getParameter("quarter");
        String remarks = request.getParameter("remarks");
        String path = request.getSession().getServletContext().getRealPath("excel").replace("excel","WEB-INF/excel/"+year);

        if(year==null||quarter==null||myfile==null){
            try {
                result.put("code","0");
                result.put("msg","传输数据错误，请重试。");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        System.out.println(path+"--->"+year+"--->"+quarter+"--->"+remarks);
//        String fileName = myfile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        String fileName = year + quarter + "检测单.xls";

//        fileName = fileName.replace("spring","春季").replace("spring","春季").replace("spring","春季").replace("spring","春季");
        System.out.println(fileName);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //如果已存在则删除已有记录
        tradeService.delChild(year, quarter);

        //保存
        try {
            myfile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //List list = new ArrayList();
        List<TradeChild>  list = new ArrayList<TradeChild>();

        // 创建输入流
        InputStream stream = null;
        try {
            stream = new FileInputStream(path+"/"+fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(stream==null){
            log.error("文件位置错误，创建输出流失败.");
            return "";
        }

        // 获取Excel文件对象
        Workbook rwb = null;
        try {
            rwb = Workbook.getWorkbook(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        if(rwb==null){
            log.error("获取excel对象失败.");
            return "";
        }

        // 获取文件的指定工作表 默认的第一个
        Sheet sheet = rwb.getSheet(0);
        // 行数(表头的目录不需要，从1开始)
        for (int i = 1; i < sheet.getRows(); i++) {
            // 创建一个TradeChild对象 用来存储每一列的值
            TradeChild tradeChild = new TradeChild();
            //String[] str = new String[sheet.getColumns()];


            if(sheet.getColumns()==10){
                //tradeChild.setYear(new Integer(sheet.getCell(0, i).getContents().trim()));
                tradeChild.setYear(Integer.parseInt(year));
                tradeChild.setProjectNumber(sheet.getCell(1, i).getContents().trim());
                tradeChild.setSampleNumber(sheet.getCell(2, i).getContents().trim());
                tradeChild.setSampleName(sheet.getCell(3, i).getContents().trim());
                tradeChild.setProvideUnit(sheet.getCell(4, i).getContents().trim());
                try {
                    String date1 = sheet.getCell(5, i).getContents();
                    //System.out.println("日期1====="+date1);
                    String date2 = sheet.getCell(6, i).getContents();
                   // System.out.println("日期2====="+date2);
                    tradeChild.setAcceptDate(new SimpleDateFormat("yy-MM-dd").parse(date1));
                    tradeChild.setReportDate(new SimpleDateFormat("yy-MM-dd").parse(date2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String str = sheet.getCell(7, i).getContents();
                //System.out.println("金额====="+str);
                if(str!=null){
                    tradeChild.setAmount(new BigDecimal(str.trim()));
                }else{
                    tradeChild.setAmount(new BigDecimal("0.00"));
                }

                tradeChild.setManager(sheet.getCell(8, i).getContents().trim());
                tradeChild.setRemarks(sheet.getCell(9, i).getContents().trim());
                tradeChild.setOperatorId(user.getYonghId());
                tradeChild.setOperator(user.getXingm());
                tradeChild.setCreateDate(new Date());
                tradeChild.setModifyDate(new Date());
                tradeChild.setQuarter(quarter);
                tradeService.saveTradeChild(tradeChild);
            }else{
                log.error("不合法的excel");
            }

            // 把刚获取的列存入list
            list.add(tradeChild);
        }

        //生成一条记录
        Long id = tradeService.addTradeByChild(Integer.parseInt(year),quarter,remarks,user.getYonghId(),user.getXingm());

        Trade trade = tradeService.selectByPrimaryKey(id);

        try {
            result.put("childCount", list.size());
            result.put("tradeIntentionAmount", trade!=null?trade.getIntentionAmount():0);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/goTradeUpload")
    public ModelAndView goTradeUpload(Long id,String codeType,Integer type){
        ModelAndView mav = new ModelAndView();
        Trade trade = tradeService.selectByPrimaryKey(id);
        if(trade!=null){
            mav.addObject("projectName",trade.getProjectName());
            mav.addObject("projectNum",trade.getProjectNum());
            mav.addObject("id",trade.getId());
        }

        mav.addObject("codeType",codeType);
        //1代表跳转到审批表上传
        if(type!=null&&type==1){
            mav.setViewName("trade_attachment_table_upload");
        }else{
            mav.setViewName("trade_complete");
        }
        return mav;
    }

    @RequestMapping(value = "/saveTradeComplete")
    @ResponseBody
    public String tradeComplete(MultipartHttpServletRequest request, @RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile, HttpSession session){
        JSONObject result = new JSONObject();
        User user = (User)session.getAttribute("user");

        String id = request.getParameter("id");
        String signAmount = request.getParameter("signAmount");

        if(id==null||signAmount==null||myfile==null){
            try {
                result.put("code","0");
                result.put("msg","错误参数");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }
        //application/pdf
        String contentType = myfile.getContentType();
        //10M 10*1048576
        Long contentSize = myfile.getSize();

        if(!contentType.contains("pdf")){
            try {
                result.put("code","0");
                result.put("msg","请上传正确格式的PDF文档");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }else if(contentSize>10*1048576){
            try {
                result.put("code","0");
                result.put("msg","文件过大，请不要超过10M");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        Trade trade = tradeService.selectByPrimaryKey(new Long(id));

        if(trade!=null){
            String path = session.getServletContext().getRealPath("contract").replace("contract", "contract/" + trade.getProjectYear() + "/");

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String timeStamp = sdf.format(date);

            String fileName =  trade.getProjectNum()+"_"+timeStamp+".pdf";

            System.out.println(fileName);
            File targetFile = new File(path, fileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            //保存
            try {
                myfile.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //数据传入数据库
            Trade record  = new Trade();
            record.setId(trade.getId());
            record.setAttachment(fileName);
            record.setSignAmount(new BigDecimal(signAmount));
            record.setOperatorId(user.getYonghId());
            record.setOperator(user.getXingm());
            record.setModifyDate(new Date());
            tradeService.updateByPrimaryKeySelective(record);


            //同步至51技术库
            String str_nyj = sendNjy(trade);

            try {
                result.put("code", 1);
                if(str_nyj.contains("recordSuccess")){
                    result.put("msg", "上传成功,同步成功");
                }else {
                    result.put("msg", "上传成功,同步失败");
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }


    @RequestMapping(value = "/saveTradeAttachmentTable")
    @ResponseBody
    public String tradeAttachmentTable(MultipartHttpServletRequest request, @RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile, HttpSession session){
        JSONObject result = new JSONObject();
        User user = (User)session.getAttribute("user");

        String id = request.getParameter("id");

        if(id==null||myfile==null){
            try {
                result.put("code","0");
                result.put("msg","错误参数");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }
        //application/pdf
        String contentType = myfile.getContentType();
        //10M 10*1048576
        Long contentSize = myfile.getSize();

        if(!contentType.contains("pdf")){
            try {
                result.put("code","0");
                result.put("msg","请上传正确格式的PDF文档");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }else if(contentSize>2*1048576){
            try {
                result.put("code","0");
                result.put("msg","文件过大，请不要超过2M");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        Trade trade = tradeService.selectByPrimaryKey(new Long(id));

        if(trade!=null){
            String path = session.getServletContext().getRealPath("table").replace("table", "table/" + trade.getProjectYear() + "/");

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String timeStamp = sdf.format(date);

            String fileName =  trade.getProjectNum()+"_"+timeStamp+".pdf";

            System.out.println(fileName);

            File targetFile = new File(path, fileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            //保存文件
            try {
                myfile.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //数据传入数据库
            Trade record  = new Trade();
            record.setId(trade.getId());
            record.setAttachmentTable(fileName);
            record.setOperatorId(user.getYonghId());
            record.setOperator(user.getXingm());
            record.setModifyDate(new Date());
            tradeService.updateByPrimaryKeySelective(record);

        }

        return result.toString();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，
    }

    //同步至51技术库
    public String sendNjy(Trade trade){
        String str_nyj = "";
        if(trade==null|| trade.getZaasCode()==null){
            return str_nyj;
        }
        try {
            ZaascyStub zaasStub = new ZaascyStub();
            ZaascyStub.SaveTrade saveTrade = new ZaascyStub.SaveTrade();
            saveTrade.setZaasCode(trade.getZaasCode());
            saveTrade.setProjectName(trade.getProjectName()==null?"":trade.getProjectName());
            saveTrade.setEndDate(trade.getEndDate());
            saveTrade.setStartDate(trade.getStartDate());
            saveTrade.setProjectYear(trade.getProjectYear()==null?0:trade.getProjectYear());
            saveTrade.setSignAmount(trade.getSignAmount()==null?new BigDecimal("0.00"):trade.getSignAmount());
            saveTrade.setProjectSummary(trade.getProjectSummary()==null?"":trade.getProjectSummary());
            saveTrade.setDepartFullName(trade.getDepartFullName()==null?"":trade.getDepartFullName());
            saveTrade.setCustomerDepart(trade.getCustomerDepart()==null?"":trade.getCustomerDepart());
            saveTrade.setUsername(trade.getSubmiter()==null?"":trade.getCustomerDepart());
            str_nyj = zaasStub.saveTrade(saveTrade).get_return();
            System.out.println("返回结果-------"+str_nyj);
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str_nyj;
    }
}
