package risto.turtiainen.entropia_backend.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import risto.turtiainen.entropia_backend.services.QueryService;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiError error = new ApiError(
                LocalDateTime.now(),
                status.value(),
                status.name(),
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiError error = new ApiError(
                LocalDateTime.now(),
                status.value(),
                status.name(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError error = new ApiError(
                LocalDateTime.now(),
                status.value(),
                status.name(),
                "Something went wrong. Please contact support.",
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
