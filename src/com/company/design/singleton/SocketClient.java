package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    //default 생성자를 막음
    private SocketClient() {

    }

    // get instance 메소드를 만듦
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
