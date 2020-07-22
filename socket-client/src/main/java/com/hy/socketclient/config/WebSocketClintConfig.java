package com.hy.socketclient.config;

import org.java_websocket.client.WebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@Configuration
public class WebSocketClintConfig {

    @Bean
    public WebSocketClient webSocketClient() throws URISyntaxException {

        return new WebSocketConfig().webSocketClient();
    }
}
