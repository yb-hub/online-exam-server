package com.yb.onlineexamserver.service.teacher.impl;

import com.yb.onlineexamserver.common.enums.subjectenums.SubjectEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.mbg.mapper.SubjectMapper;
import com.yb.onlineexamserver.mbg.model.Subject;
import com.yb.onlineexamserver.mbg.model.SubjectExample;
import com.yb.onlineexamserver.requestparams.SubjectParams;
import com.yb.onlineexamserver.service.teacher.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:57
 * @Description:
 */
@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public int insertSubjects(SubjectParams subjectParams) throws OnlineExamException {
        if(checkIsExist(subjectParams)){
            throw new OnlineExamException(SubjectEnums.SUBJECT_IS_EXIST);
        }
        Subject subject = new Subject();
        subject.setCreateTime(LocalDateTime.now());
        subject.setUpdateTime(LocalDateTime.now());
        subject.setName(subjectParams.getName());
        return subjectMapper.insert(subject);
    }

    private boolean checkIsExist(SubjectParams subjectParams) {
        SubjectExample example = new SubjectExample();
        example.createCriteria().andNameEqualTo(subjectParams.getName());
        List<Subject> subjects = subjectMapper.selectByExample(example);
        return subjects.size()!=0;
    }
}
