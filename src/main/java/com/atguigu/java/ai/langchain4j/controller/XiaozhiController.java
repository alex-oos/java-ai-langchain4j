package com.atguigu.java.ai.langchain4j.controller;

import com.atguigu.java.ai.langchain4j.Assistant.StreamAssistant;
import com.atguigu.java.ai.langchain4j.Assistant.XiaozhiAgent;
import com.atguigu.java.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

/**
 * @author Alex
 * @since 2025/4/23 11:22
 * <p></p>
 */
@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {

    @Autowired
    private XiaozhiAgent xiaozhiAgent;

    @Autowired
    private StreamAssistant streamAssistant;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {

        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }

    @Operation(summary = "流式对话")
    @PostMapping(value = "/stream/chat", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestBody ChatForm chatForm) {

        return streamAssistant.chat(chatForm.getMemoryId(), chatForm.getMessage());

    }

}
