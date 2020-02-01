package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.PaperParams;
import com.yb.onlineexamserver.service.teacher.PaperService;
import com.yb.onlineexamserver.vo.PaperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 13:57
 * @Description: 试卷管理
 */
@RestController
public class PaperController {
    @Autowired
    private PaperService PaperService;
    @PostMapping("/paper")
    public CommonResult insertPaper(@Valid @RequestBody PaperParams paperParams){
        PaperService.insertPaper(paperParams);
        return CommonResult.success();
    }

    @GetMapping("/papers")
    public CommonResult queryPaperList(@RequestParam(value = "keyWord",defaultValue = "",required = false) String keyWord,
                                       @RequestParam(value = "courseId",required = false) Integer courseId,
                                       @RequestParam(value = "page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "sort",defaultValue = "update_time") String sort){
        List<PaperVo> paperVos = PaperService.queryPaperList(keyWord, courseId, page, pageSize, sort);
        return CommonResult.successList(paperVos);
    }

    @DeleteMapping("/paper/{id}")
    public CommonResult deletePaper(@PathVariable("id") Integer id){
        PaperService.deletePaper(id);
        return CommonResult.success();
    }
}
