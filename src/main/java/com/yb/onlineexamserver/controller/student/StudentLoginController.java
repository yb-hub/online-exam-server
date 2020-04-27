package com.yb.onlineexamserver.controller.student;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.service.student.StudentLoginService;
import com.yb.onlineexamserver.vo.StudentVo;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: Yang
 * @Date: 2020/04/04 17:39
 * @Description: 学生登录注册模块
 */
import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.requestparams.student.StudentLoginInfo;
import com.yb.onlineexamserver.requestparams.student.StudentUpdateParams;
import com.yb.onlineexamserver.requestparams.student.StudentUpdatePwdParams;
import com.yb.onlineexamserver.service.student.StudentService;
import org.springframework.web.bind.annotation.*;

/**
 * @author yb
 * @description 登录接口
 * @data 2020/4/26
 */
@RestController
public class StudentLoginController {
    @Autowired
    private StudentLoginService studentLoginService;
    @Autowired
    private StudentService studentService;

    /**
     * 使用spring security代替
     * @param studentLoginInfo
     * @return
     */
    @PostMapping("/student/login")
    public CommonResult login(@RequestBody @Valid StudentLoginInfo studentLoginInfo){
        StudentVo studentVo = studentLoginService.login(studentLoginInfo);
        return CommonResult.success(studentVo);
    }

    @PutMapping("/student/password/{studentId}")
    public CommonResult updatePassword(@PathVariable("studentId") String studentId,@RequestBody @Valid StudentUpdatePwdParams studentUpdatePwdParams){
        String newPassword = studentUpdatePwdParams.getNewPassword();
        String newPasswordConfirm = studentUpdatePwdParams.getNewPasswordConfirm();
        if(!newPassword.equals(newPasswordConfirm)){
            throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"两次密码不一致");
        }
        studentService.updatePassword(studentId,studentUpdatePwdParams);
        return CommonResult.success();
    }
    @PutMapping("/student/{studentId}")
    public CommonResult updateStudent(@PathVariable("studentId") String studentId,@RequestBody @Valid  StudentUpdateParams studentUpdateParams){
        StudentVo studentVo = studentService.updateStudent(studentId, studentUpdateParams);
        return CommonResult.success(studentVo);
    }

}
