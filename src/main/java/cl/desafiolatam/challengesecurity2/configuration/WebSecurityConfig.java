package cl.desafiolatam.challengesecurity2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//Inicio de la clase WebSecurityConfig que extiende (hereda) laClase WebSecurityAdapter

	@Autowired
	private UserDetailsService userDetailsService;
	
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { //Metodo configure que crea dos usuarios  a traves del objeto de gestion de autenticacion
        auth.userDetailsService(userDetailsService).passwordEncoder( passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception { //Define accesos y páginas para cada rol. También una pagina de acceso denegado.
        http.csrf().disable()
        		.authorizeRequests()
        		.antMatchers("/admin/**").hasRole("ADMIN")
        		.antMatchers("/client/**").hasRole("CLIENT")
        		.antMatchers("/login").permitAll()
        		.anyRequest().authenticated()
        		
        		.and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/client")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/recurso-prohibido");
    }
    
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    
    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler
    authenticationSuccessHandler) {
    this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }


}
