package com.zlq.springaidemo.controller;


import com.zlq.springaidemo.service.SpringAiChatRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class CustomServiceController {
    private final ChatClient serviceChatClient;

    private final SpringAiChatRecordService recordService;

    @RequestMapping(value = "/service", produces = "text/html;charset=utf-8")
    //非流式
    public String service(String prompt, String chatId) {
        // 1.保存会话id
        recordService.saveRecord("service", chatId);
        // 2.请求模型
        return serviceChatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .content();
    }
}
