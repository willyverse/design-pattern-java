package com.company.design.proxy;

public class Browser implements IBrowser {

    private String url;
    private Html html;

    public Browser(String url) {
        this.url = url;
        this.html = new Html(url);
    }

    @Override
    public Html show() {
        String msg = "Browser is newly loading html: " + url;
        Integer length = msg.length();
        System.out.println(msg);
        System.out.println("=".repeat(length));
        return this.html;
    }
}
