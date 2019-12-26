package com.yb.onlineexamserver.controller.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.vo.CourseSimpleVo;
import com.yb.onlineexamserver.vo.CourseVo;
import com.yb.onlineexamserver.requestparams.CourseParams;
import com.yb.onlineexamserver.service.teacher.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:24
 * @Description:
 */
@RestController
public class TeacherCourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public CommonResult insertCourses(@RequestBody CourseParams courseParams){
        courseService.insertCourses(courseParams);
        return CommonResult.success();
    }

    @DeleteMapping("/courses/{id}")
    public CommonResult deleteCourses(@PathVariable("id") Integer id){
        courseService.deleteCourses(id);
        return CommonResult.success();
    }

    @PutMapping("/courses/{id}")
    public CommonResult updateCourses(@PathVariable("id") Integer id,@RequestBody @Valid CourseParams courseParams){
        courseService.updateCourses(id,courseParams);
        return CommonResult.success();
    }

    @GetMapping("/courses")
    public CommonResult queryCourses(@RequestParam(value = "name",required = false) String name,
                                     @RequestParam(value = "majorId",required = false) Integer majorId,
                                     @RequestParam(value = "page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        Page<CourseVo> courseVos = courseService.queryCourses(name, majorId, page, pageSize);
        return CommonResult.successList(courseVos);
    }

    @GetMapping("/courses/simple")
    public CommonResult queryCoursesSimple(){
        List<CourseSimpleVo> courseSimpleVos = courseService.queryCoursesSimple();
        return CommonResult.success(courseSimpleVos);
    }
}
