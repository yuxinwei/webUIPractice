package com.test.java.interfaceTest;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
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