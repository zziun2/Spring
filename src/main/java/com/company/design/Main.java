package com.company.design;

import com.company.design.adapter.*;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
        // singleton Main
        /*
        AClazz aclazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient)); // true
         */

        // adapter Main
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V cleanerAdapter = new SocketAdapter(cleaner); // adapter를 통해서 cleaner 연결
        connect(cleanerAdapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }

    // 콘센트
    // main이 static이므로 static이여야 함.
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
