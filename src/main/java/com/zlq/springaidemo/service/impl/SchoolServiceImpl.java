package com.zlq.springaidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlq.springaidemo.entity.po.School;
import com.zlq.springaidemo.mapper.SchoolMapper;
import com.zlq.springaidemo.service.ISchoolService;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {
}
