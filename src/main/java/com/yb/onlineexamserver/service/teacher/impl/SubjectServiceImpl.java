package com.yb.onlineexamserver.service.teacher.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yb.onlineexamserver.common.enums.subjectenums.SubjectEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.SubjectDao;
import com.yb.onlineexamserver.dto.SubjectSimpleDto;
import com.yb.onlineexamserver.mbg.mapper.SubjectMapper;
import com.yb.onlineexamserver.mbg.model.Subject;
import com.yb.onlineexamserver.mbg.model.SubjectExample;
import com.yb.onlineexamserver.requestparams.SubjectParams;
import com.yb.onlineexamserver.service.teacher.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:57
 * @Description:
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public int insertSubjects(SubjectParams subjectParams){
        if(checkIsExist(subjectParams)){
            throw new OnlineExamException(SubjectEnums.SUBJECT_IS_EXIST);
        }
        Subject subject = new Subject();
        subject.setCreateTime(LocalDateTime.now());
        subject.setUpdateTime(LocalDateTime.now());
        subject.setName(subjectParams.getName());
        return subjectMapper.insert(subject);
    }

    @Override
    public int deleteSubjectsById(Integer id) {
        querySubjectById(id);
        return subjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Subject querySubjectById(Integer id) {
        Subject subject = subjectMapper.selectByPrimaryKey(id);
        if(subject == null){
            throw new OnlineExamException(SubjectEnums.SUBJECT_NOT_FOUND);
        }
        return subject;
    }

    @Override
    public int updateSubjects(Integer id,SubjectParams subjectParams) {
        querySubjectById(id);
        Subject subject = new Subject(id, subjectParams.getName(), null, LocalDateTime.now());
        return subjectMapper.updateByPrimaryKeySelective(subject);
    }

    @Override
    public Page<Subject> querySubjects(String name, Integer page, Integer pageSize) {
        SubjectExample example = new SubjectExample();
        if(!StringUtils.isEmpty(name)){
            example.createCriteria().andNameLike("%"+name+"%");
        }
        PageHelper.startPage(page, pageSize);
        Page<Subject> subjects = (Page<Subject>) subjectMapper.selectByExample(example);
        return subjects;
    }

    private boolean checkIsExist(SubjectParams subjectParams) {
        SubjectExample example = new SubjectExample();
        example.createCriteria().andNameEqualTo(subjectParams.getName());
        List<Subject> subjects = subjectMapper.selectByExample(example);
        return subjects.size()!=0;
    }

    @Override
    public List<SubjectSimpleDto> querySubjectsSimple() {
        return subjectDao.querySubjectsSimple();
    }
}
