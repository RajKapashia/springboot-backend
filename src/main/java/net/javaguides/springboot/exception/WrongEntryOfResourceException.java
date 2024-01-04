package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class WrongEntryOfResourceException extends RuntimeException{
    public WrongEntryOfResourceException(String message) {
        super(message);
    }
}
