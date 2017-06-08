import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class TestZaascyWebService {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        try {
//            ZaascyStub zaasStub = new ZaascyStub();
//            ZaascyStub.GetZaasCodeListByZaasTechType zsg = new ZaascyStub.GetZaasCodeListByZaasTechType();
//            ZaascyStub.GetZaasTechNameByZaascode zsgz = new ZaascyStub.GetZaasTechNameByZaascode();
//            zsg.setZaasTechType("实用技术");
//            zsg.setDepartId(0);
//            zsg.setYear(2015);
//            zsgz.setZaasCode("2015JS046");
//            String[] str = zaasStub.getZaasCodeListByZaasTechType(zsg).get_return();
//            //String str2 = zaasStub.getZaasTechNameByZaascode(zsgz).get_return();
//            if(str==null||str.length==0){
//                System.out.println("没有找到对应的结果集");
//            }else{
//                for(String ss : Arrays.asList(str)){
//                    System.out.println(ss);
//                }
//            }
//
//
//            //System.out.println(str);
//        } catch (AxisFault e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        RPCServiceClient serviceClient = null;
        try {
            serviceClient = new RPCServiceClient();

            Options options = serviceClient.getOptions();
            //  指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference("http://www.51nyjs.com/services/zaascy?wsdl");
            options.setTo(targetEPR);
            //  指定sayHelloToPerson方法的参数值
            Date date = new Date();
            BigDecimal amount = new BigDecimal(4000000.00);
            Object[] opAddEntryArgs = new Object[] {"2016R28JS027","测试项目编号生成",date,date,2017,amount,"<p>这是一条测试记录</p>","浙江省农业科学院数字农业研究所","海看网络","彭一辉"};
            //  指定sayHelloToPerson方法返回值的数据类型的Class对象
            Class[] classes = new Class[] {String.class};
            //  指定要调用的sendSms方法及WSDL文件的命名空间
            QName opAddEntry = new QName("http://ws.axis2Example/", "saveTrade");
            //  调用sayHelloToPerson方法并输出该方法的返回值
            Object[] strings = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes);
            System.out.println(strings.length);
            for(Object ss : Arrays.asList(strings)){
                System.out.println(ss);
            }
            System.out.println();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

}
