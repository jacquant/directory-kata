package wtf.jacquant.directorykata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(final Long id) {
        super("Could not find company with id=" + id);
    }
}
