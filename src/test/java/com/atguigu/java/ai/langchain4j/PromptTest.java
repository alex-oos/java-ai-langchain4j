package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.Assistant.MemoryChatAssistant;
import com.atguigu.java.ai.langchain4j.Assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alex
 * @since 2025/4/23 10:53
 * <p></p>
 */
@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;


    @Test
    public void testSystemMessage() {

        String chat = separateChatAssistant.chat(1, "今天几号");
        System.out.println(chat);
    }

    @Test
    public void testUserMessage() {

        String chat = memoryChatAssistant.chat("我是坏坏");
        System.out.println(chat);
    }

    @Test
    public void testV() {

        String answer1 = separateChatAssistant.chat2(1, "我是环环");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(1, "我是谁");
        System.out.println(answer2);
    }

    @Test
    public void testUserInfo() {

        String answer = separateChatAssistant.chat3(1, "我是谁，我多大了", "翠花", 18);
        System.out.println(answer);
    }

}
