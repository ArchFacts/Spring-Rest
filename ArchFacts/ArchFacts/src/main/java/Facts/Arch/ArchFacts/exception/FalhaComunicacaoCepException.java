package Facts.Arch.ArchFacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class FalhaComunicacaoCepException extends RuntimeException{
    public FalhaComunicacaoCepException(String message) {super(message);}
}
