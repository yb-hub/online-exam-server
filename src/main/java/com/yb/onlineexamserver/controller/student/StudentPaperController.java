package com.yb.onlineexamserver.controller.student;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.student.SubmittedPaperParams;
import com.yb.onlineexamserver.service.student.StudentPaperService;
import com.yb.onlineexamserver.vo.StudentPaperDetailVo;
import com.yb.onlineexamserver.vo.StudentPaperListVo;
import com.yb.onlineexamserver.vo.StudentPaperWrongVo;
import com.yb.onlineexamserver.vo.StudentWrongDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/10 19:19
 * @Description:
 */
@RestController
public class StudentPaperController {
    @Autowired
    private StudentPaperService studentPaperService;

    @GetMapping("student/paper/course/{id}")
    public CommonResult queryPaperByCourseId(@PathVariable("id") Integer id) {
        StudentPaperListVo studentPaperListVo = studentPaperService.queryPaperByCourseId(id);
        return CommonResult.success(studentPaperListVo);
    }

    @GetMapping("/student/paper/detail/{id}")
    public CommonResult queryPaperDetailByPaperId(@PathVariable("id") Integer id){
        StudentPaperDetailVo studentPaperDetailVo = studentPaperService.queryPaperDetailByPaperId(id);
        return CommonResult.success(studentPaperDetailVo);
    }

    @PostMapping("/student/paper/result")
    public CommonResult queryPaperResult(@RequestBody SubmittedPaperParams submittedPaper){
        studentPaperService.insertPaperResult(submittedPaper);
        return CommonResult.success();
    }
    @GetMapping("/student/paper/wrong/{id}")
    public CommonResult queryPaperWrongByStudentId(@PathVariable("id") String studentId,@RequestParam(name = "courseId",required = false) Integer courseId){
        List<StudentPaperWrongVo> studentPaperWrongVos = studentPaperService.queryPaperWrongByStudentId(studentId,courseId);
        return CommonResult.success(studentPaperWrongVos);
    }

    @GetMapping("/student/paper/wrong/detail/{id}")
    public CommonResult queryPaperWrongDetailByExamId(@PathVariable("id") Integer examId){
        StudentWrongDetailVo studentWrongDetailVo = studentPaperService.queryPaperWrongDetailByExamId(examId);
        return CommonResult.success(studentWrongDetailVo);
    }
}