/**
 * Created by Administrator on 2017/6/5.
 */
public class Test2 {
    public static long asd(Integer n){
        long result = 0L;
        long result2 = 1L;
        for(int i=1;i<=n;i++){
            result2 = result2 * i;
            result = result + result2;

        }

        return result;
    }

    public static long asd2(int n){
        long result = 0L;

        for(int i=1;i<=n;i++){
            long result2 = 1L;
            for(int j=1;j<i;j++){
                result2 = result2*j;
            }
            result = result + result2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(asd(10));
        System.out.println(asd2(10));
    }
}
