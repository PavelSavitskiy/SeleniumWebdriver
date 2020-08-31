package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.cdp.kzta2020.utils.ResponseUtils.checkHeadersValue;

public class HttpClientTest {
    private CloseableHttpResponse response;
    private String cartSection = "/cart";
    private String flipDomain = confPropReader.getProperties("homepageFlipKz");
    private String currentConnection = confPropReader.getProperties("connection");
    private String currentContentType = confPropReader.getProperties("content-type");
    private int expectedStatusCode = 200;
    private static PropertiesReader confPropReader = new PropertiesReader();


    @BeforeMethod
    public void initHttpClient() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(flipDomain + cartSection);
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Confirm that the page sends a response with a correct code")
    public void checkStatusCodeTest() {
        int statusCodeAct = response.getStatusLine().getStatusCode();

        Assert.assertEquals(statusCodeAct, expectedStatusCode,
                "The value of 'Status code' is incorrect");
    }

    @Test(description = "Confirm that 'Connection' header's value equals to defined one")
    public void checkResponseConnectionHeader() {
        Assert.assertTrue(checkHeadersValue(response, "Connection", currentConnection),
                "The value of 'Connection' header is incorrect");
    }

    @Test(description = "Confirm that 'Content-type' header's value equals to defined one")
    public void checkResponseContentTypeHeader() {
        Assert.assertTrue(checkHeadersValue(response, "Content-Type", currentContentType),
                "The value of 'Content-type' header is incorrect");
    }
}
