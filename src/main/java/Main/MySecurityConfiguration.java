package Main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception
	{
//		builder.inMemoryAuthentication()
//				.withUser("joe").password("{noop}test")
//				.authorities("USER");
		builder.jdbcAuthentication()
				.dataSource(datasource)
				.usersByUsernameQuery("select username, password, true from user where username=?")
				.authoritiesByUsernameQuery("select user_username,roles from user_roles where user_username=?")
				.passwordEncoder(new PasswordEncoder() {

					@Override
					public String encode(CharSequence rawPassword) {
						// TODO Auto-generated method stub
						return rawPassword.toString();
					}

					@Override
					public boolean matches(CharSequence rawPassword, String encodedPassword) {
						// TODO Auto-generated method stub
						return encodedPassword.equals(rawPassword);
					}
					
				});
	}
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

}
