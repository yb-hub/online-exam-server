package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.MajorDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorDao {
    List<MajorDto> queryMajors(@Param("name") String name,@Param("subjectId") Integer subjectId);
}
