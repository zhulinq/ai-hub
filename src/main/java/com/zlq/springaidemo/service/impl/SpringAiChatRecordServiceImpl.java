package com.zlq.springaidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlq.springaidemo.entity.po.SpringAiChatRecord;
import com.zlq.springaidemo.mapper.SpringAiChatRecordMapper;
import com.zlq.springaidemo.service.SpringAiChatRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpringAiChatRecordServiceImpl extends ServiceImpl<SpringAiChatRecordMapper, SpringAiChatRecord> implements SpringAiChatRecordService {
    @Override
    public void saveRecord(String type, String conversionId) {
        // 1. 判断记录是否存在
        Long count = this.lambdaQuery()
                .eq(SpringAiChatRecord::getId, conversionId)
                .count();
        if (count != null && count > 0) {
            // 记录已存在，结束
            return;
        }
        // 2. 保存记录
        SpringAiChatRecord record = new SpringAiChatRecord();
        record.setType(type);
        record.setId(conversionId);
        // TODO userId暂时写死, 后续会从session中获取
        record.setUserId(1L);
        // TODO 会话标题暂时用会话id, 后续可以根据会话内容生成
        record.setTitle(conversionId);
        record.setCreateTime(LocalDateTime.now());
        save(record);
    }
    @Override
    public List<String> findConversationIds(String type) {
        return this.getBaseMapper().findConversationIds(type, 1L);
    }
}
