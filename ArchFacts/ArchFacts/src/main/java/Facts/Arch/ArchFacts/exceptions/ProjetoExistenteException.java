package Facts.Arch.ArchFacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProjetoExistenteException extends RuntimeException{
    public ProjetoExistenteException(String message) {super((message));}
}
