package Facts.Arch.ArchFacts.security;

import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import com.auth0.jwt.interfaces.Header;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
// Filtro só acontece uma vez
public class FiltroSeguranca extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.recuperarToken(request);
        if (token != null) {
            String login = tokenService.validarToken(token);
        UserDetails usuario = usuarioRepository.findByEmail(login);

        UsernamePasswordAuthenticationToken autenticao =
                new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticao);
        }
        filterChain.doFilter(request, response); // Pular para o próximo filtro
    }

    private String recuperarToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", ""); // Padronização, ao mandar um header com autorização de token devemos nomeá-lo, nesse caso é a classificação e depois o token
    }
}
