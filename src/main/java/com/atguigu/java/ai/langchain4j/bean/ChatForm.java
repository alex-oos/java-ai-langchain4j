package com.atguigu.java.ai.langchain4j.bean;

import lombok.Data;

/**
 * @author Alex
 * @since 2025/4/23 11:21
 * <p></p>
 */
@Data
public class ChatForm {

    private Long memoryId;//对话id

    private String message;//用户问题

}
