package com.app.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	   /* http.csrf().disable()
	            .authorizeHttpRequests((authorize) ->
	                    authorize.requestMatchers("/user/login").permitAll()
	                            .requestMatchers("/user/newuser").permitAll()
	                            .requestMatchers("/user/forgotpass").permitAll()
	                            .requestMatchers("/user/changepass").permitAll()
	                            .requestMatchers("/user/profile/**").authenticated()
	                            .requestMatchers("/user/updateprofile/**").authenticated()
	                            .requestMatchers("/user/submitAnswer").authenticated()
	                            .requestMatchers("/user/getAllTests/**").authenticated()
	            ).formLogin(
	                    form -> form
	                            .loginPage("/user/showlogin")
	                            .permitAll()
	            ).logout(
	                    logout -> logout
	                            .logoutRequestMatcher(new AntPathRequestMatcher("/user/showlogout"))
	                            .permitAll()
	                            .logoutSuccessUrl("/user/showlogin")
	            )
	            .sessionManagement()
	                .maximumSessions(1)
	                .expiredUrl("/user/showlogin");

	    return http.build();*/
	    
	    
	    
	    http.csrf().disable()
        .authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/user/login").permitAll()
                        .requestMatchers("/user/newuser").permitAll()
                        .requestMatchers("/user/forgotpass").permitAll()
                        .requestMatchers("/user/changepass").permitAll()
                        .requestMatchers("/user/profile/**").permitAll()
                        .requestMatchers("/user/updateprofile/**").permitAll()
                        .requestMatchers("/user/submitAnswer").permitAll()
                        .requestMatchers("/user/getAllTests/**").permitAll()
        ).formLogin(
                form -> form
                        .loginPage("/user/showlogin")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/showlogout"))
                        .permitAll()
                        .logoutSuccessUrl("/user/showlogin")
        )
        .sessionManagement()
            .maximumSessions(1)
            .expiredUrl("/user/showlogin");

return http.build();
	}

	 
	@Autowired
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	 }


}
