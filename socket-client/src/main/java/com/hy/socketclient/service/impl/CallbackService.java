package com.hy.socketclient.service.impl;

import com.hy.socketclient.response.ChatResponse;
import com.hy.socketclient.service.ChatResponseCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CallbackService implements ChatResponseCallback {

    private Logger logger = LoggerFactory.getLogger(CallbackService.class);

    @Override
    public void callback(ChatResponse chatResponse) {
        logger.info("CallbackService: " + chatResponse);
    }
}
