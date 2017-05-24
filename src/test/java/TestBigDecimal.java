import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Administrator on 2017/5/16.
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("654445.00");
        System.out.println(amount.divide(new BigDecimal("10000"), 2, RoundingMode.HALF_UP));
    }
}
