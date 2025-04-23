package com.atguigu.java.ai.langchain4j.Assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author Alex
 * @since 2025/4/23 01:29
 * <p></p>
 */
// 因为我们配置了多个大模型语音，所以需要指定使用哪个大模型
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);

}
