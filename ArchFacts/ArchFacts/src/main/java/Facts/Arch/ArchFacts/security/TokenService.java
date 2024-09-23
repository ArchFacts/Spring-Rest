package Facts.Arch.ArchFacts.security;

import Facts.Arch.ArchFacts.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}") // Pegar valores da var de ambiente pelo caminho
    private String secret;
    public String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret); // Método de algoritmo
            String token = JWT.create()
                    .withIssuer("Archfacts-API")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm); // Assinatura
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro na geração de token", exception);
        }
    }

    public String validarToken (String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Archfacts-API")
                    .build()
                    .verify(token) // descriptografa o token
                    .getSubject(); // Pega o subject salvo lá em cima
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
