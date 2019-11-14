package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.vo.MajorVo;
import com.yb.onlineexamserver.vo.MajorSimpleVo;
import com.yb.onlineexamserver.mbg.model.Major;
import com.yb.onlineexamserver.requestparams.MajorParams;

import java.util.List;

public interface MajorService {
    int insertMajors(MajorParams majorParams);

    int deleteMajors(Integer id);

    Major queryMajorById(Integer id);

    int updateMajors(Integer id, MajorParams majorParams);

    List<MajorVo> queryMajors(String name, Integer subjectId, Integer page, Integer pageSize);

    List<MajorSimpleVo> queryMajorsSimple();
}
