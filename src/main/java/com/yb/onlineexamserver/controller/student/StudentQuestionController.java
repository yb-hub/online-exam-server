package com.yb.onlineexamserver.controller.student;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.student.StudentQuestionParams;
import com.yb.onlineexamserver.service.student.StudentQuestionService;
import com.yb.onlineexamserver.vo.QuestionVo;
import com.yb.onlineexamserver.vo.StudentQuestionCollectionVo;
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
        List<StudentQuestionCollectionVo> questionIdList = studentQuestionService.queryStudentQuestionCollectByStudentId(studentId);
        return CommonResult.success(questionIdList);
    }

    @GetMapping("/student/question/collect/type/{id}")
    public CommonResult queryStudentQuestionCollectByQuestionType(@PathVariable("id") String studentId,
                                                                  @RequestParam("questionType") Integer questionType){
        List<StudentQuestionCollectionVo> studentQuestionCollectionVos = studentQuestionService.queryStudentQuestionCollectByQuestionType(studentId, questionType);
        return CommonResult.success(studentQuestionCollectionVos);
    }

    @GetMapping("/student/question/{questionId}")
    public CommonResult queryQuestionByQuestionId(@PathVariable("questionId") String questionId){
        QuestionVo questionVo = studentQuestionService.queryQuestionByQuestionId(questionId);
        return CommonResult.success(questionVo);
    }
}
