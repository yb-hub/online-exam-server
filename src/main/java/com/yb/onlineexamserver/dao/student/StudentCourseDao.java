package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.vo.CourseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentCourseDao {
    List<CourseVo> queryCourses(String name);
}
