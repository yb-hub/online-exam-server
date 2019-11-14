package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.vo.SubjectSimpleVo;

import java.util.List;

public interface SubjectDao {
    List<SubjectSimpleVo> querySubjectsSimple();
}
