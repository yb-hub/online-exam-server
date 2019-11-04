package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.requestparams.SubjectParams;

public interface TeacherSubjectService {
    int insertSubjects(SubjectParams subjectParams) throws OnlineExamException;
}
