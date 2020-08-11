package com.epam.cdp.kzta2020.business.objects;

public class SearchRequest {
    private String requestString;

    private SearchRequest(String requestString) {
        this.requestString = requestString;
    }

    public String getRequestString() {
        return requestString;
    }

    public static SearchRequest newRequest(String request) {
        return new SearchRequest(request);
    }
}
