package com.yb.onlineexamserver.service.teacher.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yb.onlineexamserver.dao.ExamResultDao;
import com.yb.onlineexamserver.service.teacher.TeacherExamresultService;
import com.yb.onlineexamserver.vo.ExamResultChartVo;
import com.yb.onlineexamserver.vo.ExamResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/04/29 22:16
 * @Description:
 */
@Service
public class TeacherExamresultServiceImpl implements TeacherExamresultService {
    @Resource
    private ExamResultDao examResultDao;

    @Override
    public Page<ExamResultVo> queryExamresult(String studentId, Integer paperId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        Page<ExamResultVo> examResultVos = examResultDao.queryExamresult(studentId,paperId);
        return examResultVos;
    }

    @Override
    public List<ExamResultChartVo> queryExamresultChartData(Integer paperId) {
        List<ExamResultChartVo> examResultChartVos = examResultDao.queryExamresultChartData(paperId);
        return examResultChartVos;
    }
}
