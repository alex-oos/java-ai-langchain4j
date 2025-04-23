package com.atguigu.java.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * @author Alex
 * @since 2025/4/23 11:23
 * <p></p>
 */
@Component
public class CalculatorTools {

/*     尚硅⾕
            1.2、

    配值工具类 在SeparateChatAssistant中添加tools属性配置
1.3、测试工具类
    测试后可以查看持久化存储中SYSTEM、USER、AI以及Tools的消息，分析tools的调用流程： */

    /**
     * 如果你的AIService方法中有一个参数使用 @MemoryId 注解，那么你也可以使用 @ToolMemoryId 注解
     *
     * @param memoryId
     * @param a
     * @param b
     * @return
     * @Tool 方法中的一个参数。提供给AIService方法的值将自动传递给 @Tool 方法。如果你有多个用户，
     * 或每个用户有多个聊天记忆，并且希望在 @Tool 方法中对它们进行区分，那么这个功能会很有用。
     */
    @Tool(name = "加法", value = "返回两个参数相加之和")
    double sum(@ToolMemoryId int memoryId, @P(value = "加数1", required = true) double a, @P(value = "加数2", required = true) double b) {

        System.out.println("调用加法运算 " + memoryId);
        return a + b;
    }

    @Tool(name = "平方根", value = "返回给定参数的平方根")
    double squareRoot(@ToolMemoryId int memoryId, double x) {

        System.out.println("调用平方根运算 " + memoryId);
        return Math.sqrt(x);
    }

}
