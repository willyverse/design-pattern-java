package com.company.design.proxy;

public class BrowserProxy implements IBrowser{

    private String url;
    private Browser browser;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        if (html == null) {
            System.out.println("Proxy calls browser.");
            this.browser = new Browser(url);
            this.html = this.browser.show();
        } else {
            String msg = url + " html is showed by Proxy using cache.";
            Integer length = msg.length();
            System.out.println(msg);
            System.out.println("=".repeat(length));
        }
        return this.html;
    }
}
