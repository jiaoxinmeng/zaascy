import com.netcenter.zaascy.util.LoginStub;

/**
 * Created by Administrator on 2017/3/22.
 */
public class TestWsdl {
    public static void main(String[] args) {
        try {
            LoginStub ls = new LoginStub();
            LoginStub.Login ll = new LoginStub.Login();
            String token = "tMqwR1mR4doflVSmpc9g+ZmNYZfdy7/kTQH3QLbajtA=";
            ll.setToken(token);
            System.out.println(ls.login(ll).get_return());
            //true则登录
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
