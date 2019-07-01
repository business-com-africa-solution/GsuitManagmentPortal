package com.bussinesscom.Africa.GsuitAfrica.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
//	@Autowired
//	private UserDetailsService userDetailsService;


	
	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("SpringSec -------");

		String[] resources = new String[] { "/", "/home", "/pictureCheckCode", "/include/**", "/css/**", "/icons/**",
				"/images/**", "/js/**", "/layer/**", "/resources/", "/jMega avax.faces.resource/images/**",
				"/jMega avax.faces.resource/images", "/javax.faces.resource/**", "/javax.faces.resource/css/**",
				"/javax.faces.resource/datascroller/**", "/javax.faces.resource/fa/**", "/javax.faces.resource/demo/**",
				"/javax.faces.resource/js/**", "/javax.faces.resource/digitalclock/**",
				"/javax.faces.resource/fileupload", "/javax.faces.resource/fonts/", "/javax.faces.resource/forms",
				"/javax.faces.resource/galleria/**", "/javax.faces.resource/images/**",
				"/javax.faces.resource/inputswitch/**", "/javax.faces.resource/jquery/**",
				"/javax.faces.resource/keyboard/**", "/javax.faces.resource/lightbox/**",
				"/javax.faces.resource/messages/**", "/javax.faces.resource/moment/**",
				"/javax.faces.resource/outputpanel/**", "/javax.faces.resource/raphael/**",
				"/javax.faces.resource/rating/**", "/javax.faces.resource/schedule/**",
				"/javax.faces.resource/scrollpanel/**", "/javax.faces.resource/spacer/**",
				"/javax.faces.resource/touch/**", "/javax.faces.resource/tree/**", "/javax.faces.resource/images/**",
				"/javax.faces.resource/fa/**", "/javax.faces.resource/css/**", "/javax.faces.resource/jquery/**",
				"/assets/css/**","/assets/js/**","/assets/**","/assets/fonts/**","/css/**","/js/**"

		};

		http.authorizeRequests().antMatchers(resources).permitAll()
				.antMatchers("/", "/login/BussnesComAfrica", "/DashBoard/**",
						"/usermanagment/**","/viewProfile/**","deleteUser/**","/DriveStatisticalAnalysis/**","/DrivePermissions/**","/createUser/**","/userRegistrations/**",
						"/createUser/**","/userRegistrations/**","/processDeligationForm/**","/DriveAnalysis/**","/getData","/calenderppointment/**","/updateCalenderSignature/**","/calendersettings/**",
						"/processUpdateForm/**","/starts","/suggestion","/GmailAnalysis/**","/DashBoard/**","/Delegation/**","/DelegateAccount/**")
				.permitAll().antMatchers("/edwin/**").hasAnyRole("USER").anyRequest().authenticated().and().formLogin()
				.loginPage("/login/gmail").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
	}

//	 create two users, admin and user
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//	}
}
