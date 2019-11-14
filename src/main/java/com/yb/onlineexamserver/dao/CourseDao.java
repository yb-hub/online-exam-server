package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.vo.CourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDao {

    List<CourseVo> queryCourses(@Param("name") String name, @Param("majorId") Integer majorId);

}
