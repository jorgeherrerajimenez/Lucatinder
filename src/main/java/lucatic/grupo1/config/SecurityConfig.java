package lucatic.grupo1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
* @author Jorge H.
* @version 05/06/20
*/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder encoder;

	//Configuración de querys personalizadas para acceder a los nombres de usuario y las autoridades
	//Todos los usuarios tendrán autoridad 'USER'
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.usersByUsernameQuery("select  username, password, enabled from perfil where username=?")
			.authoritiesByUsernameQuery("select u.username, r.role from perfil u inner join users_roles ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.id) where u.username=?")
			.dataSource(dataSource)
			.passwordEncoder(encoder);
	}

	//Configuración de rutas y permisos necesarios para llegar a ellas
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
			.antMatchers("/registro").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/perfil/addPerfil/**").permitAll()
			.antMatchers("/rperfil/**").permitAll()
			.anyRequest().hasAuthority("USER")
				.and()
			.csrf()
				.disable()
				.formLogin().loginPage("/login")
					.defaultSuccessUrl("/perfil/main")
					.failureUrl("/login?error=true")
					.usernameParameter("username")
					.passwordParameter("password")
				.and()
			.csrf()
				.disable()
				.headers().frameOptions().disable()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	//Ignora la seguridad en ciertos direcctorios
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/vendor/**", "/fonts/**");
	}
	
}