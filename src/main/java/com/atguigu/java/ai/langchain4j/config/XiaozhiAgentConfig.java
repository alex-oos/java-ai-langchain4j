package com.atguigu.java.ai.langchain4j.config;

import com.atguigu.java.ai.langchain4j.mapper.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alex
 * @since 2025/4/23 11:20
 * <p></p>
 */
@Configuration
public class XiaozhiAgentConfig {

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean
    ChatMemoryProvider chatMemoryProviderXiaozhi() {

        //return memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(20).build();
        return memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(20).chatMemoryStore(mongoChatMemoryStore).build();
    }

}
