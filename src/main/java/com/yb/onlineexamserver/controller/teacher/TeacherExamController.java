package com.yb.onlineexamserver.controller.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.service.teacher.TeacherExamresultService;
import com.yb.onlineexamserver.vo.ExamResultChartVo;
import com.yb.onlineexamserver.vo.ExamResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yb
 * @description
 * @data 2020/4/29
 */
@RestController
public class TeacherExamController {

    @Autowired
    private TeacherExamresultService teacherExamresultService;


    @GetMapping("/teacher/examresult")
    public CommonResult queryExamresult(@RequestParam(value = "studentId",required = false) String studentId,
                                        @RequestParam(value = "paperId",required = false) Integer paperId,
                                        @RequestParam(value = "page",defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit",defaultValue = "10") Integer limit){
        Page<ExamResultVo> examResultVos = teacherExamresultService.queryExamresult(studentId,paperId,page,limit);
        return CommonResult.successList(examResultVos);
    }

    @GetMapping("/teacher/examresult/chart/{paperId}")
    public CommonResult queryExamresultChartData(@PathVariable("paperId") Integer paperId){
        List<ExamResultChartVo> examResultChartVos = teacherExamresultService.queryExamresultChartData(paperId);
        return CommonResult.success(examResultChartVos);
    }
}
