package br.com.alura.forum.service;

import br.com.alura.forum.domain.Perfil;
import br.com.alura.forum.domain.Usuario;
import br.com.alura.forum.repository.PerfilRepository;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;
    private String nomeUsuario;

    @Override
    public Usuario novoUsuario(String novoUsuario, String senha, String perfil){
        Perfil perf = perfilRepository.findByNome(perfil);
        if (perf == null){
            perf = new Perfil();
            perf.setNome(perfil);

            perfilRepository.save(perf);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setPerfies(new HashSet<Perfil>());
        usuario.getPerfies().add(perf);

        usuarioRepository.save(usuario);

        return usuario;
    }
}
