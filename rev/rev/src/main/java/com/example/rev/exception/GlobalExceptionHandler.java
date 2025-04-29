package com.example.rev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler{
    //Setando a opção de erro quando o id não for encontrado
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("Mensagem", erro.getMessage()));

    }
    //Setando a opção de erro quando o email já estiver cadastrado
    @ExceptionHandler(EmailCadastradoException.class) //
    public ResponseEntity<Map<String, Object>> handleEmailCadastradoException(EmailCadastradoException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Mensagem", erro.getMessage()));
    }
    //Setando a opção de erro quando o email não for cadastrado
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }

    //Setando a opção de erro quando não encontrar o recu
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", erro.getMessage()));
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro){
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(Map.of("mensagem", erro.getMessage()));
    }

}