package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

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
            /*
            HairDryer hairDryer = new HairDryer();
            connect(hairDryer);

            Cleaner cleaner = new Cleaner();
            Electronic110V cleanerAdapter = new SocketAdapter(cleaner); // adapter를 통해서 cleaner 연결
            connect(cleanerAdapter);

            AirConditioner airConditioner = new AirConditioner();
            Electronic110V airAdapter = new SocketAdapter(airConditioner);
            connect(airAdapter);
             */

        // proxy Main
        /*
            Browser browser = new Browser("www.naver.com");

            // 매번 로딩
            browser.show();
            browser.show();
            browser.show();
            browser.show();
            browser.show();
         */

        // proxy
        IBrowser new_browser = new BrowserProxy("www.naver.com");
        new_browser.show();
        new_browser.show();
        new_browser.show();
        new_browser.show();
        new_browser.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        // AOP
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()-> { // 람다식
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get()); // 몇 초 걸렸는지
                }
        );

        aopBrowser.show();
        System.out.println("loding time : " + end.get());

        aopBrowser.show();
        System.out.println("loding time : " + end.get()); // 두 번째는 0초
    }

    // 콘센트
    // main이 static이므로 static이여야 함.
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
