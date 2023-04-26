/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoNegocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsService users() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}123")
//                .roles("USER", "VENDEDOR", "ADMIN")
//                .build();
//        UserDetails sales = User.builder()
//                .username("vendedor")
//                .password("{noop}123")
//                .roles("USER", "VENDEDOR")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, sales, admin);
//    }
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/errores/**",
                        "/error",
                        "/webjars/**",
                        "/css/**",
                        "/index").permitAll()
                .requestMatchers(
                        "/inventario/nuevo",
                        "/inventario/modificar/**",
                        "/inventario/eliminar/**",
                        "/inventario/guardar",
                        "/cliente/nuevo",
                        "/cliente/guardar",
                        "/cliente/modificar/**",
                        "/cliente/eliminar/**",
                        "/inventario/listado",
                        "/cliente/listado")
                .hasRole("ADMIN")               
                .requestMatchers("/",                       
                        "/carrito/listado"
                        )
                .hasAnyRole("USER", "ADMIN"))
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/errores/403");
        return http.build();

    }
}
