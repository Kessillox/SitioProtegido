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

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//Inicio de la clase WebSecurityConfig que extiende (hereda) laClase WebSecurityAdapter

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { //Metodo configure que crea dos usuarios  a traves del objeto de gestion de autenticacion
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception { //Define accesos y páginas para cada rol. También una pagina de acceso denegado.
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/client")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/recurso-prohibido");
    }

}
