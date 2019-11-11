package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.dto.CourseDto;
import com.yb.onlineexamserver.mbg.model.Course;
import com.yb.onlineexamserver.requestparams.CourseParams;

public interface TeacherCourseService {
    int insertCourses(CourseParams courseParams);

    int deleteCourses(Integer id);

    Course queryCourseById(Integer id);

    int updateCourses(Integer id, CourseParams courseParams);

    Page<CourseDto> queryCourses(String name, Integer majorId, Integer page, Integer pageSize);
}
