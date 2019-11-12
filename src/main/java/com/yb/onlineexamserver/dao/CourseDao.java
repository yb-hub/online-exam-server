package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.CourseDto;
import com.yb.onlineexamserver.mbg.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDao {

    List<CourseDto> queryCourses(@Param("name") String name,@Param("majorId") Integer majorId);

}
