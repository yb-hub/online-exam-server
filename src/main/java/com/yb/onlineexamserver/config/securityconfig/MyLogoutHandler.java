package com.yb.onlineexamserver.config.securityconfig;

import com.alibaba.fastjson.JSON;
import com.yb.onlineexamserver.common.result.CommonResult;
import com.yb.onlineexamserver.vo.StudentVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yb
 * @description
 * @data 2020/4/27
 */
@Component
public class MyLogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        CommonResult success = CommonResult.success();
        String result = JSON.toJSONString(success);
        response.getWriter().write(result);
    }
}
