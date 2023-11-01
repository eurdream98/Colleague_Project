package com.example.structure.member.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests()로 인증이 필요한 자원들을 설정할 수 있고 antMatchers()는
        // '**/*'와 같은 앤트 스타일의 패턴으로 원하는 자원을 선택할 수 있다.
        //마지막으로 permitAll()의 경우는 말 그대로 '모든 사용자에게 허락'한다는 의미이므로
        //로그인하지 않은 사용자도 익명의 사용자로 간주되어서 접근이 가능하게 된다.
        //프로젝트를 재시작해서 /sample/all에 접속하면 별도의 로그인 없이도 접근이 가능해 진다.
        http.authorizeRequests().antMatchers("/sample/all").permitAll()
                //아래와 같이 설정하고 /sample/member'를 호출하면 Access Denied 된다.
                .antMatchers("/sample/member").hasRole("USER");

        //인가/인증에 문제시 로그인 화면면
        http.formLogin();
        http.csrf().disable();

        //실제 로그인 시에 OAuth를 사용한 로그인이 가능하도록 함
        http.oauth2Login();
    }
}
