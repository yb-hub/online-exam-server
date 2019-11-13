package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import com.yb.onlineexamserver.common.enums.statusenums.QuestionEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.QuestionParam;
import com.yb.onlineexamserver.service.teacher.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        Integer type = questionParam.getType();
        if(type == QuestionEnums.SIMPLE_QUESTION.getCode() || type == QuestionEnums.MULTI_QUESTION.getCode() ){
            if(StringUtils.isEmpty(questionParam.getOptions()) || StringUtils.isEmpty(questionParam.getRightOption())){
                throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"选择题必须不能没有选项和答案");
            }
        }
        if(type == QuestionEnums.JUDGE_QUESTION.getCode()){
            if(StringUtils.isEmpty(questionParam.getJudgeAnswer())){
                throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"选择题必须不能没有选项和答案");
            }
        }else{
            throw new OnlineExamException(OnlineExamExceptionEnum.BAD_ARGUMENT.getCode(),"客观题只有单选，多选和判断题");
        }
        questionService.insertQuestions(questionParam);
        return CommonResult.success();
    }
}
