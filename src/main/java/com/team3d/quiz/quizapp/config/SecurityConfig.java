package com.team3d.quiz.quizapp.config;


import com.team3d.quiz.quizapp.AuthServiceWithUserDetails.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private MyUserDetailsService myUserDetailsService;

    public SecurityConfig(MyUserDetailsService myUserDetailsService){
        this.myUserDetailsService = myUserDetailsService;

    }

//    The WebSecurityConfig class is annotated with @EnableWebSecurity to
//    enable javax.swing.Spring Security’s web security support and
//    provide the Spring MVC integration. It also extends WebSecurityConfigurerAdapter and
//    overrides a couple of its methods to set some specifics
//    of the web security configuration.


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {

        auth.authenticationProvider(daoAuthenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        The configure(HttpSecurity) method defines which URL paths should be
//        secured and which should not. Specifically, the / and /home paths are configured
//        to not require any authentication. All other paths must be authenticated.

//        When a user successfully logs in, they are redirected to the previously
//        requested page that required authentication.
//        There is a custom /login page (which is specified by loginPage()),
//        and everyone is allowed to view it.

        http
            .authorizeRequests()
                .antMatchers("/MainPages/**","/signup").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/*.js","/*.css").permitAll()
                .antMatchers("/static/css/**", "/static/js/**").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()

                .antMatchers("/Students/**").hasAnyRole("STUDENT")
                .antMatchers("/Teachers/**").hasAnyRole("TEACHER")

            .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler())
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");

    }



    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(this.myUserDetailsService);
        return authenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MyAuthSuccessHandler();
    }

}
