package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.vo.PaperVo;

import java.util.List;

public interface StudentPaperDao {
    List<PaperVo> queryPaperByCourseId(Integer id);

    PaperDetailDto queryPaperById(Integer id);
}
