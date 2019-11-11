package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.CourseDto;
import com.yb.onlineexamserver.mbg.model.Course;

import java.util.List;

public interface CourseDao {

    List<CourseDto> queryCourses(String name, Integer majorId);

}
