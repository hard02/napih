package napih_server.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiEndpointNotFoundException.class)
    public ResponseEntity<String> handle(ApiEndpointNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

}
