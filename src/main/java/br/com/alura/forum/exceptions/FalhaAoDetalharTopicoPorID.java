package br.com.alura.forum.exceptions;

public class FalhaAoDetalharTopicoPorID extends RuntimeException{
    public FalhaAoDetalharTopicoPorID(String message) {
        super(message);
    }
}
