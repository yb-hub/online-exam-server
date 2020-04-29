package com.yb.onlineexamserver.service.teacher.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yb.onlineexamserver.common.enums.studentenums.StudentEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.student.StudentDao;
import com.yb.onlineexamserver.mbg.mapper.StudentMapper;
import com.yb.onlineexamserver.mbg.model.Student;
import com.yb.onlineexamserver.mbg.model.StudentExample;
import com.yb.onlineexamserver.requestparams.StudentInfoParams;
import com.yb.onlineexamserver.service.teacher.TeacherStudentService;
import com.yb.onlineexamserver.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yb
 * @description
 * @data 2020/4/29
 */
@Service
public class TeacherStudentServiceImpl implements TeacherStudentService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private StudentDao studentDao;
    @Override
    public int insertStudent(StudentInfoParams studentInfoParams) {
        //判断是否存在此学号学生
        StudentVo studentVo = studentDao.queryStudentById(studentInfoParams.getStudentId());
        if(studentVo != null){
            throw new OnlineExamException(StudentEnums.STUDENT_IS_EXIST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentInfoParams,student);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setIsDelete(0);
        return studentMapper.insertSelective(student);
    }

    @Override
    public Page<StudentVo> getStudentList(Integer page, Integer limit, String studentId, String name) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(studentId)){
            criteria.andStudentIdEqualTo(studentId);
        }
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        PageHelper.startPage(page,limit);
        Page<Student> students = (Page<Student>) studentMapper.selectByExample(example);
        Page<StudentVo> studentVos = new Page<>();
        BeanUtils.copyProperties(students,studentVos);
        for (Student student : students) {
            StudentVo studentVo = new StudentVo();
            BeanUtils.copyProperties(student,studentVo);
            studentVos.add(studentVo);
        }
        return studentVos;
    }

    @Override
    public void updateStudent(String studentId, Integer status) {
        studentDao.updateStudent(studentId,status);
    }

    @Override
    public int insertStudentList(List<StudentInfoParams> studentInfoParamsList) {
        int count = 0;
        for (int i = 0; i < studentInfoParamsList.size(); i++) {
            studentInfoParamsList.get(i).setPassword("123456");
            int result = insertStudent(studentInfoParamsList.get(i));
            count += result;
        }
        return count;
    }
}
