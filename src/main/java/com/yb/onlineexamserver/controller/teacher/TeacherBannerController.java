package com.yb.onlineexamserver.controller.teacher;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.service.teacher.TeacherBannerService;
import com.yb.onlineexamserver.utils.FileUploadUtils;
import com.yb.onlineexamserver.vo.BannerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/03/18 16:33
 * @Description: 轮播图接口
 */
@RestController
public class TeacherBannerController {
    @Autowired
    private TeacherBannerService teacherBannerService;

    @GetMapping("/banner")
    public CommonResult queryBanners(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "status") Integer status,
            @RequestParam(value = "sort",defaultValue = "id") String sort,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        List<BannerVo> bannerVos = teacherBannerService.queryBanners(title, type, status, sort, page, pageSize);
        return CommonResult.successList(bannerVos);
    }

    @PostMapping("/banner")
    public CommonResult insertBanner(@RequestParam(value = "file") MultipartFile file, String title){
        teacherBannerService.insertBanner(file,title);
        return CommonResult.success();
    }
}
