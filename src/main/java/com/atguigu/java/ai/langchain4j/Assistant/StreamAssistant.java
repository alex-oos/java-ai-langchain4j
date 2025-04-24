package com.atguigu.java.ai.langchain4j.Assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author Alex
 * @since 2025/4/24 15:27
 * <p></p>
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel", chatMemoryProvider = "chatMemoryProviderXiaozhi")
public interface StreamAssistant {

    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);

}
