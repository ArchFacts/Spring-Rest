package Facts.Arch.ArchFacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContaExistenteAtivadaException extends RuntimeException {
    public ContaExistenteAtivadaException(String message) {super(message);}
}
