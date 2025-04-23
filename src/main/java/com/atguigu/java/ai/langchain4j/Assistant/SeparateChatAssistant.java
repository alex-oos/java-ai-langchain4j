package com.atguigu.java.ai.langchain4j.Assistant;

/**
 * @author Alex
 * @since 2025/4/23 10:25
 * <p></p>
 */

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 隔离聊天记忆
 */
@AiService(wiringMode = EXPLICIT, chatMemory = "chatMemory", chatMemoryProvider = "chatMemoryProvider", chatModel = "qwenChatModel",tools = "calculatorTools")
public interface SeparateChatAssistant {

    /*** 分离聊天记录
     * @param memoryId 聊天id
     * @param userMessage 用户消息
     * @return **/
    // 系统提示词
    //@SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")
    //系统提示词，使用模版
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我的好朋友，请用粤语回答问题。{{message}}")
    String chat2(@MemoryId int memoryId, @V("message") String userMessage);

    @SystemMessage(fromResource = "my-prompt-template3.txt")
    String chat3( @MemoryId int memoryId, @UserMessage String userMessage, @V("username") String username, @V("age") int age );

}
