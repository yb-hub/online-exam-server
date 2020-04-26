package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.common.enums.studentenums.StudentEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.student.StudentDao;
import com.yb.onlineexamserver.mbg.mapper.StudentMapper;
import com.yb.onlineexamserver.mbg.model.Student;
import com.yb.onlineexamserver.mbg.model.StudentExample;
import com.yb.onlineexamserver.requestparams.student.StudentLoginParams;
import com.yb.onlineexamserver.service.student.StudentLoginService;
import com.yb.onlineexamserver.vo.StudentLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/04/04 17:49
 * @Description:
 */
@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentDao studentDao;
    @Override
    public StudentLoginVo login(StudentLoginParams studentLoginParam) {
        String studentId = studentLoginParam.getStudentId();
        String password = studentLoginParam.getPassword();
        StudentLoginVo studentLoginVo = studentDao.queryStudentByStudentIdAndPwd(studentId,password);
        if(studentLoginVo == null){
            throw new OnlineExamException(StudentEnums.NOT_EXIST);
        }else{
            return studentLoginVo;
        }
    }
}
