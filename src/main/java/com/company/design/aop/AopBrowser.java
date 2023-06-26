package com.company.design.aop;

import com.company.design.proxy.Html;
import com.company.design.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;

    // Runnable : run 메서드만 존재
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
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);
            try {
                Thread.sleep(1500); // 메소드 자체가 빠를 수 있음
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        after.run();
        System.out.println("AopBrowser html cache : " + url);
        return null;
    }
}
