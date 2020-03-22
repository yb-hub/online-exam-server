package com.yb.onlineexamserver.controller.student;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.service.student.StudentProfileService;
import com.yb.onlineexamserver.vo.StudentProfileScoreDetailVo;
import com.yb.onlineexamserver.vo.StudentProfileScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/17 19:47
 * @Description: 学生个人信息模块
 */
@RestController
public class StudentProfileController {
    @Autowired
    private StudentProfileService studentProfileService;
    @GetMapping("/student/profile/stuScore/{id}")
    public CommonResult queryStudentScore(@PathVariable("id") String studentId){
        List<StudentProfileScoreVo> studentProfileScoreVos = studentProfileService.queryStudentScoreById(studentId);
        return CommonResult.success(studentProfileScoreVos);
    }
    @GetMapping("/student/profile/stuScore/detail/{id}")
    public CommonResult queryStudentScoreDetail(@PathVariable("id") String examId){
        StudentProfileScoreDetailVo studentProfileScoreDetailVo = studentProfileService.queryStudentScoreDetailById(examId);
        return CommonResult.success(studentProfileScoreDetailVo);
    }
}
