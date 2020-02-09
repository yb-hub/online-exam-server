package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.vo.PaperDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 14:50
 * @Description:
 */
public interface PaperDao {

    PaperDetailDto queryPaperById(Integer id);
}
