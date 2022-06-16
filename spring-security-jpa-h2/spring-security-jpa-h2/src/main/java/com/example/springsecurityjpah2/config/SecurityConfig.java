package com.example.springsecurityjpah2.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    //@Lazy annotation is used to get rid of circular dependency--UserDetailsService is called Only when needed
    public SecurityConfig(@Lazy UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/rest/**").authenticated().anyRequest().permitAll()
                .antMatchers("/secure/**").authenticated().anyRequest().hasAnyRole("ADMIN").and()
                .formLogin().permitAll();

//these were not functional but were working in other prj
//        http
//                .authorizeRequests()
//                .antMatchers("/secure/**").hasRole("ADMIN")
//                .antMatchers("/rest/**").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//        .invalidSessionUrl("/login").and().cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/register-user").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .and().logout().logoutUrl("/logout");


    }

}
