package com.yb.onlineexamserver.config.securityconfig;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yb
 * @description
 * @data 2020/4/27
 */
@Getter
@Setter
public class AuthenticationBean {
    private String studentId;
    private String password;
}
