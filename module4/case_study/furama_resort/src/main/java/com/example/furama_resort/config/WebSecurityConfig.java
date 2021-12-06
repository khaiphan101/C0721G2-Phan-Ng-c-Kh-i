package com.example.furama_resort.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
    private MyUserDetailService myUserDetailService;
public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //neeus khong co quyen thi tra ve url/403 (khong phai ve html)
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http
                .formLogin()
                .and()
                .authorizeRequests()
                //trang home khong can xac thuc dang nhap (pẻmitall())
                .antMatchers("/**", "/employee").permitAll()
                .antMatchers( "/assets/js/**", "/assets/css/**").permitAll()
                //nhung trang con lai can dang nhap
//                .antMatchers("/employee/create",
//                        //1 *: chấp nhận mọi ký tự đằng sau, **: chấp nhận mọi đường dẫn(vd: /id/admin)
//                        "/employee/edit/**").hasAnyRole("ROLE_EMPLOYEE", "ROLE_ADMIN")
                .anyRequest().authenticated();
    }
//
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("1");
        System.out.println(password);
    }
}
