package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import com.yb.onlineexamserver.common.enums.studentenums.StudentEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.student.StudentDao;
import com.yb.onlineexamserver.mbg.mapper.StudentMapper;
import com.yb.onlineexamserver.mbg.model.Student;
import com.yb.onlineexamserver.mbg.model.StudentExample;
import com.yb.onlineexamserver.requestparams.student.StudentUpdateParams;
import com.yb.onlineexamserver.requestparams.student.StudentUpdatePwdParams;
import com.yb.onlineexamserver.service.student.StudentService;
import com.yb.onlineexamserver.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yb
 * @description
 * @data 2020/4/26
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private StudentDao studentDao;

    @Override
    public StudentVo updateStudent(String studentId, StudentUpdateParams studentUpdateParams) {
        Student student = new Student();
        BeanUtils.copyProperties(studentUpdateParams,student);
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        studentMapper.updateByExampleSelective(student,example);
        //查询更新后的学生信息
        return studentDao.queryStudentById(studentId);
    }

    @Override
    public void updatePassword(String studentId, StudentUpdatePwdParams studentUpdatePwdParams) {
        //查询用户是否存在，即确认密码是否正确
        Student student = studentDao.queryStudentByStudentIdAndPwd(studentId, studentUpdatePwdParams.getPassword());
        if(student == null){
            throw new OnlineExamException(StudentEnums.STUDENT_NOT_FOUND);
        }
        //修改密码
        studentDao.updatePassword(studentId,studentUpdatePwdParams.getNewPassword());
    }
}
