/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.spring.demo.web.config;

import java.time.LocalTime;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author Naveedur Rahman
* @email naveed6464@gmail.com
 * @version 1.0
 * @since Jan 20, 2020
 */
@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        String clientMessage = message.getPayload();
        if (clientMessage.startsWith("hello") || clientMessage.startsWith("greet")) {
            session.sendMessage(new TextMessage("Hello there!"));
        } else if (clientMessage.startsWith("time")) {
            LocalTime currentTime = LocalTime.now();
            session.sendMessage(new TextMessage(currentTime.toString()));
        } else {
            session.sendMessage(new TextMessage("Unknown command"));
        }
    }
}
