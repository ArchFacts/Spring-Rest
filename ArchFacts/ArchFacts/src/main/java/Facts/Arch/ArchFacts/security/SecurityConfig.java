package Facts.Arch.ArchFacts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
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
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/registro").permitAll()
                        .requestMatchers(HttpMethod.POST, "/negocios").permitAll()
                        .requestMatchers(HttpMethod.GET, "/negocios/**").authenticated()
                        .requestMatchers(HttpMethod.GET,"/usuarios").authenticated()
                        .requestMatchers(HttpMethod.PUT,"/usuarios").authenticated()
                        .requestMatchers(HttpMethod.POST,"/servicos").authenticated()
                        .requestMatchers(HttpMethod.GET,"/servicos/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE,"/usuarios").authenticated()
                        .requestMatchers(HttpMethod.POST, "/projetos").authenticated()
                        .requestMatchers(HttpMethod.POST, "/projetos/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/projetos/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/propostas/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/propostas").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/propostas").authenticated()
                        .requestMatchers(HttpMethod.POST, "/propostaServicos").authenticated()
                        .requestMatchers(HttpMethod.POST, "/propostaServicos/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/propostaServicos").authenticated()
                        .requestMatchers(HttpMethod.GET, "/propostaServicos/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/tarefas").authenticated()
                        .requestMatchers(HttpMethod.POST, "/tarefas").authenticated()
                        .requestMatchers(HttpMethod.GET, "/tarefas/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/tarefas/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/chamados/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/chamados/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/chamados/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/chamados/dashboard/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/parcelas/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/parcelas/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/dashboards/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/kpis/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/logs").permitAll()
                        .requestMatchers(HttpMethod.GET, "/eventos").authenticated()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/index.html").permitAll()
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