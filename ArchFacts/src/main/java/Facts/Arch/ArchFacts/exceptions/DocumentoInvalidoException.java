package Facts.Arch.ArchFacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DocumentoInvalidoException extends RuntimeException{
    public DocumentoInvalidoException(String message) {super(message);}
}
