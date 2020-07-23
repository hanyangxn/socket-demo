package com.hy.socketclient.service;

import com.hy.socketclient.response.ChatResponse;


public interface ChatResponseCallback {
    void callback(ChatResponse event);
}