package com.yb.onlineexamserver.service.impl;

import com.yb.onlineexamserver.service.UploadService;
import com.yb.onlineexamserver.utils.FileUploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yb
 * @description
 * @data 2020/4/28
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public String upload(MultipartFile file) {
        String url = FileUploadUtils.upload(file);
        return url;
    }
}
