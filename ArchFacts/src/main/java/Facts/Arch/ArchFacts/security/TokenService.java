package Facts.Arch.ArchFacts.security;

import Facts.Arch.ArchFacts.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.impl.JWTParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

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
            return null;
        }
    }
//    public String extrairIdPeloToken(HttpHeaders headers, String secret) {
//        String token = headers.get("Authorization").get(0); // Pegar o token do headers
//        String jwt = token.replace("Bearer", ""); // Removendo o Bearer (trava)
//
//        Claims claims = Jwts.parser().setSigningKey(secret).
//    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
