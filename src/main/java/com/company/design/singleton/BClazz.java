package com.company.design.singleton;

public class BClazz {
    private SocketClient socketClient;

    public BClazz() {
         this.socketClient = SocketClient.getInstance();
        // this.socketClient = new SocketClient(); → 각자 생성으로 false
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
