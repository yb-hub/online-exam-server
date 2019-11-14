package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.vo.MajorVo;
import com.yb.onlineexamserver.vo.MajorSimpleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorDao {
    List<MajorVo> queryMajors(@Param("name") String name, @Param("subjectId") Integer subjectId);

    List<MajorSimpleVo> queryMajorsSimple();
}
