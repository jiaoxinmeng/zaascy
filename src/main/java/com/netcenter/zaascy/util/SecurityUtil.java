package com.netcenter.zaascy.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SecurityUtil {

    private static final String Algorithm = "DES/CBC/PKCS5Padding";
    private static final byte[] bytes = {'e', '+', 's', 'u', '%', '*', '4', 'O'};
    private static final byte[] key = {'d', 'e', '#', '$', '%', '^', '7', 'l'};
    //new String("de$%^@#-").getBytes();
    private static SecretKey deskey = new SecretKeySpec(key, "DES");
    private static IvParameterSpec ivSpec = new IvParameterSpec(bytes);

    private SecurityUtil() {
    }

    public static String encryptMessage(String s) throws Exception {
        if (s == null) return null;
        //加密
        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(Cipher.ENCRYPT_MODE, deskey, ivSpec);
        byte[] cipherByte = c1.doFinal(s.getBytes());
        BASE64Encoder base64encoder = new BASE64Encoder();
        return base64encoder.encode(cipherByte);
    }

    public static String decryptMessage(String s) throws Exception {
        if (s == null) return null;
        //解密
        BASE64Decoder base64decoder = new BASE64Decoder();
        byte cipherByte[] = base64decoder.decodeBuffer(s);
        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(Cipher.DECRYPT_MODE, deskey, ivSpec);
        byte[] clearByte = c1.doFinal(cipherByte);
        String rs = new String(clearByte);
        return rs;
    }

    public static String createToken(int len) {
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        int rdGet;//取得随机数
        //23
        char[] str_dowm = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k',
                'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
        //23
        char[] str_up = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
                'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'};
        //8
        char[] str_num = {'2', '3', '4', '5', '6', '7', '8', '9'};

        //首先随机生成各部分令牌的长度
        //-2因为令牌最少要有一个大写字母和数字
        int len_down = rd.nextInt(len - 2) + 1;
        int len_up = rd.nextInt(len - len_down - 1) + 1;
        int len_num = len - len_down - len_up;
        System.out.println("令牌总长度:" + len + " 小写字母个数:" + len_down + " 大写字母个数:" + len_up + " 数字个数:" + len_num);

        //生成小写字母部分
        for (int count = 0; count < len_down; count++) {
            rdGet = Math.abs(rd.nextInt(str_dowm.length));
            if (rdGet >= 0 && rdGet < str_dowm.length) {
                sb.append(str_dowm[rdGet]);
//                System.out.println("生成的小写字母为:"+str_dowm[rdGet]);
            }
        }

        //生成大写字母部分
        for (int count = 0; count < len_up; count++) {
            rdGet = Math.abs(rd.nextInt(str_up.length));
            if (rdGet >= 0 && rdGet < str_up.length) {
                sb.append(str_up[rdGet]);
//                System.out.println("生成的大写字母为:"+str_up[rdGet]);
            }
        }

        //生成数字部分
        for (int count = 0; count < len_num; count++) {
            rdGet = Math.abs(rd.nextInt(str_num.length));
            if (rdGet >= 0 && rdGet < str_num.length) {
                sb.append(str_num[rdGet]);
//                System.out.println("生成的数字为:"+str_num[rdGet]);
            }
        }

        System.out.println("生成的令牌值域为:" + sb.toString());

        //将得到的密码重新装入数组
        char[] last_pwd = sb.toString().toCharArray();

        //清空字符缓冲区
        sb.delete(0, last_pwd.length);

        //随机乱序
        for (int count = 0; count < last_pwd.length; count++) {
            rdGet = Math.abs(rd.nextInt(last_pwd.length));
            if (rdGet >= 0 && rdGet < last_pwd.length) {
                sb.append(last_pwd[rdGet]);
//                System.out.println("取到的坐标为:"+rdGet+"，生成的字符为:"+last_pwd[rdGet]);
                //为了避免重复，取到一个字符后，将字符从数组中移除，此处将数组最后一位移到删除位，并缩短数组长度
                last_pwd[rdGet] = last_pwd[last_pwd.length - 1];
                last_pwd = Arrays.copyOf(last_pwd, last_pwd.length - 1);
                //数组改变，重新遍历等同于count=0
                count--;
//                System.out.println("此时的数组包含:");
//                for(int i=0;i<last_pwd.length;i++){
//                    System.out.println(last_pwd[i]);
//                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        try {
//          String pwd = SecurityUtil.encryptMessage("11111111");
//          System.out.println(pwd);
        try {
            String rs = SecurityUtil.decryptMessage("kqVbe44FrMo++JE+0gur5g==");//oou16do5
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

//            String pwd = SecurityUtil.createToken(8);
//            System.out.println("生成的随机令牌为:" + pwd);
//            String token = SecurityUtil.encryptMessage(pwd);
//            System.out.println("加密的随机令牌为:" + token + "长度为:" + token.length());
//            String username = "pengyh";
//            String last_token_2 = SecurityUtil.encryptMessage(username + "&" + token);
//            System.out.println("最终传递的令牌为:" + last_token_2 + "长度为:" + last_token_2.length());
//            String last_token_de = SecurityUtil.decryptMessage(last_token_2);
//            System.out.println("客户端第一次解码:" + last_token_de);
//            String[] arr = last_token_de.split("&");
//            if (arr.length == 2) {
//                String username_de = arr[0];
//                System.out.println("客户端得到用户名:" + username_de);
//                String token_de = arr[1];
//                System.out.println("客户端得到的令牌:" + token_de);
//                String token_de_d = SecurityUtil.decryptMessage(token_de);
//                System.out.println("客户端解码的令牌:" + token_de_d);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        long endTime = System.currentTimeMillis();
//        Date startDate = new Date(startTime);
//        Date endDate = new Date(endTime);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
//        System.out.println("程序结束时间：" + sdf.format(endDate));
//        System.out.println("程序开始时间：" + sdf.format(startDate));
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }


}
