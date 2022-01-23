package com.company.design;

import com.company.design.adapter.*;
import com.company.design.proxy.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        /* Singleton
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

         */

        /* Adapter
        HairDryer hairDryer = new HairDryer();
        plugIn(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        plugIn(adapter);
         */


        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();

        IBrowser browserProxy = new BrowserProxy("www.naver.com");
        browserProxy.show();
        browserProxy.show();


        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
            );

        aopBrowser.show();
        System.out.println("========================= loading time: " + end.get());

        aopBrowser.show();
        System.out.println("================================ loading time: " + end.get());

    }

    // Adapter
    public static void plugIn(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
