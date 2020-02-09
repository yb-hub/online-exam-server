package com.yb.onlineexamserver.controller.student;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.service.student.CourseService;
import com.yb.onlineexamserver.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/09 19:42
 * @Description:
 */
@RestController
public class StudentCourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/student/courses")
    public CommonResult queryCourses(@RequestParam(value = "name",required = false) String name){
        List<CourseVo> courseVos = courseService.queryCourses(name);
        return CommonResult.success(courseVos);
    }
}
