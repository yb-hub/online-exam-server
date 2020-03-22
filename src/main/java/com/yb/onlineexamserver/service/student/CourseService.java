package com.yb.onlineexamserver.service.student;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.vo.CourseSimpleVo;
import com.yb.onlineexamserver.vo.CourseVo;

import java.util.List;

public interface CourseService {
    List<CourseVo> queryCourses(String name);

    List<CourseSimpleVo> queryCoursesWrongByStudentId(String studentId);
}
