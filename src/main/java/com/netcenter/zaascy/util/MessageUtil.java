package com.netcenter.zaascy.util;

/**
 * Created by Administrator on 2017/4/6.
 */

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {

    //查账户信息的http地址
    private static String URI_GET_USER_INFO = "https://sms.yunpian.com/v2/user/get.json";

    //智能匹配模板发送接口的http地址
    private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    //模板发送接口的http地址
    private static String URI_TPL_SEND_SMS = "https://sms.yunpian.com/v2/sms/tpl_single_send.json";

    //发送语音验证码接口的http地址
    private static String URI_SEND_VOICE = "https://voice.yunpian.com/v2/voice/send.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";

    private static String URL_REPLY_SMS = "https://sms.yunpian.com/v1/sms/pull_reply.json";

    private static final String apikey = "fa5f4e68407946ad2222ae980666eb97";

    public static void main(String[] args) throws IOException, URISyntaxException {

        //修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后获取
        //String apikey = "fa5f4e68407946ad2222ae980666eb97";

        //修改为您要发送的手机号
        //String mobile = "13071805994";

        /**************** 查账户信息调用示例 *****************/
        System.out.println(MessageUtil.getUserInfo(apikey));

        /**************** 使用智能匹配模板接口发短信(推荐) *****************/
        //设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
        //String text = "【农科培训】您好！6月6-7号省农产品质量安全中心（省绿办）委托省农科院举办“绿色食品企业内检员岗位培训”。6日上午在杭州郡富国际大酒店（石桥路198号，省农科院科教培训基地）报到，6日下午2:30开始培训，7日中午培训结束。不收培训费，食宿费自理。报名请发信息（姓名、性别、工作单位、职务职称、联系电话）至91shu@163.com。或发短信（微信）至13067771858.联系人：黄莉莉";

        String text = "【农科培训】您已报名参加基层农技人员农业综合管理培训班，请于7月4日上午到杭州郡富国际大酒店（省农科院，杭州石桥路198号）报到，7号中餐后自由安排。";


        //发短信调用示例
        // System.out.println(MessageUtil.sendSms(apikey, text, mobile));
        String mobile = "";
        //String[]b = {"13967368125","15858306564","13857365701","13505835774","13605834993","13857368253","13511355258","13586396311","13567339093","13605834365","13967369508","13867360350","13905836861","13857367217","13705834719","13516834698","13567370665","13806708985","13456340366","13605833985","13505834856","13819360150","13957373518","13867322169","13819395338","13505831269","13750778810","13567301011","13706597147","13857350006","13567314197","13736426422","13506733111","15869005662","87666005","13600565602","13586303760","13819413975","13857331153","15068201058","13600565661","15067375568","13906738652","15888352278","87093128","13967332510","13506700259","13587124718","13867008806","13587122755","13587018951","13967006751","13967002166","13567018079","13676605335","13867008230","13906709637","13587018620","13600500915","13757007663","13757040423","13867008616","13857003688","13506700581","13587013302","13676605725","13757007586","13757032140","13867008367","13705700006","13587013533","13587013777","13857006910","13867009819","13867008345","13587123690","13757040881","13867001749","13857002356","13867009736","18705787939","15957823157","13967044120","13957073904","13666553755","18857816997","15990434515","13884333568"};
        String[]b = {"18758259212"};
        // String[]b={"13732226393"};
        for(int i=0;i<b.length;i++){
            //String text = "【农科培训】您好！6月6-7号省农产品质量安全中心（省绿办）委托省农科院举办“绿色食品企业内检员岗位培训”。6日上午在杭州郡富国际大酒店（石桥路198号，省农科院科教培训基地）报到，6日下午2:30开始培训，7日中午培训结束。不收培训费，食宿费自理。报名请发信息（姓名、性别、工作单位、职务职称、联系电话）至91shu@163.com。或发短信（微信）至13067771858.联系人：黄莉莉";

            /**************** 使用指定模板接口发短信(不推荐，建议使用智能匹配模板接口) *****************/
            //设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
            mobile = b[i];
            long tpl_id = 0;
            //设置对应的模板变量值

            String tpl_value = URLEncoder.encode("#code#",ENCODING) +"="
                    + URLEncoder.encode("1234", ENCODING) + "&"
                    + URLEncoder.encode("#company#",ENCODING) + "="
                    + URLEncoder.encode("云片网",ENCODING);
            //模板发送的调用示例
            System.out.println(mobile);
            System.out.println(MessageUtil.sendSms(text, mobile));

            /**************** 使用接口发语音验证码 *****************/
            String code = "1234";
            //System.out.println(MessageUtil.sendVoice(apikey, mobile ,code));
        }

    }

    /**
     * 取账户信息
     *
     * @return json格式字符串
     * @throws java.io.IOException
     */

    public static String getUserInfo(String apikey) throws IOException, URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        return post(URI_GET_USER_INFO, params);
    }

    /**
     * 智能匹配模板接口发短信
     *
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String sendSms(String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 通过模板发送短信(不推荐)
     *
     * @param apikey    apikey
     * @param tpl_id    　模板id
     * @param tpl_value 　模板变量值
     * @param mobile    　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String tplSendSms(String apikey, long tpl_id, String tpl_value, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("tpl_id", String.valueOf(tpl_id));
        params.put("tpl_value", tpl_value);
        params.put("mobile", mobile);
        return post(URI_TPL_SEND_SMS, params);
    }

    /**
     * 通过接口发送语音验证码
     * @param apikey apikey
     * @param mobile 接收的手机号
     * @param code   验证码
     * @return
     */

    public static String sendVoice(String apikey, String mobile, String code) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("mobile", mobile);
        params.put("code", code);
        return post(URI_SEND_VOICE, params);
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

}

