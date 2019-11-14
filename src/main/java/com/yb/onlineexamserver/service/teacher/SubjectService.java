package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.vo.SubjectSimpleVo;
import com.yb.onlineexamserver.mbg.model.Subject;
import com.yb.onlineexamserver.requestparams.SubjectParams;
import java.util.List;

public interface SubjectService {
    int insertSubjects(SubjectParams subjectParams) throws OnlineExamException;

    int deleteSubjectsById(Integer id);

    Subject querySubjectById(Integer id);

    int updateSubjects(Integer id,SubjectParams subjectParams);

    Page<Subject> querySubjects(String name, Integer page, Integer pageSize);

    List<SubjectSimpleVo> querySubjectsSimple();
}
