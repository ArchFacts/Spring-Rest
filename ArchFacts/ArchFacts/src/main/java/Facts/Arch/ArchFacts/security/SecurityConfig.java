package Facts.Arch.ArchFacts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Habilitar minhas configurações do WebSec aqui
public class SecurityConfig {
    @Autowired
    FiltroSeguranca filtroSeguranca;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Bean // Para o Spring instanciar a classe
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() //Independe ROle
                        .requestMatchers(HttpMethod.POST,"/auth/registro").permitAll()
                        .requestMatchers(HttpMethod.GET,"/usuarios").authenticated()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/index.html").permitAll()
                        .requestMatchers(HttpMethod.POST, "/negocios").authenticated()
                        .anyRequest().permitAll())
                .addFilterBefore(filtroSeguranca, UsernamePasswordAuthenticationFilter.class) // Adiciona um filtro antes disso
                .build(); // Sem guardar estado (usar tokens)

    }
    @Bean // Para fazer injeção de dependência
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Somente para pegar a instância
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // Para criptografar a senha
        return new BCryptPasswordEncoder(); // Transforma a senha em hash
    }
}