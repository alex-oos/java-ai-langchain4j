package com.atguigu.java.ai.langchain4j.Assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author Alex
 * @since 2025/4/23 01:29
 * <p></p>
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);

}
