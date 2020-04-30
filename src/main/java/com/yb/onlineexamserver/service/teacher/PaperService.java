package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.requestparams.PaperParams;
import com.yb.onlineexamserver.vo.PaperDetailVo;
import com.yb.onlineexamserver.vo.PaperSimpleVo;
import com.yb.onlineexamserver.vo.PaperVo;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 14:11
 * @Description:
 */
public interface PaperService {
    void insertPaper(PaperParams paperParams);

    List<PaperVo> queryPaperList(String keyWord, Integer courseId, Integer page, Integer pageSize, String sort);

    int deletePaper(Integer id);

    PaperDetailVo queryPaperById(Integer id);

    List<PaperSimpleVo> queryPaperSimpleList();

}
