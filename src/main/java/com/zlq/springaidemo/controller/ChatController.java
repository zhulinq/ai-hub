package com.zlq.springaidemo.controller;


import com.zlq.springaidemo.service.SpringAiChatRecordService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {

    @Resource
    private final ChatClient openAiChatClient;


    @Autowired
    private SpringAiChatRecordService springAiChatRecordService;


    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(
            @RequestParam(defaultValue = "介绍你自己") String prompt,
            @RequestParam("chatId") String chatId) {
        springAiChatRecordService.saveRecord("chat", chatId);
        return openAiChatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }

}
