package com.epam.cdp.kzta2020.parsed.objects;

public class Link {
    private String text;
    int id;
    public Link(String text, int id){
        this.text =text;
        this.id =id;
    }

    @Override
    public String toString() {
        return "Link "+id + " text= " + text  ;
    }
}
