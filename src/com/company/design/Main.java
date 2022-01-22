package com.company.design;

import com.company.design.adapter.*;

public class Main {

    public static void main(String[] args) {
        /*
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

         */

        HairDryer hairDryer = new HairDryer();
        plugIn(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        plugIn(adapter);

    }

    public static void plugIn(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
