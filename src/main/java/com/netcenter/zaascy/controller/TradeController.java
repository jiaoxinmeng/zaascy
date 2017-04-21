package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Depart;
import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeResource;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import com.netcenter.zaascy.util.ZaascyStub;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by Administrator on 2017/3/31.
 */
@Controller
@RequestMapping(value = "/trade")
public class TradeController {

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "commonService")
    private CommonService commonService;

    private static Log log = LogFactory.getLog(ViewController.class);

    @RequestMapping(value = "/newFirst")
    public ModelAndView newFirst(HttpSession session){
        ModelAndView mav = new ModelAndView();
        List<Depart> departList = commonService.getInstituteList();
        List<TradeResource> zaasTechTypeList = commonService.getResourceByType("zaasTechType");

        Integer departId = 0;

        User user = (User)session.getAttribute("user");
        if(user!=null){
            departId = new Long(user.getDanwId()).intValue();
        }
        mav.addObject("departId",departId);
        mav.addObject("departList",departList);
        mav.addObject("zaasTechTypeList",zaasTechTypeList);
        mav.setViewName("trade_check");
        return mav;
    }

    @RequestMapping(value = "/newNext")
    public ModelAndView newNext(String zaasCode){
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @RequestMapping(value = "/getZaasCodeList")
    @ResponseBody
    public String getZaasCodeList(String zaasTechType,Integer departId,Integer year){
        //System.out.println(zaasTechType+"--"+departId+"--"+year);

        //声明需要用到的两个编码列表
        List<String> list_mis = new ArrayList<String>();
        List<String> list_njy = new ArrayList<String>();

        //获取mis库中符合条件的编码列表
        list_mis = tradeService.getZaasCodeListByZaasTechType(zaasTechType,departId,year);

        //调用接口获取对应的51农业技术库的编码列表
        try {
            ZaascyStub zaasStub = new ZaascyStub();
            ZaascyStub.GetZaasCodeListByZaasTechType zsg = new ZaascyStub.GetZaasCodeListByZaasTechType();
            //ZaascyStub.GetZaasTechNameByZaascode zsgz = new ZaascyStub.GetZaasTechNameByZaascode();
            zsg.setZaasTechType(zaasTechType);
            zsg.setDepartId(departId);
            zsg.setYear(year);
            //zsgz.setZaasCode("2015JS046");
            String[] str = zaasStub.getZaasCodeListByZaasTechType(zsg).get_return();
            //String str2 = zaasStub.getZaasTechNameByZaascode(zsgz).get_return();
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

        String name_mis = "";
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
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        List<Trade> tradeList = tradeService.selectAll();
        mav.addObject("tradeList",tradeList);
        mav.setViewName("trade_list");
        return mav;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(Long id){
        ModelAndView mav = new ModelAndView();
        if(id!=0){
            Trade trade = tradeService.selectByPrimaryKey(id);
            mav.addObject("trade",trade);
        }
        List<Depart> departList = commonService.getDepartList();
        List<TradeResource> projectTypeList = commonService.getResourceByType("projectType");
        List<TradeResource> zaasTechTypeList = commonService.getResourceByType("zaasTechType");
        mav.addObject("projectTypeList",projectTypeList);
        mav.addObject("zaasTechTypeList",zaasTechTypeList);
        mav.addObject("departList",departList);
        mav.setViewName("trade_edit");
        return mav;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(Trade trade, RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        if(trade==null){
            log.error("TradeController-->save-->trade is null");
        }
        System.out.println(trade.toString());
        tradeService.insertSelective(trade);
        attr.addAttribute("id",trade.getId());
        mav.setViewName("redirect:/trade/list.do");
        return mav;
    }

    @RequestMapping(value = "/del")
    public ModelAndView del(Long id,RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        tradeService.deleteByPrimaryKey(id);
        attr.addAttribute("id",id);
        mav.setViewName("redirect:/trade/list.do");
        return mav;
    }

    @RequestMapping(value = "/goChildImport")
    public ModelAndView goChildImport(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("trade_child_import");
        return mav;
    }

    @RequestMapping(value = "/childImport")
    public ModelAndView childImport(MultipartHttpServletRequest request, @RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile){
        ModelAndView mav = new ModelAndView();
        String path = request.getSession().getServletContext().getRealPath("excel").replace("excel","WEB-INF/excel");
        String year = request.getParameter("year");
        String quarter = request.getParameter("quarter");
        String mydata = request.getParameter("mydata");

        System.out.println(path+"--->"+year+"--->"+quarter+"--->"+mydata);
        String fileName = myfile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
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

        List list = new ArrayList();

        // 创建输入流
        InputStream stream = null;
        try {
            stream = new FileInputStream(path+"/"+fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        // 获取文件的指定工作表 默认的第一个
        Sheet sheet = rwb.getSheet(0);
        // 行数(表头的目录不需要，从1开始)
        for (int i = 0; i < sheet.getRows(); i++) {
            // 创建一个数组 用来存储每一列的值
            String[] str = new String[sheet.getColumns()];
            Cell cell = null;
            // 列数
            for (int j = 0; j < sheet.getColumns(); j++) {
                // 获取第i行，第j列的值
                cell = sheet.getCell(j, i);
                str[j] = cell.getContents();
            }
            // 把刚获取的列存入list
            list.add(str);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] str = (String[]) list.get(i);
            for (int j = 0; j < str.length; j++) {
                System.out.print(str[j] + '\t');
            }
            System.out.println();
        }

        Map map=new HashMap();
        map.put("year", year);
        map.put("quarter", quarter);
        map.put("mydata", mydata);
        map.put("result", "success");
        mav.addAllObjects(map);
        mav.setViewName("");
        return mav;
    }
}
