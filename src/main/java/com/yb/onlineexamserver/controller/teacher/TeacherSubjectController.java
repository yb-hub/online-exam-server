package com.yb.onlineexamserver.controller.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.mbg.model.Subject;
import com.yb.onlineexamserver.requestparams.SubjectParams;
import com.yb.onlineexamserver.service.teacher.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public CommonResult insertSubjects(@RequestBody @Valid SubjectParams subjectParams) {
        teacherSubjectService.insertSubjects(subjectParams);
        return CommonResult.success();
    }

    @DeleteMapping("/subjects/{id}")
    public CommonResult deleteSubjects(@PathVariable("id") Integer id) {
        teacherSubjectService.deleteSubjectsById(id);
        return CommonResult.success();
    }

    @PutMapping("/subjects/{id}")
    public CommonResult updateSubjects(@PathVariable("id") Integer id,
                                       @RequestBody @Valid SubjectParams subjectParams) {
        teacherSubjectService.updateSubjects(id, subjectParams);
        return CommonResult.success();
    }

    @GetMapping("/subjects")
    public CommonResult querySubjects(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam("page") Integer page,
                                      @RequestParam("pageSize") Integer pageSize) {
        Page<Subject> subjects = teacherSubjectService.querySubjects(name, page, pageSize);
        return new CommonResult<Subject>().successList(subjects);
    }

}
