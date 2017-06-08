
import com.netcenter.zaascy.util.MessageStub;


/**
 * Created by Administrator on 2017/4/6.
 */
public class TestMessage {
    public static void main(String[] args) {

            //System.out.println(MessageUtil.sendSms("【英雄联盟】尊贵的英雄联盟玩家nookiehuihui您好，恭喜成为本期的幸运召唤师，精彩皮肤全场一折，快来抢购吧,活动网址：http://act.daoju.qq.com/lol/aluckystar/index.htm。","18758259212"));
            //System.out.println(MssUtil.sendSms("【迅雷】尊贵的迅雷VIP6您好，现在续费白金会员可享受买一年送一年的优惠，详情请访问https://xunlei.com/event/2017","18758259212"));
        try {
            MessageStub ms = new MessageStub();
            MessageStub.SendSms mss = new MessageStub.SendSms();
            mss.setText("【成果转化系统】尊敬的管理员您好，您有一条数农所的关于农业推广的服务待审核，请前往系统审核。");
            mss.setMobile("18758259212");
            System.out.println(ms.sendSms(mss).get_return());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        RPCServiceClient serviceClient = null;
//        try {
//            serviceClient = new RPCServiceClient();
//
//            Options options = serviceClient.getOptions();
//            //  指定调用WebService的URL
//            EndpointReference targetEPR = new EndpointReference("http://localhost:8080/services/message?wsdl");
//            options.setTo(targetEPR);
//            //  指定sayHelloToPerson方法的参数值
//            Object[] opAddEntryArgs = new Object[] {"【测试】1245926","18758259212"};
//            //  指定sayHelloToPerson方法返回值的数据类型的Class对象
//            Class[] classes = new Class[] {String.class};
//            //  指定要调用的sendSms方法及WSDL文件的命名空间
//            QName opAddEntry = new QName("http://ws.axis2Example/", "sendSms");
//            //  调用sayHelloToPerson方法并输出该方法的返回值
//            System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        }
    }
}
