package com.test.java.interfaceTest;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Restful API Address: http://www.sosoapi.com/pass/apidoc/demo.htm
 * HttpClient example: http://www.mkyong.com/java/apache-httpclient-examples/
 * Apache ORG: https://hc.apache.org/httpcomponents-client-ga/quickstart.html
 * IBM的一篇实例文章 http://www.ibm.com/developerworks/cn/aix/library/au-aix-systemsdirector/
 */
public class SimpleServiceTest {
    @DataProvider(name = "urls")
    public Object[][] getUrls() {
        return new Object[][]{
                {"http://www.sosoapi.com/demo/user/simple/1/info.htm"}
        };
    }

    @DataProvider(name = "postDatas")
    public Object[][] postDatas() {
        return new Object[][]{
                {"http://www.sosoapi.com/demo/user/simple/add.htm", "111", "e33"}
        };
    }

    @DataProvider(name = "delDatas")
    public Object[][] delDatas() {
        return new Object[][]{
                {"http://www.sosoapi.com/demo/user/simple/1/del.htm"}
        };
    }
  
    @Test(dataProvider = "urls")
    public void getTest(String url) throws IOException {
        System.out.println(getJsonRes(url));
    }

    @Test(dataProvider = "postDatas")
    public void postTest(String url, String email, String nickName) throws IOException {
        List<NameValuePair> urlParams = new ArrayList<NameValuePair>();
        urlParams.add(new BasicNameValuePair("email", email));
        urlParams.add(new BasicNameValuePair("nickName", nickName));
        System.out.println(postJsonRes(url, new UrlEncodedFormEntity(urlParams)));
    }

    @Test(dataProvider = "delDatas")
    public void delTest(String url) throws IOException {
        System.out.println(delJsonRes(url));
    }

    private String delJsonRes(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);

        CloseableHttpResponse response = client.execute(delete);
        System.out.println("Response code: " + response.getStatusLine().getStatusCode());

        try {
            String resString = EntityUtils.toString(response.getEntity());
            return JSON.toJSONString(resString);
        } finally {
            client.close();
        }
    }

    private String postJsonRes(String url, HttpEntity entity) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setEntity(entity);

        CloseableHttpResponse response = httpClient.execute(post);
        System.out.println("Response code: " + response.getStatusLine().getStatusCode());
        try {
            String resString = EntityUtils.toString(response.getEntity());
            return JSON.toJSONString(resString);
        } finally {
            response.close();
        }
    }

    private String getJsonRes(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity myEntity = response.getEntity();
            System.out.println(myEntity.getContentType());
            System.out.println(myEntity.getContentLength());

            String resString = EntityUtils.toString(myEntity);
//          打印json串
            return JSON.toJSONString(resString);
        } finally {
            response.close();
        }
    }
  
}  