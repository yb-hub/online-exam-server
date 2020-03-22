package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.vo.BannerVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherBannerService {
    List<BannerVo> queryBanners(String title, Integer type, Integer status, String sort, Integer page, Integer pageSize);

    int insertBanner(MultipartFile file, String title);
}
