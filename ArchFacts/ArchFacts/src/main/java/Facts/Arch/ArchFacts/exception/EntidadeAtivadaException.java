package Facts.Arch.ArchFacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeAtivadaException extends RuntimeException {
    public EntidadeAtivadaException(String message) {super(message);}
}
