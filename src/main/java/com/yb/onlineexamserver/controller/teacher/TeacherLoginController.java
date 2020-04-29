package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.TeacherLoginInfo;
import com.yb.onlineexamserver.service.teacher.TeacherLoginService;
import com.yb.onlineexamserver.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yb
 * @description 教师登录接口
 * @data 2020/4/29
 */
@RestController
public class TeacherLoginController {
    @Autowired
    private TeacherLoginService teacherLoginService;

    @PostMapping("/teacher/login")
    public CommonResult teacherLogin(@RequestBody @Valid TeacherLoginInfo teacherLoginInfo){
        TeacherVo teacherVo = teacherLoginService.login(teacherLoginInfo);
        return CommonResult.success(teacherVo);
    }

    @GetMapping("/teacher/logout")
    public CommonResult teacherLogout(@RequestParam("teacherId") String teacherId){
        return CommonResult.success();
    }
}
