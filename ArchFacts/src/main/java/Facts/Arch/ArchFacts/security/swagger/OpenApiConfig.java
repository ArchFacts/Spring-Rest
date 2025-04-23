package Facts.Arch.ArchFacts.security.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title ="ArchFacts API Rest",
                description = "API Rest desenvolvida pela equipe ArchFacts",
                contact = @Contact(
                        name = "Archfacts",
                        url = "https://github.com/ArchFacts",
                        email = "luis.almeida@sptech.school"
                ),
                license = @License(name = "ArchFacts License"),
                version = "0.1"
        )
)
@SecurityScheme(
        name = "Bearer", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT"
)
public class OpenApiConfig {
}
