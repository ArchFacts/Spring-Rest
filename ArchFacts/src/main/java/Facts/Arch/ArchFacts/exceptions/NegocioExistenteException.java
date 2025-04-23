package Facts.Arch.ArchFacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NegocioExistenteException extends RuntimeException{
    public NegocioExistenteException(String message) {super((message));}
}
