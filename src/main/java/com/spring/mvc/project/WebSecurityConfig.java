package com.spring.mvc.project;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/views/users/").permitAll()
		.antMatchers("/views/users/preRegister").hasAuthority("admin")
		.antMatchers("/views/users/postRegister").hasAuthority("admin")
		.antMatchers("/views/users/update/**").hasAuthority("admin")
		.antMatchers("/views/users/delete/**").hasAuthority("admin")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
	}

	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passEncoder)
		.usersByUsernameQuery("SELECT user,password,'true' as enabled FROM rol WHERE user = ?")
		.authoritiesByUsernameQuery("SELECT r.user,u.rolID FROM users u INNER JOIN rol r ON r.user=u.rolID WHERE r.user = ?");
	}
}