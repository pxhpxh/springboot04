package com.example.springboot04;

import com.example.springboot04.util.Base64;
import com.example.springboot04.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

@SpringBootTest
class Springboot04ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void test1() {
        System.out.println(123);
    }



    @Test
    void test2() {
        Vector v = new Vector(10);

        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }

        for(int i = 0 ; i < v.size() ; i++){
            System.out.println(v.get(i));
        }

    }


    @Test
    void test3() {
        Math.round(1);

        double  a = (double)  101555l / 1000;
        String sign = MD5Util.MD5Code("aa","UTF-8");
        System.out.println(sign.length());

        System.out.println(a);

    }

    @Test
    void test4() {
        String basic = "";
        String  appName = "移动办公系统";
        String  appCode= "OAMobileApp_key";
        String ticket="c59f0605-fe7a-415a-bf68-8201b427d795";
        try {
            String  base64_appName = Base64.encodeString(appName);
            //Long timeStamp = new Date().getTime() / 1000 ;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Long timeStamp = sdf.parse("2020-01-01 08:00:00").getTime() / 1000;
            String sign = MD5Util.MD5Code(base64_appName+"|"+appCode+"|"+timeStamp+"|"+ticket,"UTF-8");
            basic =  base64_appName + "|" + timeStamp + "|" + sign;
            System.out.println(base64_appName);
            System.out.println(basic);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
