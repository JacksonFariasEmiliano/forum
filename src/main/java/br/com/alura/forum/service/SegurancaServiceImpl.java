package br.com.alura.forum.service;

import br.com.alura.forum.domain.Perfil;
import br.com.alura.forum.domain.Usuario;
import br.com.alura.forum.repository.PerfilRepository;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.HashSet;


//TODO refazer com meu exemplpo
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;


    @Override
    @Transactional
    public Usuario novoUsuario(String novoUsuario, String senha, String perfil){
        Perfil perf = perfilRepository.findByNome(perfil);
        if (perf == null){
            perf = new Perfil();
            perf.setNome(perfil);

            perfilRepository.save(perf);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(novoUsuario);
        usuario.setSenha(senha);
        usuario.getPerfies().add(perf);

        usuarioRepository.save(usuario);

        return usuario;
    }
}
