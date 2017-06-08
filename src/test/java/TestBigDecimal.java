import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/16.
 */
public class TestBigDecimal {
    public static void main(String[] args) {
//        BigDecimal amount = new BigDecimal("654445.00");
//        System.out.println(amount.divide(new BigDecimal("10000"), 2, RoundingMode.HALF_UP));

//        String timeStamp = new java.sql.Timestamp(System.currentTimeMillis()).toString();
//        System.out.println(timeStamp);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String serialNumber = sdf.format(date);
        System.out.println(serialNumber);
    }
}
