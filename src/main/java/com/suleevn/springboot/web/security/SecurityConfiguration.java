package com.suleevn.springboot.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login, password, enabled"
                        + " from user where login=?")
                .authoritiesByUsernameQuery("select login, role "
                        + "from user where login=?");
    }


	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/list-todos","/about").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers( "/new-user").access("hasRole('ADMIN')").and()
                .formLogin().loginPage("/")
                .defaultSuccessUrl("/list-todos", true)
                .and().csrf().disable();
    }




}
