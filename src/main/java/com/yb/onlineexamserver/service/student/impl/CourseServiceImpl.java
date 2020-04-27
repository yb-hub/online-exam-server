package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.dao.student.StudentCourseDao;
import com.yb.onlineexamserver.service.student.CourseService;
import com.yb.onlineexamserver.vo.CourseSimpleVo;
import com.yb.onlineexamserver.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/09 19:51
 * @Description:
 */
@Service("studentCourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private StudentCourseDao studentCourseDao;
    @Override
    public List<CourseVo> queryCourses(String name) {
        List<CourseVo> courseVos = studentCourseDao.queryCourses(name);
        return courseVos;
    }

    @Override
    public List<CourseSimpleVo> queryCoursesWrongByStudentId(String studentId) {
        return studentCourseDao.queryCoursesWrongByStudentId(studentId);
    }
}
