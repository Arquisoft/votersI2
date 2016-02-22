package es.uniovi.asw.webapp.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such voter")
public class VoterNotFoundException extends RuntimeException {
}
