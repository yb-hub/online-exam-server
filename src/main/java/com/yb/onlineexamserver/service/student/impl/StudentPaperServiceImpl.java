package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.dao.student.StudentCourseDao;
import com.yb.onlineexamserver.dao.student.StudentPaperDao;
import com.yb.onlineexamserver.service.student.StudentPaperService;
import com.yb.onlineexamserver.vo.CourseVo;
import com.yb.onlineexamserver.vo.PaperVo;
import com.yb.onlineexamserver.vo.StudentPaperListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/10 19:21
 * @Description:
 */
@Service
public class StudentPaperServiceImpl implements StudentPaperService {
    @Autowired
    private StudentPaperDao studentPaperDao;
    @Autowired
    private StudentCourseDao studentCourseDao;
    @Override
    public StudentPaperListVo queryPaperByCourseId(Integer id) {
        StudentPaperListVo studentPaperListVo = new StudentPaperListVo();
        List<PaperVo> paperVos = studentPaperDao.queryPaperByCourseId(id);
        CourseVo courseVo = studentCourseDao.queryCourseById(id);
        studentPaperListVo.setCourseName(courseVo.getName());
        studentPaperListVo.setPaperList(paperVos);
        return studentPaperListVo;
    }
}
