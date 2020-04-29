package com.yb.onlineexamserver.controller.teacher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.StudentInfoParams;
import com.yb.onlineexamserver.requestparams.StudentUpdateStatusParams;
import com.yb.onlineexamserver.requestparams.student.StudentUpdateParams;
import com.yb.onlineexamserver.service.teacher.TeacherStudentService;
import com.yb.onlineexamserver.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author yb
 * @description
 * @data 2020/4/29
 */
@RestController
public class TeacherStudentController {

    @Autowired
    private TeacherStudentService teacherStudentService;

    @PostMapping("/teacher/student")
    public CommonResult insertStudent(@RequestBody @Valid StudentInfoParams studentInfoParams){
        teacherStudentService.insertStudent(studentInfoParams);
        return CommonResult.success();
    }

    @PostMapping("/teacher/student/list")
    public CommonResult insertStudentList(@RequestBody @Valid String studentInfoParamsListStr){
        Map jsonObject = (Map) JSON.parse(studentInfoParamsListStr);
        String studentListStr = jsonObject.get("studentList").toString();
        List<StudentInfoParams> studentInfoParamsList = JSON.parseArray(studentListStr, StudentInfoParams.class);
        int count = teacherStudentService.insertStudentList(studentInfoParamsList);
        return CommonResult.success(count);
    }

    @GetMapping("/teacher/student")
    public CommonResult getStudentList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit",defaultValue = "20") Integer limit,
                                       @RequestParam(value = "studentId",required = false) String studentId,
                                       @RequestParam(value = "name",required = false) String name){
        Page<StudentVo> studentList = teacherStudentService.getStudentList(page, limit, studentId, name);
        return CommonResult.successList(studentList);
    }

    @PutMapping("/teacher/student/{studentId}")
    public CommonResult updateStudent(@PathVariable("studentId") String studentId, @RequestBody StudentUpdateStatusParams studentUpdateStatusParams){
        teacherStudentService.updateStudent(studentId,studentUpdateStatusParams.getIsDelete());
        return CommonResult.success();
    }
}
