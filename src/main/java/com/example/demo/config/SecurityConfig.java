package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import com.example.demo.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
/* Es una configuracion de seguridad*/
    @Bean
    /* Vamos a definir como las reglas que URLs necesitan login y quein no*/
    SecurityFilterChain filtro(HttpSecurity http){
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers( "/").permitAll()
                .anyRequest().authenticated()
            )/* Mi pagina de inicio de sesion, cualquiera puede verla*/
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
    /*Esto nos sirve para encriptar contraseñas, para proteccion*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        ArrayList<User> usuarios = new ArrayList<>();
        usuarios.add(new User("prueba", "6767"));
        usuarios.add(new User("isabela", "1818"));

        List<UserDetails> lista = new ArrayList<>();

        for (User u : usuarios) {
            lista.add(
                org.springframework.security.core.userdetails.User
                    .withUsername(u.getUsername())
                    .password(encoder.encode(u.getPassword()))
                    .roles("USER")
                    .build()
            );
        }

        return new InMemoryUserDetailsManager(lista);
    }
}