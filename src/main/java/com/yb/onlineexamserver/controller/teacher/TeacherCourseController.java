package com.yb.onlineexamserver.controller.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.dto.CourseDto;
import com.yb.onlineexamserver.requestparams.CourseParams;
import com.yb.onlineexamserver.service.teacher.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:24
 * @Description:
 */
@RestController
public class TeacherCourseController {

    @Autowired
    private TeacherCourseService teacherCourseService;

    @PostMapping("/courses")
    public CommonResult insertCourses(@RequestBody CourseParams courseParams){
        teacherCourseService.insertCourses(courseParams);
        return CommonResult.success();
    }

    @DeleteMapping("/courses/{id}")
    public CommonResult deleteCourses(@PathVariable("id") Integer id){
        teacherCourseService.deleteCourses(id);
        return CommonResult.success();
    }

    @PutMapping("/courses/{id}")
    public CommonResult updateCourses(@PathVariable("id") Integer id,@RequestBody @Valid CourseParams courseParams){
        teacherCourseService.updateCourses(id,courseParams);
        return CommonResult.success();
    }

    @GetMapping("/courses")
    public CommonResult queryCourses(@RequestParam(value = "name",required = false) String name,
                                     @RequestParam(value = "majorId") Integer majorId,
                                     @RequestParam(value = "page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        Page<CourseDto> courseDtos = teacherCourseService.queryCourses(name, majorId, page, pageSize);
        return CommonResult.successList(courseDtos);
    }
}
