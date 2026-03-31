package com.zlq.springaidemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlq.springaidemo.entity.po.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
