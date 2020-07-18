package prob.qmms_service.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.NoResultException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(NoResultException e){
        return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(DataIntegrityViolationException e){
        return new ResponseEntity<ErrorDto>(new ErrorDto("Query already exists with with the given id", HttpStatus.CONFLICT.value()),HttpStatus.CONFLICT);
    }

}
