package com.example.avaliacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

// Classe responsável por capturar e tratar exceções globais da aplicação
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata exceções do tipo RuntimeException e retorna uma resposta com código 400 (Bad Request)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRuntimeException(RuntimeException erro) {
        // Retorna uma mensagem personalizada indicando que houve um erro com a requisição
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));  // Retorna a mensagem de erro
    }

    // Trata exceções de argumento inválido (MethodArgumentNotValidException) e retorna uma resposta com código 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handMethodArgumentNotValidException(MethodArgumentNotValidException erro) {
        // Retorna a mensagem do primeiro erro de validação do campo
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }

    // Trata exceções quando um método HTTP não é suportado (HttpRequestMethodNotSupportedException) e retorna uma resposta com código 404
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro) {
        // Retorna uma mensagem indicando que o recurso não foi encontrado
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Recurso não encontrado."));
    }

    // Trata exceções quando não há recurso encontrado (NoResourceFoundException) e retorna uma resposta com código 404
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro) {
        // Retorna uma mensagem indicando que a URL é inválida
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "URL INVÁLIDA"));
    }

    // Trata exceções quando o corpo da requisição não pode ser lido corretamente (HttpMessageNotReadableException) e retorna uma resposta com código 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpMessageNotReadableException(HttpMessageNotReadableException erro) {
        // Retorna uma mensagem indicando que o corpo da requisição está ausente ou mal formatado
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem","Corpo da requisição ausente ou mal formatado"));
    }
}
