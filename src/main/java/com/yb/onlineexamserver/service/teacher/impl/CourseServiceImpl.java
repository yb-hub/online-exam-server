package com.yb.onlineexamserver.service.teacher.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yb.onlineexamserver.common.enums.courseenums.CourseEnums;
import com.yb.onlineexamserver.common.enums.majorenums.MajorEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.CourseDao;
import com.yb.onlineexamserver.vo.CourseVo;
import com.yb.onlineexamserver.mbg.mapper.CourseMapper;
import com.yb.onlineexamserver.mbg.mapper.MajorMapper;
import com.yb.onlineexamserver.mbg.model.Course;
import com.yb.onlineexamserver.mbg.model.Major;
import com.yb.onlineexamserver.requestparams.CourseParams;
import com.yb.onlineexamserver.service.teacher.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2019/11/11 09:34
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public int insertCourses(CourseParams courseParams) {
        Integer majorId = courseParams.getMajorId();
        Major major = majorMapper.selectByPrimaryKey(majorId);
        if(major == null){
            throw new OnlineExamException(MajorEnums.MAJOR_NOT_FOUND);
        }
        Course course = new Course();
        BeanUtil.copyProperties(courseParams, course);
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());
        return courseMapper.insert(course);
    }

    @Override
    public int deleteCourses(Integer id) {
        queryCourseById(id);
        //todo:是否有试卷拥有此课程
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Course queryCourseById(Integer id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        if(course == null){
            throw new OnlineExamException(CourseEnums.COURSE_NOT_FOUND);
        }
        return course;
    }

    @Override
    public int updateCourses(Integer id, CourseParams courseParams) {
        queryCourseById(id);
        Course course = new Course();
        BeanUtil.copyProperties(courseParams, course);
        course.setId(id);
        course.setUpdateTime(LocalDateTime.now());
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public Page<CourseVo> queryCourses(String name, Integer majorId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<CourseVo> courseVos = (Page<CourseVo>) courseDao.queryCourses(name,majorId);
        return courseVos;
    }
}
