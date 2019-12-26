package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.vo.CourseSimpleVo;
import com.yb.onlineexamserver.vo.CourseVo;
import com.yb.onlineexamserver.mbg.model.Course;
import com.yb.onlineexamserver.requestparams.CourseParams;

import java.util.List;

public interface CourseService {
    int insertCourses(CourseParams courseParams);

    int deleteCourses(Integer id);

    Course queryCourseById(Integer id);

    int updateCourses(Integer id, CourseParams courseParams);

    Page<CourseVo> queryCourses(String name, Integer majorId, Integer page, Integer pageSize);

    List<CourseSimpleVo> queryCoursesSimple();
}
