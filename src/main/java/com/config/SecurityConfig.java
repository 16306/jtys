package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private CaptchaFilterConfig captchaFilterConfig;

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        // 如果有允许匿名的url，填在下面
        .antMatchers("/familyApp/**","/doctor/login","/getVerifyCodeImage").permitAll()
        .anyRequest().authenticated()
        .and()
        // 设置登陆页
        .addFilterBefore(captchaFilterConfig, UsernamePasswordAuthenticationFilter.class)
        .formLogin()
        .loginPage("/login").permitAll()
        .successForwardUrl("/index").permitAll()
//        // 设置登陆成功页
//        .defaultSuccessUrl("/index").permitAll()
        .and()
        .logout()
        .permitAll()
        .and();
    // 关闭CSRF跨域
    http.csrf().disable();

    http.headers().frameOptions().disable();

  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // 设置拦截忽略文件夹，可以对静态资源放行
    web.ignoring().antMatchers("/css/**", "/js/**","/layui/**","/images/**","/src/**");
  }

  @Bean
  public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler(){
    DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
    handler.setPermissionEvaluator(new CustomPermissionEvaluator());
    return handler;
  }
}

