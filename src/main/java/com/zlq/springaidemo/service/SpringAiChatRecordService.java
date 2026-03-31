package com.zlq.springaidemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlq.springaidemo.entity.po.SpringAiChatRecord;

import java.util.List;

public interface SpringAiChatRecordService extends IService<SpringAiChatRecord> {

    void saveRecord(String type, String conversionId);

    List<String> findConversationIds(String type);
}