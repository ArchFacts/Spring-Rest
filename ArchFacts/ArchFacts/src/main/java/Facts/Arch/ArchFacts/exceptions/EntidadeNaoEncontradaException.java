package Facts.Arch.ArchFacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String message) {super(message);}
}
