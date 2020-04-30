package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.PaperParams;
import com.yb.onlineexamserver.service.teacher.PaperService;
import com.yb.onlineexamserver.vo.PaperDetailVo;
import com.yb.onlineexamserver.vo.PaperSimpleVo;
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
    private PaperService paperService;
    @PostMapping("/paper")
    public CommonResult insertPaper(@Valid @RequestBody PaperParams paperParams){
        paperService.insertPaper(paperParams);
        return CommonResult.success();
    }

    @GetMapping("/papers")
    public CommonResult queryPaperList(@RequestParam(value = "keyWord",defaultValue = "",required = false) String keyWord,
                                       @RequestParam(value = "courseId",required = false) Integer courseId,
                                       @RequestParam(value = "page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "sort",defaultValue = "update_time") String sort){
        List<PaperVo> paperVos = paperService.queryPaperList(keyWord, courseId, page, pageSize, sort);
        return CommonResult.successList(paperVos);
    }

    @GetMapping("/teacher/paper/simple")
    public CommonResult queryPaperSimpleList(){
        List<PaperSimpleVo> paperSimpleVoList = paperService.queryPaperSimpleList();
        return CommonResult.success(paperSimpleVoList);
    }

    @GetMapping("/paper/{id}")
    public CommonResult queryPaperById(@PathVariable("id") Integer id){
        PaperDetailVo paperDetailVo = paperService.queryPaperById(id);
        return CommonResult.success(paperDetailVo);
    }

    @DeleteMapping("/paper/{id}")
    public CommonResult deletePaper(@PathVariable("id") Integer id){
        paperService.deletePaper(id);
        return CommonResult.success();
    }
}
