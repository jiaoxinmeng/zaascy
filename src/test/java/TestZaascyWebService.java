import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.netcenter.zaascy.util.ZaascyStub;
import org.apache.axis2.AxisFault;

public class TestZaascyWebService {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ZaascyStub zaasStub = new ZaascyStub();
            ZaascyStub.GetZaasCodeListByZaasTechType zsg = new ZaascyStub.GetZaasCodeListByZaasTechType();
            ZaascyStub.GetZaasTechNameByZaascode zsgz = new ZaascyStub.GetZaasTechNameByZaascode();
            zsg.setZaasTechType("实用技术");
            zsg.setDepartId(0);
            zsg.setYear(2015);
            zsgz.setZaasCode("2015JS046");
            String[] str = zaasStub.getZaasCodeListByZaasTechType(zsg).get_return();
            //String str2 = zaasStub.getZaasTechNameByZaascode(zsgz).get_return();
            if(str==null||str.length==0){
                System.out.println("没有找到对应的结果集");
            }else{
                for(String ss : Arrays.asList(str)){
                    System.out.println(ss);
                }
            }


            //System.out.println(str);
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        RPCServiceClient serviceClient = null;
//        try {
//            serviceClient = new RPCServiceClient();
//
//            Options options = serviceClient.getOptions();
//            //  指定调用WebService的URL
//            EndpointReference targetEPR = new EndpointReference("http://192.168.68.130:8080/njycg/services/zaascy?wsdl");
//            options.setTo(targetEPR);
//            //  指定sayHelloToPerson方法的参数值
//            Object[] opAddEntryArgs = new Object[] {"实用技术","123","2016"};
//            //  指定sayHelloToPerson方法返回值的数据类型的Class对象
//            Class[] classes = new Class[] {String.class};
//            //  指定要调用的sendSms方法及WSDL文件的命名空间
//            QName opAddEntry = new QName("http://ws.axis2Example/", "getZaasCodeListByZaasTechType");
//            //  调用sayHelloToPerson方法并输出该方法的返回值
//            Object[] strings = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes);
//            System.out.println(strings.length);
//            for(Object ss : Arrays.asList(strings)){
//                System.out.println(ss);
//            }
//            System.out.println();
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        }
    }

}
