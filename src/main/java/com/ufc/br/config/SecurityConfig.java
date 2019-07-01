package com.ufc.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ufc.br.security.UsuarioDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioDetailsServiceImplementation userDetailsI;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/inicio").permitAll()
		.antMatchers("/bolos").permitAll()
		.antMatchers("/bolos/cadBolo").hasRole("ADMIN")
		.antMatchers("/sobre").permitAll()
		.antMatchers("/contato").permitAll()
		.antMatchers("/cadastro").permitAll()
		.antMatchers("/cadastro/new").permitAll()
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/inicio")
		.permitAll()
		
		.and()
		.logout()
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsI).passwordEncoder(new BCryptPasswordEncoder());
		
	}


	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**","/img/**", "/images/**");
	}



	
	
	
	
}
