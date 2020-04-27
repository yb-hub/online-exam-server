package com.yb.onlineexamserver.config.securityconfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yb
 * @description
 * @data 2020/4/27
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    //在request使用getReader读取body时，只能读取一次。
    private StringBuilder sb;
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        sb = getStringBuilder(request);
        AuthenticationBean authenticationBean = JSONObject.parseObject(sb.toString(), AuthenticationBean.class);
        return authenticationBean.getStudentId();
    }
    @Override
    protected String obtainPassword(HttpServletRequest request) {
        AuthenticationBean authenticationBean = JSONObject.parseObject(sb.toString(), AuthenticationBean.class);
        return authenticationBean.getPassword();
    }

    public StringBuilder getStringBuilder(HttpServletRequest request){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb;
    }
}