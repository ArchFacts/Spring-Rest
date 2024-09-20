package Facts.Arch.ArchFacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeInexistenteException extends RuntimeException{
    public EntidadeInexistenteException(String message) {super(message);}
}
