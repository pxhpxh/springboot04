package com.example.springboot04.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot04.util.*;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;
import org.thymeleaf.util.MapUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.*;
import java.util.*;
import java.util.Date;

@Controller
public class TestController {

    @RequestMapping("/test1")
    public void danDianLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Date date = new Date();
        String yyyyMMddHHmmss = "20120202111122";


        System.out.println("进入了登录跳转前的方法");
        String loginName = "pxh";

        //String key = UUIDUtil.getAbsUUIDLong()+"";
        loginName = TextEncoder.encode(loginName);
        loginName = URLEncoder.encode(loginName,"UTF-8");
        response.sendRedirect("127.0.0.1:8090"+ "/seeyon/login/sso?from=scjdj&ticket="+loginName+"&UserAgentFrom=pc");
    }

    @RequestMapping("/test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String parameter = request.getParameter("parm1");
        Date date = new Date();
        String yyyyMMddHHmmss = "20120202111122";

        response.setHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        System.out.println("进入了登录跳转前的方法");
        String loginName = "pxh";

        //String key = UUIDUtil.getAbsUUIDLong()+"";
        loginName = TextEncoder.encode(loginName);
        loginName = URLEncoder.encode(loginName,"UTF-8");
        Map map = new HashMap<>();
        map.put("loginName","12adpd碰下");
        response.getWriter().write(JSON.toJSONString(map));
    }


    @PostMapping("/jeecg-boot/bce/bceIntraPayReq/bcePaymentReqForOa")
    public void bcePaymentReqForOa(HttpServletRequest request, HttpServletResponse response , @RequestBody Map<String,Object> payReqData) throws Exception {
        //String  payReqData1 = URLDecoder.decode(request.getParameter("payReqData"),"UTF-8") ;
        String  payReqData1 = JSON.toJSONString(payReqData);


        //String  aa = URLDecoder.decode(request.getParameter("aa"),"UTF-8") ;
       // System.out.println(aa);
        Map<String,Object> map = JSON.parseObject(payReqData1,Map.class);
        System.out.println(map);
        Map map2 = (Map) map.get("head");
        System.out.println(map2.get("tranId"));
        PrintWriter writer = response.getWriter();
        writer.write(payReqData1);
    }


    @PostMapping("/jeecg-boot/bce/bceIntraPayReq/bcePaymentReqForOa1")
    public void bcePaymentReqForOa(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String  payReqData1 = URLDecoder.decode(request.getParameter("payReqData"),"UTF-8") ;
        //String  payReqData1 = JSON.toJSONString(payReqData);


        //String  aa = URLDecoder.decode(request.getParameter("aa"),"UTF-8") ;
        // System.out.println(aa);
        Map<String,Object> map = JSON.parseObject(payReqData1,Map.class);
        System.out.println(map);
        Map map2 = (Map) map.get("head");
        System.out.println(map2.get("tranId"));
        PrintWriter writer = response.getWriter();
        writer.write(payReqData1);
    }


    @PostMapping("/uapws/rest/user/login")
    public void getToken(HttpServletRequest request, HttpServletResponse response , @RequestBody Map<String,Object> payReqData,
                         @RequestHeader Map<String, String> headers) throws Exception {
        //String  payReqData1 = URLDecoder.decode(request.getParameter("payReqData"),"UTF-8") ;
        String  payReqData1 = JSON.toJSONString(payReqData);
        Map<String,Object> map = new HashMap<>();
        map.putAll(payReqData);
        map.put("token","123");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(map));
    }

    @PostMapping("/uapws/rest/oa/hr/psndocquery")
    public void psndocquery(HttpServletRequest request, HttpServletResponse response , @RequestBody Map<String,Object> payReqData,
                            @RequestHeader Map<String, String> headers) throws Exception {
        //String  payReqData1 = URLDecoder.decode(request.getParameter("payReqData"),"UTF-8") ;
        String  payReqData1 = JSON.toJSONString(payReqData);
        System.out.println(headers);
        response.setHeader("Content-Type","application/json;charset=utf8");

        //String  aa = URLDecoder.decode(request.getParameter("aa"),"UTF-8") ;
        // System.out.println(aa);
        Map<String,Object> map = new HashMap<>();
        map.put("success",Boolean.TRUE);
        Map<String,Object> subMap1 = new HashMap<>();
        subMap1.put("code","阿达123");
        subMap1.put("montye","撒旦回复");

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(subMap1);
        list.add(subMap1);
        list.add(subMap1);
        map.put("data",list);
        PrintWriter writer = response.getWriter();
        writer.write(JSONObject.toJSONString(map));
    }


    @RequestMapping("/test/getData")
    public void getToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data = "{\"resultFlag\":0,\"errorMsg\":\"读卡正常\",\"venderId\":10008,\"signature\":\"2e52226118054be6cddd5ee9d4b02478d5d63b28\",\"resultContent\":{\"certType\":1,\"partyName\":\"孙世杰\",\"gender\":1,\"nation\":\"汉\",\"bornDay\":\"19860618\",\"certAddress\":\"重庆市渝北区横街支巷6号3单元8-1\",\"certNumber\":\"500112198606188470\",\"certOrg\":\"重庆市公安局渝北分局\"," +
                "\"effDate\":\"20120629\",\"expDate\":\"20320629\",\"identityPic\":\"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\",\"identityPhotoSrc\":\"V0xmAH4AMgAA/4UDUVFRPnEN1WTzOopgkbtuxZSAuPjGMIZ734YIntr4m0WAnMtlAIKoULc/t+FoO0ngHAzhFnDnp9X8ZopIvrFACWmD1Znsf8Z+FxP2W707eZc03osRrtBSUVFaPoFguc9iitPrT06v4qk11JJ4Uol8PShRLIP7jOcf2O+R5VkTEQeDDy0Ybs8e9tNSht0+UlKLpmk8iypp8di8Y97XyKbtLUDnASytbFOQAJjxEdwcDiLwuWLfDQ2683o6BeCw/6BTsk/x8bwpF0PFNLTzJixVJlIx368eJ9edsnP7tlxOW8Q1DeJr11REMSILO12gkbyKJVauUSbdHfkS2qN2k6bFSEU2dss4Klb/DVTyKeKyTmhDInVUjXni88Ha0MnT23AottG6N05W5m7lWwXgXzc854VRDjcRsuEN9SkqjBMuhZ65N7t9O1fXcD9mp3F3MJg+HLcnSKWefyRAGlJeB7FaX8ZSj/CJZREsWIO00Zirzg5JQb/a26kIyOBCraWbOliZCTLNK56gbNeB1/TRC52HC5PXRpOD7f5p7z+p8l9oDuC3Dhc73s8VHJk7TzQYLwzk5jGerGJ05FYr1jOMZ6+MDC5n8lnwrlGtIIIEzM648U/MvBKJN5nZeC1VPYcoi1C607dEXS0oSy7RrlE7UFs55gPSJRKAwmSs9ot4fIGcGPpJ8wKhndaX04klBNHjOmUxYMZEDHFxAPih3M6p9ubrPdSRnNqo56hlP0NoESa+rJJtpsYyVJWkRNH7Hk1tTVdTCPZN7V6j9M2+xlsiBJ929ig09Qx3D8oSMAGneErjHwka1dgf1LaEVcB0XKbRUehdQJdGBOVP6hxeFSXS9DuhJTypkUOhaBcsN23FLWnKX8zooLSE/HDiZ7PLwEImmF78998RukZoEvojY7iktVafDLCvmM+q2xoQOzzyOxI1hHmcaKDUg1woF+rLGNegQ3YsvmEtIGkSbUPjgbNGmMbbTQewgkOllXgnHE65/JPqnG76jrqiTY2UH3ikKX2xqPnF4b3Go0Vy/KGeS4MRN9FJYY936M16TI26TcRGEUlBTTq8woS7WUReeK1jzr1wOdthexWOMsTIV9famHVO/26RCuxtDIQJ6xBm5nNJOzmi5ysff1soGu9FQ1+rWj4JaHzwLFS/ZglQ4nl/8/F4YNsKUpnvSOaAdzkz0cYNee3hiBuiN4jgqM2oEBmgHGmPD8rBwwEcquGGUHGUIFhzype63k0F8SoX7E9MoWwdWj6EtKDGz3lubJnutKwrqtoU6SI9r/ZCGnjbvXWZPCX0xE/elh6UA4UN2Yah0qmtD/7qiZn6bqC5dz5eKQGnM/kR35JYxEqhKQ==\"}}";
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Content-Type","application/json;charset=utf8");
        PrintWriter writer = response.getWriter();
        writer.write(data);
    }

    @ResponseBody
    @PostMapping("/test/testDate")
    public String testDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data = "{\"resultFlag\":0,\"errorMsg\":\"读卡正常\",\"venderId\":10008,\"signature\":\"2e52226118054be6cddd5ee9d4b02478d5d63b28\",\"resultContent\":{\"certType\":1,\"partyName\":\"孙世杰\",\"gender\":1,\"nation\":\"汉\",\"bornDay\":\"19860618\",\"certAddress\":\"重庆市渝北区横街支巷6号3单元8-1\",\"certNumber\":\"500112198606188470\",\"certOrg\":\"重庆市公安局渝北分局\"," +
                "\"effDate\":\"20120629\",\"expDate\":\"20320629\",\"identityPic\":\"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\",\"identityPhotoSrc\":\"V0xmAH4AMgAA/4UDUVFRPnEN1WTzOopgkbtuxZSAuPjGMIZ734YIntr4m0WAnMtlAIKoULc/t+FoO0ngHAzhFnDnp9X8ZopIvrFACWmD1Znsf8Z+FxP2W707eZc03osRrtBSUVFaPoFguc9iitPrT06v4qk11JJ4Uol8PShRLIP7jOcf2O+R5VkTEQeDDy0Ybs8e9tNSht0+UlKLpmk8iypp8di8Y97XyKbtLUDnASytbFOQAJjxEdwcDiLwuWLfDQ2683o6BeCw/6BTsk/x8bwpF0PFNLTzJixVJlIx368eJ9edsnP7tlxOW8Q1DeJr11REMSILO12gkbyKJVauUSbdHfkS2qN2k6bFSEU2dss4Klb/DVTyKeKyTmhDInVUjXni88Ha0MnT23AottG6N05W5m7lWwXgXzc854VRDjcRsuEN9SkqjBMuhZ65N7t9O1fXcD9mp3F3MJg+HLcnSKWefyRAGlJeB7FaX8ZSj/CJZREsWIO00Zirzg5JQb/a26kIyOBCraWbOliZCTLNK56gbNeB1/TRC52HC5PXRpOD7f5p7z+p8l9oDuC3Dhc73s8VHJk7TzQYLwzk5jGerGJ05FYr1jOMZ6+MDC5n8lnwrlGtIIIEzM648U/MvBKJN5nZeC1VPYcoi1C607dEXS0oSy7RrlE7UFs55gPSJRKAwmSs9ot4fIGcGPpJ8wKhndaX04klBNHjOmUxYMZEDHFxAPih3M6p9ubrPdSRnNqo56hlP0NoESa+rJJtpsYyVJWkRNH7Hk1tTVdTCPZN7V6j9M2+xlsiBJ929ig09Qx3D8oSMAGneErjHwka1dgf1LaEVcB0XKbRUehdQJdGBOVP6hxeFSXS9DuhJTypkUOhaBcsN23FLWnKX8zooLSE/HDiZ7PLwEImmF78998RukZoEvojY7iktVafDLCvmM+q2xoQOzzyOxI1hHmcaKDUg1woF+rLGNegQ3YsvmEtIGkSbUPjgbNGmMbbTQewgkOllXgnHE65/JPqnG76jrqiTY2UH3ikKX2xqPnF4b3Go0Vy/KGeS4MRN9FJYY936M16TI26TcRGEUlBTTq8woS7WUReeK1jzr1wOdthexWOMsTIV9famHVO/26RCuxtDIQJ6xBm5nNJOzmi5ysff1soGu9FQ1+rWj4JaHzwLFS/ZglQ4nl/8/F4YNsKUpnvSOaAdzkz0cYNee3hiBuiN4jgqM2oEBmgHGmPD8rBwwEcquGGUHGUIFhzype63k0F8SoX7E9MoWwdWj6EtKDGz3lubJnutKwrqtoU6SI9r/ZCGnjbvXWZPCX0xE/elh6UA4UN2Yah0qmtD/7qiZn6bqC5dz5eKQGnM/kR35JYxEqhKQ==\"}}";
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Content-Type","application/json;charset=utf8");
        Map<String,String> ret = new HashMap<>();
        ret.put("code","0");
        ret.put("mst","大苏打");
        Thread.sleep(1000 * 60 * 5);
        System.out.println(123456);
        return  JSON.toJSONString(ret);
    }

    @RequestMapping("/test/getu8cData")
    public void getu8cData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Map<String,Object>>  retDataList = new ArrayList<>();
        Connection con = SJDBCAgent.getConnection("Oracle", "192.168.31.27",
                "1521", "ORCL", "u8c", "u8c");
        Statement statement  = null;
        ResultSet rs = null;
        try {
            statement = con.createStatement();
            String sql = "SELECT  de.pk_detail MXID, max(de.pk_voucher) PZID , max(de.prepareddatev)  ZDDATE,\n" +
                    "max(de.localcreditamount) DFJE,max(de.localdebitamount) YSJE,max(de.discardflagv) ZFFLAG,max(de.dr) DELEFLAG,\n" +
                    "max(de.explanation) ZY  , \n" +
                    "max(TY.vouchtypename||' '||de.nov )  GZPZH  , max(book.glorgbookcode) GZZT,\n" +
                    "\n" +
                    "max(CASE  WHEN free.checktype = '00010000000000000073' THEN  free.valuename  ELSE  ''  END)  YSDW ,\n" +
                    "max(CASE  WHEN free.checktype = '00010000000000000002' THEN  free.valuename  ELSE  ''  END) BMDA \n" +
                    "from   gl_detail   de\n" +
                    "LEFT JOIN    bd_vouchertype  ty on  DE.PK_VOUCHERTYPEV = TY.PK_VOUCHERTYPE\n" +
                    "LEFT JOIN    bd_glorgbook  book  on  DE.pk_glorgbook = book.pk_glorgbook\n" +
                    "LEFT JOIN   bd_glorg   gl on book.pk_glorg    = GL.pk_glorg  and  DE.pk_glorg = book.pk_glorg\n" +
                    "LEFT JOIN  GL_FREEVALUE free  on  de.assid  = free.freevalueid \n" +
                    "LEFT JOIN  bd_accsubj  bj  on  bj.pk_accsubj = De.pk_accsubj\n" +
                    "WHERE  de.discardflagv = 'N' and   de.dr = '0'  \n" +
                    "GROUP BY de.pk_detail\n" +
                    "ORDER BY    ZDDATE desc ,  GZPZH ,  PZID ";
            // 4.execute()方法执行SQL，得到一个ResultSet结果集
            rs = statement.executeQuery(sql);
            // 5.通过遍历ResultSet结果集得到数据，给POJO赋值处理数据，最终返回POJO
            while (rs.next()) {
                Map<String,Object> map = new HashMap<>();
                map.put("mxId",rs.getString("MXID"));
                map.put("ysje",rs.getString("YSJE"));
                retDataList.add(map);
            }
            System.out.println(retDataList);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6、关闭资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }




    @RequestMapping("/test/kp")
    public void testKp(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String kpInfo = "{\"type\":\"4\",\"buyerTel\":\"0358-3053345\",\"fpType\":\"-9156018013302206750\",\"naturalPersonFlag\":\"0\",\"buyerBankAccount\":\"621700002000678\",\"fpGroupNo\":\"4\",\"buyerName\":\"北京票通信息技术有限公司\",\"buyerAddress\":\"北京海淀区万泉庄路\",\"invoiceIssueKindCode\":\"82\"," +
                "\"buyerBankName\":\"建设银行\",\"invoiceReqSerialNo\":\"SCPT2309191355114j21\",\"buyerTaxpayerNum\":\"92110108MA0043365M\",\"drawerName\":\"pxh\"," +
                "\"itemList\":[{\"unitPrice\":\"100.00\",\"taxRateAmount\":\"8.26\",\"taxRateValue\":\"0.09\",\"specificationModel\":\"规格12\",\"quantity\":\"1\"," +
                "\"invoiceAmount\":\"100.00\",\"taxClassificationCode\":\"1010101020000000000\",\"includeTaxFlag\":1,\"goodsName\":\"货运粮食\",\"meteringUnit\":\"次\"}]," +
                "\"taxpayerNum\":\"500102201007206608\"}";
        String context = DesECBUtil.encryptDES(kpInfo,"abcd=1234");

        String pars = "";
        pars += "code=X1hVH8X6";
        pars += "&content=" + URLEncoder.encode(context);
        pars += "&serialNo=X1hVH8X6" + Datetimes.format(new Date(),Datetimes.datetimeStyle);
        pars += "&timestamp=" + Datetimes.format(new Date(),Datetimes.datetimeStyle);
        pars += "&version=1.0";
        pars += "&sign=123456";
        pars += "&code1=哈德的第三方";
        //https://a3u3946727.yicp.fun/kf1034/login
        String ret = HttpClientUtil.sendPost("http://localhost:8086/kf1034/api/addInvoice.do", pars);
      //  String ret = HttpClientUtil.sendPost("http://211.149.136.84:6270/kf1034/api/addInvoice.do", pars);

        System.out.println("132456");







    }















}
