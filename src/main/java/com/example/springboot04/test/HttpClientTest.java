package com.example.springboot04.test;

import com.alibaba.fastjson.JSON;
import com.example.springboot04.Springboot04Application;
import com.example.springboot04.util.HttpClientUtil;
import org.apache.catalina.users.SparseUserDatabase;
import org.apache.http.client.HttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = Springboot04Application.class)
@RunWith(SpringRunner.class)
public class HttpClientTest {


    @Test
    public  void  test1(){
        System.out.println(123456);
        try {
           String ret = HttpClientUtil.get("http://127.0.0.1:8084/test2?parm1=pe彭");
           System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public  void  postForm(){
        System.out.println(123456);
        try {
            Map parmMap = new HashMap<>();
            parmMap.put("payReqData","{\"head\":{\"tranId\":\"20230329092517\",\"apiVersion\":\"1.2.6\",\"reqName\":\"\",\"reqAppId\":\"__UNI__5000458\",\"reqTime\":\"2023-03-29 09:25:17\"},\"body\":{\"OrderLine\":[{\"TaxAmount\":\"0\",\"ExclTaxAmount\":\"1\",\"CurrencyRate\":\"1\",\"CostCenter\":\"\",\"TaxCode\":\"\",\"ClaimingAmount\":\"0\",\"LineNo\":\"1\",\"Remark\":\"测试3-29\"}],\"OrderHead\":{\"BillType\":\"10\",\"Company\":\"1000\",\"SeriesId\":\"SUPAY\",\"CurrencyRate\":\"1\",\"ExpenseRequestName\":\"邓佳菱\",\"Amount\":\"1\",\"CashAccount\":\"BK01001\",\"PaymentUser\":\"-2592094094979022635\",\"FeeTypeCode\":\"\",\"OaFlowId\":\"CGFK202303027\",\"ActualAmount\":\"1\",\"RecCashAccount\":\"80010\",\"ExpenseRequestId\":\"FL00000056\",\"RecCurrencyCode\":\"CNY\",\"CurrencyCode\":\"CNY\",\"PayDate\":\"2023-03-29\",\"SupplierNo\":\"80010\",\"BankType\":\"ICBC\",\"UseOf\":\"测试3-29\"}}}");
            parmMap.put("aa","234");
            String ret = HttpClientUtil.postForm("http://127.0.0.1:8084/jeecg-boot/bce/bceIntraPayReq/bcePaymentReqForOa",parmMap);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    @Test
    public  void  postForm2(){
        System.out.println(123456);
        try {
            String params = "payReqData="+ URLEncoder.encode("{\"head\":{\"tranId\":\"20230329092517\",\"apiVersion\":\"1.2.6\",\"reqName\":\"\",\"reqAppId\":\"__UNI__5000458\",\"reqTime\":\"2023-03-29 09:25:17\"},\"body\":{\"OrderLine\":[{\"TaxAmount\":\"0\",\"ExclTaxAmount\":\"1\",\"CurrencyRate\":\"1\",\"CostCenter\":\"\",\"TaxCode\":\"\",\"ClaimingAmount\":\"0\",\"LineNo\":\"1\",\"Remark\":\"测试3-29\"}],\"OrderHead\":{\"BillType\":\"10\",\"Company\":\"1000\",\"SeriesId\":\"SUPAY\",\"CurrencyRate\":\"1\",\"ExpenseRequestName\":\"邓佳菱\",\"Amount\":\"1\",\"CashAccount\":\"BK01001\",\"PaymentUser\":\"-2592094094979022635\",\"FeeTypeCode\":\"\",\"OaFlowId\":\"CGFK202303027\",\"ActualAmount\":\"1\",\"RecCashAccount\":\"80010\",\"ExpenseRequestId\":\"FL00000056\",\"RecCurrencyCode\":\"CNY\",\"CurrencyCode\":\"CNY\",\"PayDate\":\"2023-03-29\",\"SupplierNo\":\"80010\",\"BankType\":\"ICBC\",\"UseOf\":\"测试3-29\"}}}","UTF-8") ;
            params+= "&aa=123";
            String ret = HttpClientUtil.sendPost("http://127.0.0.1:8084/jeecg-boot/bce/bceIntraPayReq/bcePaymentReqForOa1",params);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public  void  postForm3(){
        System.out.println(123456);
        try {
            Map parmMap = new HashMap<>();
            String params ="{\"head\":{\"tranId\":\"20230329092517\",\"apiVersion\":\"1.2.6\",\"reqName\":\"\",\"reqAppId\":\"__UNI__5000458\",\"reqTime\":\"2023-03-29 09:25:17\"},\"body\":{\"OrderLine\":[{\"TaxAmount\":\"0\",\"ExclTaxAmount\":\"1\",\"CurrencyRate\":\"1\",\"CostCenter\":\"\",\"TaxCode\":\"\",\"ClaimingAmount\":\"0\",\"LineNo\":\"1\",\"Remark\":\"测试3-29\"}],\"OrderHead\":{\"BillType\":\"10\",\"Company\":\"1000\",\"SeriesId\":\"SUPAY\",\"CurrencyRate\":\"1\",\"ExpenseRequestName\":\"邓佳菱\",\"Amount\":\"1\",\"CashAccount\":\"BK01001\",\"PaymentUser\":\"-2592094094979022635\",\"FeeTypeCode\":\"\",\"OaFlowId\":\"CGFK202303027\",\"ActualAmount\":\"1\",\"RecCashAccount\":\"80010\",\"ExpenseRequestId\":\"FL00000056\",\"RecCurrencyCode\":\"CNY\",\"CurrencyCode\":\"CNY\",\"PayDate\":\"2023-03-29\",\"SupplierNo\":\"80010\",\"BankType\":\"ICBC\",\"UseOf\":\"测试3-29\"}}}";

            String params1 = "{" +
                    "\"head\":{" +
                    "\"apiVersion\":\"1.2.8\"," +
                    "\"reqAppId\":\"__UNI__8000458\"," +
                    "\"tranId\":\"20230328150134\"," +
                    "\"reqTime\":\"2023-03-28 15:01:34\"," +
                    "\"reqName\":\"PaymentRequisition\"" +
                    "}," +
                    "\"body\":{" +
                    "\"OrderHead\":{" +
                    "\"OaFlowId\":\"10002\"," +
                    "\"SupplierNo\":\"2001\"," +
                    "\"Company\":\"1000\"," +
                    "\"SeriesId\":\"SUPAY\"," +
                    "\"CashAccount\":\"BANKICBC01\"," +
                    "\"CurrencyCode\":\"CNY\"," +
                    "\"CurrencyRate\":1," +
                    "\"RecCashAccount\":\"BANKSUP01\"," +
                    "\"RecCurrencyCode\":\"CNY\"," +
                    "\"Amount\":\"2000\"," +
                    "\"ActualAmount\":\"2000\"," +
                    "\"UseOf\":\"报销\"," +
                    "\"PayDate\":\"2022-08-25\"," +
                    "\"PaymentUser\":\"IFSAPP\"," +
                    "\"BankType\":\"ICBC\"," +
                    "\"ExpenseRequestId\":\"FL1000002\"," +
                    "\"FeeTypeCode\":\"F014\"," +
                    "\"BillType\":\"20\"" +
                    "}," +
                    "\"OrderLine\":[" +
                    "{" +
                    "\"LineNo\":\"1\"," +
                    "\"ExclTaxAmount\":\"900\"," +
                    "\"TaxAmount\":\"100\"," +
                    "\"ClaimingAmount\":\"1000\"," +
                    "\"TaxCode\":\"N\"," +
                    "\"CostCenter\":\"CWB\"," +
                    "\"Remark\":\"住宿\"" +
                    "}," +
                    "{" +
                    "\"LineNo\":\"2\"," +
                    "\"ExclTaxAmount\":\"900\"," +
                    "\"InclTaxAmount\":\"100\"," +
                    "\"ClaimingAmount\":\"1000\"," +
                    "\"CostCenter\":\"CWB\"," +
                    "\"TaxCode\":\"N\"," +
                    "\"CurrencyRate\":\"1\"," +
                    "\"Remark\":\"交通\"" +
                    "}" +
                    "]" +
                    "}" +
                    "}";
            params1 = params1.replaceAll(" ","") ;

            //String ret = HttpClientUtil.HttpPost("http://127.0.0.1:8084/jeecg-boot/bce/bceIntraPayReq/bcePaymentReqForOa",params);
          String ret = HttpClientUtil.postByBody("http://127.0.0.1:8084/jeecg-boot/bce/bceIntraPayReq/bcePaymentReqForOa1",params1);

          System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
