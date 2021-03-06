package com.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 校验账号、密码前，先进行验证码处理
 */
@Component
public class CaptchaFilterConfig implements Filter {

    private Boolean captchaEnable = true;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //只拦截登录请求，且开发环境下不拦截
        if("POST".equals(request.getMethod()) && "/login".equals(request.getRequestURI()) && captchaEnable){
            //从session中获取生成的验证码
            String verifyCode = null;
            if(request.getSession().getAttribute("verifyCode") != null)
            {
                verifyCode = request.getSession().getAttribute("verifyCode").toString();
            }
            if (!verifyCode.toLowerCase().equals(request.getParameter("captcha").toLowerCase())){
                response.sendRedirect("/login");
                return;
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
