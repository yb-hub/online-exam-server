package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.MajorParams;
import com.yb.onlineexamserver.service.teacher.TeacherMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Yang
 * @Date: 2019/11/9 13:53
 * @Description:
 */
@RestController
public class TeacherMajorController {

    @Autowired
    private TeacherMajorService teacherMajorService;

    @PostMapping("/majors")
    public CommonResult insertMajors(@RequestBody MajorParams majorParams){
        teacherMajorService.insertMajors(majorParams);
        return CommonResult.success();
    }

    @DeleteMapping("/majors/{id}")
    public CommonResult deleteMajors(@PathVariable("id") Integer id){
        teacherMajorService.deleteMajors(id);
        return CommonResult.success();
    }

    @PutMapping("/majors/{id}")
    public CommonResult updateMajors(@PathVariable("id") Integer id,@RequestBody MajorParams majorParams){
        teacherMajorService.updateMajors(id,majorParams);
        return CommonResult.success();
    }

    @GetMapping("/majors")
    public CommonResult queryMajors(@RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSized",defaultValue = "10") Integer pageSize){
        return CommonResult.successList(teacherMajorService.queryMajors(name,page,pageSize));
    }
}
