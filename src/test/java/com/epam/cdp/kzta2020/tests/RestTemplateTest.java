//package com.epam.cdp.kzta2020.tests;
//
//import java.util.List;
//
//import com.epam.cdp.kzta2020.parsed.objects.Link;
//import com.epam.cdp.kzta2020.utils.PropertiesReader;
//import io.restassured.response.Response;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class RestTemplateTest {
//    private static PropertiesReader confPropReader = new PropertiesReader();
//    private String cartSection = "/cart";
//    private static Response response;
//    private String flipDomain = confPropReader.getProperties("homepageFlipKz");
//    private String currentConnection = confPropReader.getProperties("connection");
//    private String currentContentType = confPropReader.getProperties("content-type");
//    private int expectedLinksQuantity = 526;
//    private int expectedStatusCode = 200;
//
//        @Test
//        public void checkStatusCode() {
//            RestTemplate restTeampl = new RestTemplate();
//            ResponseEntity<Link[]> response = restTeampl.get(flipDomain+cartSection,Link[].class);
//            int actualStatusCode = response.getStatusCodeValue();
//            Assert.assertEquals(actualStatusCode, 200);
//        }
//
//        public void checkResponseHeader() {
//            RestTemplate restTeampl = new RestTemplate();
//            ResponseEntity<Post[]> response = restTeampl.getForEntity(flipDomain+cartSection,Post[].class);
//
//            List<String> valueOfContentTypeHeader = response.getHeaders().get("content-type");
//            Assert.assertTrue(valueOfContentTypeHeader.get(0).contains("application/json"));
//        }
//
//        @Test(enabled = false)
//        public void checkResponseBody() {
//            RestTemplate restTeampl = new RestTemplate();
//            ResponseEntity<Post[]> response = restTeampl.getForEntity(flipDomain+cartSection, Post[].class);
//            Assert.assertEquals(response.getBody().length, 100);
//        }
//    }
