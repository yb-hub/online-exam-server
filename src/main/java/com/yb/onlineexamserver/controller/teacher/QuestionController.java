package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import com.yb.onlineexamserver.common.enums.statusenums.QuestionEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.QuestionParam;
import com.yb.onlineexamserver.service.teacher.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 21:39
 * @Description:
 */
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/questions")
    public CommonResult insertQuestions(@RequestBody @Valid QuestionParam questionParam){
        validate(questionParam);
        questionService.insertQuestions(questionParam);
        return CommonResult.success();
    }

    @DeleteMapping("/questions/{id}")
    public CommonResult deleteQuestions(@PathVariable("id") String id){
        questionService.deleteQuestions(id);
        return CommonResult.success();
    }

    @PutMapping("/questions/{id}")
    public CommonResult updateQuestions(@PathVariable("id") String id,@RequestBody @Valid QuestionParam questionParam){
        validate(questionParam);
        questionService.updateQuestions(id,questionParam);
        return CommonResult.success();
    }

    @GetMapping("/questions/{id}")
    public CommonResult queryQuestionsById(@PathVariable("id") String id){
        return CommonResult.success(questionService.queryQuestionsById(id));
    }

    @GetMapping("/questions")
    public CommonResult queryQuestionsList(){
        questionService.queryQuestionsList();
        return null;
    }

    @PostMapping("/questions/elasticsearch")
    public CommonResult insertToElastic(){
        questionService.insertToElastic();
        return CommonResult.success();
    }


    private void validate(QuestionParam questionParam) {
        Integer type = questionParam.getType();
        if(type == QuestionEnums.SIMPLE_QUESTION.getCode() || type == QuestionEnums.MULTI_QUESTION.getCode() ){
            if(StringUtils.isEmpty(questionParam.getOptions()) || StringUtils.isEmpty(questionParam.getRightOption())){
                throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"选择题不能没有选项和答案");
            }
        }
        else if(type == QuestionEnums.JUDGE_QUESTION.getCode()){
            if(StringUtils.isEmpty(questionParam.getJudgeAnswer())){
                throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"选择题不能没有选项和答案");
            }
        }else{
            throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"客观题只有单选，多选和判断题");
        }
    }

}
