package com.hy.socketclient.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

@Slf4j
public class MySocketClient extends WebSocketClient {
    public MySocketClient(URI serverUri) {
        super(serverUri);
    }

    //    WebSocketClient webSocketClient = new WebSocketClient(new URI("ws://localhost:8085/websocket/Tibot_"),new Draft_6455()) {
    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log.info("[websocket] 连接成功");
    }

    @Override
    public void onMessage(String message) {
        log.info("[websocket] 收到消息={}", message);

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("[websocket] 退出连接");
    }

    @SneakyThrows
    @Override
    public void onError(Exception ex) {
        log.info("[websocket] 连接错误={}", ex.getMessage());
        WebSocketConfig.testConnect();
    }

}

