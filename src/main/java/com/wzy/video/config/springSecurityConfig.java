package com.wzy.video.config;

import com.wzy.video.service.UserDetailsServiceImpl;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity      //启动SpringSecurty过滤器
public class springSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // 配置拦截规则
                .authorizeRequests()
                .mvcMatchers("/login.jsp","/css/**","/fonts/**","/img/**","/js/**","/plugins/**","/failer.jsp","/error/**").permitAll()
                .mvcMatchers("/**").hasAnyRole("ROLE_ADMIN','ROLE_USER")
                /*.antMatchers("/static/css/**","/static/img/**","/static/js/**","/static/plugins/**","/login.jsp","/failer.jsp").permitAll()    //所有资源都需要通过验证才能访问，首先通过httpbasic方式验证
                .antMatchers("/static/view/**").hasAnyRole("ROLE_ADMIN','ROLE_USER")*/
                .anyRequest().authenticated()//其他所有路径都需要权限校验
                                                    //      .fullyAuthenticated()
                                                    //isAnonymous()　　	是否为匿名用户
                                                    //  isAuthenticated()　　	不是匿名用户
                                                    //  isFullyAuthenticated　　	不是匿名也不是remember-me认证
                                                    //  isRemberMe()　　	remember-me认证

                .and()

                // 配置登录功能
                .formLogin()                       //.formLogin() --> FormLoginConfigurer
                                                    //.httpBasic() --> HttpBasicConfigurer()
                .loginPage("/login.jsp").permitAll()                      //请求时未登录跳转接口
                .loginProcessingUrl("/login")             //自定义登录接口 action映射地址 默认/login*/
                .failureUrl("/failer.jsp")                  //用户密码错误跳转接口

                .successForwardUrl("/view/main.jsp")
                /*.defaultSuccessUrl("/syslog/main",true)*/

                .and()
                .csrf().disable()                  //关闭csrf跨域防护
                // 注销成功跳转首页
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.jsp");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*.passwordEncoder(passwordEncoder());*/
        auth.userDetailsService(userDetailsService)/*.passwordEncoder(passwordEncoder());*/.passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
