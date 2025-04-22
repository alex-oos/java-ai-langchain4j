package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.Assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author Alex
 * @since 2025/4/23 01:44
 * <p></p>
 */
@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    Assistant assistant;

    @Test
    public void testChatMemory() {

        String answer1 = assistant.chat("我是坏坏");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory2() {
//第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是环环");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
//输出大语言模型的回复
        System.out.println(aiMessage1.text());
//第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1,
                aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
//输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

}
