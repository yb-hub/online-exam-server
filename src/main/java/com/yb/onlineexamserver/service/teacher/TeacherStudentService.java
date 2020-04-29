package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.requestparams.StudentInfoParams;
import com.yb.onlineexamserver.vo.StudentVo;

import java.util.List;

/**
 * @author yb
 * @description
 * @data 2020/4/29
 */
public interface TeacherStudentService {
    /**
     * 新增学生
     * @param studentInfoParams
     */
    int insertStudent(StudentInfoParams studentInfoParams);

    /**
     * 获取学生列表
     * @param page
     * @param limit
     * @param studentId
     * @param name
     * @return
     */
    Page<StudentVo> getStudentList(Integer page, Integer limit, String studentId, String name);

    /**
     * 修改学生的状态
     * @param studentId
     * @param status
     */
    void updateStudent(String studentId, Integer status);

    /**
     * 批量插入学生
     * @param studentInfoParamsList
     * @return
     */
    int insertStudentList(List<StudentInfoParams> studentInfoParamsList);
}
