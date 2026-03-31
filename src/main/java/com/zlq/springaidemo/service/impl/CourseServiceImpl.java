package com.zlq.springaidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlq.springaidemo.entity.po.Course;
import com.zlq.springaidemo.mapper.CourseMapper;
import com.zlq.springaidemo.service.ICourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements
        ICourseService {
}
