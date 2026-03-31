package com.zlq.springaidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlq.springaidemo.entity.po.CourseReservation;
import com.zlq.springaidemo.mapper.CourseReservationMapper;
import com.zlq.springaidemo.service.ICourseReservationService;
import org.springframework.stereotype.Service;

@Service
public class CourseReservationServiceImpl extends ServiceImpl<CourseReservationMapper, CourseReservation>
implements ICourseReservationService {
}
