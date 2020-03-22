package com.yb.onlineexamserver.controller.student;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.student.StudentQuestionParams;
import com.yb.onlineexamserver.service.student.StudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/23 19:28
 * @Description: 考生错题
 */
@RestController
public class StudentQuestionController {
    @Autowired
    private StudentQuestionService studentQuestionService;
    @PutMapping("/student/question/collect")
    public CommonResult updateStudentQuestionCollect(@RequestBody StudentQuestionParams studentQuestionParams){
        if(studentQuestionParams.getIsCollect() == 0){
            //取消收藏
            studentQuestionService.deleteStudentQuestionCollect(studentQuestionParams.getStudentId(),studentQuestionParams.getQuestionId());
        }else{
            //收藏题目
            studentQuestionService.insertStudentQuestionCollect(studentQuestionParams.getStudentId(),studentQuestionParams.getQuestionId());
        }
        return CommonResult.success();
    }
    @GetMapping("/student/question/collect/{id}")
    public CommonResult queryStudentQuestionCollectByStudentId(@PathVariable("id") String studentId){
        List<String> questionIdList = studentQuestionService.queryStudentQuestionCollectByStudentId(studentId);
        return CommonResult.success(questionIdList);
    }
}
