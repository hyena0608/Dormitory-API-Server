package com.example.dormi.framework.security;

import com.example.dormi.framework.security.jwt.JwtTokenProvider;
import com.example.dormi.framework.security.jwt.JwtTokenProvider;
import com.example.dormi.framework.security.jwt.JwtAuthenticationFilter;
import com.example.dormi.framework.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
//@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**",
                "/js/**",
                "/img/**",
                "/lib/*8",
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources",
                "/configuration/security",
                "/swagger-ui.html",
                "webjars/**",
                "/swagger/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ?????? ??????
        http
                .httpBasic().disable() // REST API?????? ??????, ?????? ?????? ??????
                .csrf().disable() // csrf ?????? X
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);

        // ?????? ?????? ??????????????? ????????? ?????? X
//                .and()
//                .authorizeRequests() // ????????? ?????? ???????????? ??????
//                .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
//                .antMatchers("/user/**").hasRole("ROLE_MEMBER")
//                .anyRequest().permitAll() // ????????? ????????? ????????? ?????? ??????
//                .and()
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
//                        UsernamePasswordAuthenticationFilter.class);
        // JwtAuthenticationFilter???
        // UsernamePasswordAuthenticationFilter ?????? ??????
    }

}
