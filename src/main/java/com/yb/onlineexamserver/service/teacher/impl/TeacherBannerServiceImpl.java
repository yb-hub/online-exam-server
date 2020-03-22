package com.yb.onlineexamserver.service.teacher.impl;

import com.yb.onlineexamserver.mbg.mapper.BannerMapper;
import com.yb.onlineexamserver.mbg.model.Banner;
import com.yb.onlineexamserver.mbg.model.BannerExample;
import com.yb.onlineexamserver.service.teacher.TeacherBannerService;
import com.yb.onlineexamserver.utils.FileUploadUtils;
import com.yb.onlineexamserver.vo.BannerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Yang
 * @Date: 2020/03/18 16:38
 * @Description:
 */
@Service
public class TeacherBannerServiceImpl implements TeacherBannerService {

    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public List<BannerVo> queryBanners(String title, Integer type, Integer status, String sort, Integer page, Integer pageSize) {
        BannerExample example = new BannerExample();
        if(!StringUtils.isEmpty(title)){
            example.or().andTitleLike("%"+title+"%");
        }
        if(type != null){
            example.or().andTypeEqualTo(type);
        }
        if(status != null){
            example.or().andStatusEqualTo(status);
        }
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause(sort);
        }
        List<Banner> banners = bannerMapper.selectByExample(example);
        //ArrayList<BannerVo> bannerVos = new ArrayList<>();
        List<BannerVo> bannerVos = banners.stream().map(banner -> {
            BannerVo bannerVo = new BannerVo();
            BeanUtils.copyProperties(banner, bannerVo);
            return bannerVo;
        }).collect(Collectors.toList());
        return bannerVos;
    }

    @Override
    public int insertBanner(MultipartFile file, String title) {
        String url = FileUploadUtils.upload(file);
        //将上传成功的图片地址保存到数据库中
        Banner banner = new Banner();
        banner.setTitle(title);
        banner.setUrl(url);
        banner.setCreateTime(LocalDateTime.now());
        banner.setUpdateTime(LocalDateTime.now());
        return bannerMapper.insertSelective(banner);
    }
}
