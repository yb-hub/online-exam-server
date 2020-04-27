package com.yb.onlineexamserver.config.securityconfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.dao.student.StudentDao;
import com.yb.onlineexamserver.requestparams.student.StudentLoginInfo;
import com.yb.onlineexamserver.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Yang
 * @Date: 2020/04/11 16:06
 * @Description:
 */
@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Resource
    private StudentDao studentDao;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        //获取表单输入的用户名
        String username = (String) authentication.getPrincipal();
        StudentVo studentVo = studentDao.queryStudentById(username);
        CommonResult success = CommonResult.success(studentVo);
        String result = JSON.toJSONString(success);
        response.getWriter().write(result);
    }
}