package br.com.alura.forum.exceptions;

public class FalhaAoAtualizarException extends RuntimeException{

    public FalhaAoAtualizarException(String message) {
        super(message);
    }
}
