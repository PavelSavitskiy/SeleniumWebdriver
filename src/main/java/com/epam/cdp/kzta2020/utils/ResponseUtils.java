package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.parsed.objects.Link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.epam.cdp.kzta2020.parsed.objects.User;
import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import io.restassured.response.Response;

public class ResponseUtils {
    private static User[] users;

    public static ArrayList<Link> getListOfLinksOnPage(Response response) {
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
        return links;
    }

    public static User[] parseJsonToObjects(CloseableHttpResponse response) {
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        users = new Gson().fromJson(bReader, User[].class);
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    public static boolean checkHeadersValue(CloseableHttpResponse response, String key, String currentConnection) {
        Header[] connectionHeader = response.getAllHeaders();
        for (Header header : connectionHeader) {
            if (header.toString().contains(key)) {
                if (header.toString().contains(currentConnection))
                    return true;
                break;
            }
        }
        return false;
    }
}
