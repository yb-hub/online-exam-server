package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.vo.MajorSimpleVo;
import com.yb.onlineexamserver.requestparams.MajorParams;
import com.yb.onlineexamserver.service.teacher.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/9 13:53
 * @Description:
 */
@RestController
public class TeacherMajorController {

    @Autowired
    private MajorService majorService;

    @PostMapping("/majors")
    public CommonResult insertMajors(@RequestBody MajorParams majorParams){
        majorService.insertMajors(majorParams);
        return CommonResult.success();
    }

    @DeleteMapping("/majors/{id}")
    public CommonResult deleteMajors(@PathVariable("id") Integer id){
        majorService.deleteMajors(id);
        return CommonResult.success();
    }

    @PutMapping("/majors/{id}")
    public CommonResult updateMajors(@PathVariable("id") Integer id,@RequestBody MajorParams majorParams){
        majorService.updateMajors(id,majorParams);
        return CommonResult.success();
    }

    @GetMapping("/majors")
    public CommonResult queryMajors(@RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "subjectId",required = false) Integer subjectId,
                                    @RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSized",defaultValue = "10") Integer pageSize){
        return CommonResult.successList(majorService.queryMajors(name,subjectId,page,pageSize));
    }

    @GetMapping("/majors/simple")
    public CommonResult queryMajorsSimple(){
        List<MajorSimpleVo> majorSimpleVos = majorService.queryMajorsSimple();
        return CommonResult.success(majorSimpleVos);
    }
}
