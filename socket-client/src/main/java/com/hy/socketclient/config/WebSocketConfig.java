package com.hy.socketclient.config;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Auther: liaoshiyao
 * @Date: 2019/1/11 17:38
 * @Description: 配置websocket后台客户端
 */
@Slf4j
@Component
public class WebSocketConfig {

    private static String url="ws://localhost:8085/websocket/Tibot_";

    @Bean
    public WebSocketClient webSocketClient() throws URISyntaxException {
        MySocketClient webSocketClient = new MySocketClient(new URI(url));
        webSocketClient.connect();
        return webSocketClient;
    }

    public static void testConnect() throws URISyntaxException {
        MySocketClient webSocketClient = new MySocketClient(new URI(url));
        while (!webSocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {//获取连接状态
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("重连中");
            webSocketClient.connect();
        }
    }

}