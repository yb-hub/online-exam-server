package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.dto.MajorDto;
import com.yb.onlineexamserver.mbg.model.Major;
import com.yb.onlineexamserver.requestparams.MajorParams;

import java.util.List;

public interface TeacherMajorService {
    int insertMajors(MajorParams majorParams);

    int deleteMajors(Integer id);

    Major queryMajorById(Integer id);

    int updateMajors(Integer id, MajorParams majorParams);

    List<MajorDto> queryMajors(String name, Integer page, Integer pageSize);
}
