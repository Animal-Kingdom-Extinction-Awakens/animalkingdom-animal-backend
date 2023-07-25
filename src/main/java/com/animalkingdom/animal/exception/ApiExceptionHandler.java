package com.animalkingdom.animal.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno no servidor. Tente novamente mais tarde.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage());
        return handleException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handle(ResponseStatusException e) {
        return handleException(HttpStatus.valueOf(e.getStatusCode().value()), e.getReason());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handle(MethodArgumentNotValidException e) {
        List<ValidationFailureResponse> details = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> ValidationFailureResponse.builder().field(fieldError.getField()).message(fieldError.getDefaultMessage()).build())
                .toList();
        return handleException(HttpStatus.BAD_REQUEST, "Campos inválidos", details);
    }

    @ExceptionHandler({Exception.class, Throwable.class})
    public ResponseEntity<ApiError> handleException(Exception ex) {
        log.error(ex.getMessage());
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR , "Ocorreu um erro interno no servidor. Tente novamente mais tarde.");
    }

    private ResponseEntity<ApiError> handleException(HttpStatus status, Object mensagem) {
        ApiError response = ApiError.builder()
                .timestamp(LocalDateTime.now().toString())
                .message(mensagem)
                .traceId(UUID.randomUUID().toString())
                .build();

        return ResponseEntity
                .status(status)
                .body(response);
    }

    private ResponseEntity<ApiError> handleException(HttpStatus status, Object mensagem, List<ValidationFailureResponse> error) {
        ApiError response = ApiError.builder()
                .timestamp(LocalDateTime.now().toString())
                .message(mensagem)
                .details(error)
                .traceId(UUID.randomUUID().toString())
                .build();

        return ResponseEntity
                .status(status)
                .body(response);
    }

}
