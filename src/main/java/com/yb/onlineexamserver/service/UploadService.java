package com.yb.onlineexamserver.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yb
 * @description
 * @data 2020/4/28
 */
public interface UploadService {
    String upload(MultipartFile file);
}
