package com.netcenter.zaascy.util;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.BarcodeEncoder;
import org.jbarcode.encode.Code39Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2017/5/27.
 */
public class SingleCodeUtil {
    public static void main(String args[]) {

        boolean ss = createsingleImg("B201611111111008","123.jpg","");
        if(ss){
            System.out.println("生成成功");
        }else{
            System.out.println("生成失败");
        }
    }

    public static boolean createsingleImg(String baseCode,String imageName,String path){
        //path = "C:\\Users\\Administrator\\Desktop\\singleCodeImg\\";
        imageName = imageName + ".jpg";

        if(!new File(path).exists()){
            new File(path).mkdirs();
        }
        path = path + imageName;

        FileImageOutputStream imageOutput = null;
        try {
            byte[] by = createDimensionalCode(baseCode);
            imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(by, 0, by.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                imageOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 获取字符串byte字符流
     * @param value
     * @return
     */
    public static byte[] createDimensionalCode(String value) {
        return createCode(Code39Encoder.class, value, false);
    }

    public static byte[] createCode(Class<?> clazz, String value,
                                    boolean checkDigit) {
        try {
            JBarcode localJBarcode = new JBarcode(getUnique(clazz),
                    WidthCodedPainter.getInstance(), EAN13TextPainter
                    .getInstance());
            localJBarcode.setPainter(WideRatioCodedPainter.getInstance());
            localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
            localJBarcode.setCheckDigit(checkDigit);
            localJBarcode.setShowCheckDigit(checkDigit);
            return getImageBytes(localJBarcode.createBarcode(value));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 获取唯一单例的对象
    private static BarcodeEncoder getUnique(Class<?> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> privateConstructor = constructors[0];

        privateConstructor.setAccessible(true);
        return (BarcodeEncoder) privateConstructor.newInstance();
    }

    // 获得图片字节码数组
    private static byte[] getImageBytes(BufferedImage paramBufferedImage)
            throws IOException {
        return ImageUtil.encode(paramBufferedImage, "jpeg", 96, 100);
    }
}
