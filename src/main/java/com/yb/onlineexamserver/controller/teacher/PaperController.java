package com.yb.onlineexamserver.controller.teacher;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.requestparams.PaperParams;
import com.yb.onlineexamserver.service.teacher.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        return null;
    }
}
