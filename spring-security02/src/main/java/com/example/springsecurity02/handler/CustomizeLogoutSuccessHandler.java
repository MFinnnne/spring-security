package com.example.springsecurity02.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/7/25 18:54
 **/
@Configuration
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String value = mapper.writeValueAsString(ResponseEntity.ok().body("退出登录成功"));
            httpServletResponse.setContentType("text/json;charset=utf-8");
            httpServletResponse.getWriter().write(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
