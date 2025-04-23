package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.Assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alex
 * @since 2025/4/23 11:24
 * <p></p>
 */
@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools() {

        String answer = separateChatAssistant.chat(1, "1+2等于几，475695037565的平方根是多 少？"); //答案：3，689706.4865
        System.out.println(answer);
    }

}
