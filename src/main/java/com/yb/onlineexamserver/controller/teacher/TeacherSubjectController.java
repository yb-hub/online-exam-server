package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.SubjectParams;
import com.yb.onlineexamserver.service.teacher.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:42
 * @Description: 科目模块
 */
@RestController
public class TeacherSubjectController {

    @Autowired
    private TeacherSubjectService teacherSubjectService;

    @PostMapping("/subjects")
    public CommonResult insertSubjects(@RequestBody SubjectParams subjectParams) throws OnlineExamException {
        teacherSubjectService.insertSubjects(subjectParams);
        return CommonResult.success();
    }


}
