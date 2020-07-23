package com.hy.socketclient.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import javax.sound.midi.Soundbank;
import java.net.URI;
import java.net.URISyntaxException;


@Slf4j
public class WebSocketConfig {

    private static String url = "ws://localhost:8085/websocket/Tibot_";

    public WebSocketClient webSocketClient() throws URISyntaxException {
        MySocketClient webSocketClient = new MySocketClient(new URI(url));
        webSocketClient.connect();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!webSocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {//获取连接状态
            log.info("重连中");
            webSocketClient = reConnect();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (webSocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN))
                break;
        }
        return webSocketClient;
    }

    public static MySocketClient reConnect() throws URISyntaxException {
        MySocketClient webSocketClient = new MySocketClient(new URI(url));
        webSocketClient.connect();
        return webSocketClient;
    }

//    public static void main(String[] args) throws Exception {
//        MySocketClient webSocketClient = new MySocketClient(new URI("ws://localhost:8085/websocket/Tibot_"));
//        webSocketClient.connect();
//        System.out.println(webSocketClient.getReadyState());
//        Thread.sleep(1000);
//        System.out.println(webSocketClient.getReadyState());
//    }
}