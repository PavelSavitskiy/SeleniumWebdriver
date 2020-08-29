package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.parsed.objects.Link;
import com.epam.cdp.kzta2020.utils.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    private static PropertiesReader confPropReader = new PropertiesReader();
    private String cartSection = "/cart";
    private static Response response;
    private String flipDomain = confPropReader.getProperties("homepageFlipKz");
    private String currentConnection = confPropReader.getProperties("connection");
    private String currentContentType = confPropReader.getProperties("content-type");
    private int expectedLinksQuantity = 526;
    private int expectedStatusCode = 200;

    @BeforeTest
    public void initDomain() {
        RestAssured.baseURI = flipDomain;
    }

    @BeforeMethod
    public void choseCartPage() {
        response = given().get(cartSection).andReturn();
    }

    @Test(description = "Confirm that the page sends a response with a correct code")
    public void checkStatusCode() {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode,
                "The value of 'Status code' is incorrect");
    }

    @Test(description = "Confirm that 'Content-type' header's value equals to defined one")
    public void checkResponseContentTypeHeader() {
        String valueOfContentTypeHeader = response.getHeader("content-type");
        Assert.assertTrue(valueOfContentTypeHeader.contains(currentContentType),
                "The value of 'Content-type' header is incorrect");
    }

    @Test(description = "Confirm that 'Connection' header's value equals to defined one")
    public void checkResponseConnectionHeader() {
        String valueOfContentTypeHeader = response.getHeader("connection");
        Assert.assertTrue(valueOfContentTypeHeader.contains(currentConnection),
                "The value of 'Connection' header is incorrect");
    }

    @Test
    public void checkLinksQuantity() {
        Document document = Jsoup.parse(response.asString());
        ArrayList<Link> links = new ArrayList<>();
        int counter = 1;
        for (Element element : document.getElementsByAttribute("href")) {
            if (!element.text().equals("")) {
                links.add(new Link(element.text(), counter));
                counter++;
            }
        }
        for (Link link : links) {
            System.out.println(link.toString());
        }
        Assert.assertEquals(links.size(), expectedLinksQuantity,
                "Quantity of links on page is incorrect ");
    }
}