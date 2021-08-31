package br.com.alura.forum.exceptions;

public class FalhaAoDeletarTopico extends RuntimeException{
    public FalhaAoDeletarTopico(String message) {
        super(message);
    }
}
