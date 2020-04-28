package com.yb.onlineexamserver.controller;

import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yb
 * @description 图片上传接口
 * @data 2020/4/28
 */
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    public CommonResult upload(@RequestParam(value = "file") MultipartFile file){
        String url = uploadService.upload(file);
        return CommonResult.success(url);
    }
}
