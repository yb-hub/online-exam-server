package com.yb.onlineexamserver.controller.student;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.student.StudentLoginParams;
import com.yb.onlineexamserver.service.student.StudentLoginService;
import com.yb.onlineexamserver.vo.StudentLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Auther: Yang
 * @Date: 2020/04/04 17:39
 * @Description: 学生登录注册模块
 */
@RestController
public class StudentLoginController {
    @Autowired
    private StudentLoginService studentLoginService;

    /**
     * 学生登录接口
     * @param studentLoginParam
     * @return
     */
    @PostMapping("/student/login")
    public CommonResult login(@Valid @RequestBody StudentLoginParams studentLoginParam){
        StudentLoginVo loginVo = studentLoginService.login(studentLoginParam);
        return CommonResult.success(loginVo);
    }
}
