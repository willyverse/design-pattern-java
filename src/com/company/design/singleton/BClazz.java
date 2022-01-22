package com.company.design.singleton;

import java.net.Socket;

public class BClazz {

    private SocketClient socketClient;

    public BClazz() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
