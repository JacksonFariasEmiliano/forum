package br.com.alura.forum.service;

import br.com.alura.forum.domain.Usuario;

public interface SegurancaService {

    public Usuario novoUsuario(String nomeUsuario, String senha, String autorizacao);
}
