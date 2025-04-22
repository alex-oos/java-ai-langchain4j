package com.atguigu.java.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alex
 * @since 2025/4/22 23:39
 * <p></p>
 */
@SpringBootTest
public class LLMTest {

    @Autowired
    private OpenAiChatModel model;

    @Test
    public void testGPTDemo() {

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("你好");
        System.out.println(answer);


    }

    @Test
    public void testSpringboot() {

        String answer = model.chat("你是谁？");
        System.out.println(answer);


    }

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void testOllama() {

        String answer = ollamaChatModel.chat("你好");
        System.out.println(answer);


    }

    /**
     * 通义千问大模型
     */
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testDashboardQwen() {

        String answer = qwenChatModel.chat("你好");
        System.out.println(answer);

    }

    /**
     * 万象大模型，画图
     */
    @Test
    public void testDashboardWanx() {

        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .apiKey("sk-83493f6b46b248c5a3a008dca639ac55")
                .modelName("wanx2.1-t2i-turbo")
                .build();
        Response<Image> imageResponse = wanxImageModel.generate("画一张美女");
        Image content = imageResponse.content();
        System.out.println(content.url());
    }



}
