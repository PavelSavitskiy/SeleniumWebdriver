package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest {
    private static PropertiesReader confPropReader = new PropertiesReader();
    private String cartSection = "/cart";
    private static Response response;
    private String flipDomain = confPropReader.getProperties("homepageFlipKz");
    private String currentConnection = confPropReader.getProperties("connection");
    private String currentContentType = confPropReader.getProperties("content-type");
    private int expectedLinksQuantity = 526;
    private int expectedStatusCode = 200;

        @Test
        public void checkStatusCodeTest() throws  IOException {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(flipDomain+cartSection);
            CloseableHttpResponse response = httpclient.execute(httpGet);

            int statusCodeAct = response.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCodeAct, 200);
        }

        @Test
        public void checkResponseContentTest() throws  IOException {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(flipDomain+cartSection);
            CloseableHttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            entity.getContent();

            Gson gson = new Gson();
        }
    }
