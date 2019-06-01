package eduGameApp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.requiresChannel().anyRequest().requiresSecure()
		.and()
		.authorizeRequests()
		.antMatchers("/","/signup/**","/login").permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/login", true)
		.and()
		.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logoutDone"))
		.logoutSuccessUrl("/")
		.and()
		.csrf().disable();
		
		
	}
}
