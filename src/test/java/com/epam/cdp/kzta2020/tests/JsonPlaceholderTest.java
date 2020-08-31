package com.epam.cdp.kzta2020.tests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.cdp.kzta2020.utils.ResponseUtils.parseJsonToObjects;

public class JsonPlaceholderTest {
    private String jsonPlaceholderUsersDomain = "https://jsonplaceholder.typicode.com/users";
    private CloseableHttpResponse response;
    private int expectedUsersQuantity = 10;

    @BeforeMethod
    public void initHttpClient() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(jsonPlaceholderUsersDomain);
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Confirm that quantity of users is correct")
    public void checkResponseBody() {
        int actualUsersQuantity = parseJsonToObjects(response).length;
        Assert.assertEquals(actualUsersQuantity, expectedUsersQuantity,
                "The quantity of users differs from expected one");
    }
}
