package com.company.design.proxy;

public class AopBrowser implements IBrowser{

    private String url;
    private Browser browser;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }


    @Override
    public Html show() {
        before.run();

        if (html == null) {
            System.out.println("AOP calls browser.");
            this.browser = new Browser(url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            after.run();
            this.html = this.browser.show();
        } else {
            after.run();
            String msg = url + " html is showed by AOP using cache.";
            Integer length = msg.length();
            System.out.println(msg);
            System.out.println("=".repeat(length));
        }

        return this.html;
    }
}
