package br.com.alura.forum.exceptions;

public class TopicoNaoEncontradoException extends RuntimeException{
    public TopicoNaoEncontradoException(String message) {
        super(message);
    }
}
