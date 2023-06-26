package com.company.design.singleton;

public class SocketClient {
    // 싱글톤은 자기 자신을 객체로 가지고 있어야 함.
    private static SocketClient socketClient = null;
    
    // private으로 막고 getInstance 사용
    // public SocketClient(){} 와 AClazz와 BClazz 각자 생성 시 false
    private SocketClient() {

    }
    
    public static SocketClient getInstance() {
        if(socketClient == null) {
           socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
