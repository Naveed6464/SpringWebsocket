/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.spring.demo.web.config;

import java.io.File;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;

/**
 *
 * @author Naveedur Rahman
 * @email nmarahman@alinma.com
 * @version 1.0
 * @since Jan 20, 2020
 */
public class AIBot {

    public static void main(String[] args) {
        //https://howtodoinjava.com/ai/java-aiml-chatbot-example/
        String request = "Hi";
        String configFile = "config.properties";
        String path = AIBot.class.getClassLoader().getResource(configFile).toExternalForm();
        path = path.replace(configFile, "").replace("file:/", "");
        Bot bot = new Bot("super", path);
        Chat chatSession = new Chat(bot);
        if (MagicBooleans.trace_mode) {
            System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
        }

        String response = chatSession.multisentenceRespond(request);
        while (response.contains("&lt;")) {
            response = response.replace("&lt;", "<");
        }
        while (response.contains("&gt;")) {
            response = response.replace("&gt;", ">");
        }
        System.out.println("Robot : " + response);
    }

}
