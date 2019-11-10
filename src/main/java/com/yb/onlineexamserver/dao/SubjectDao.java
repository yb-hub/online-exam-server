package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.SubjectSimpleDto;

import java.util.List;

public interface SubjectDao {
    List<SubjectSimpleDto> querySubjectsSimple();
}
