package br.com.alura.forum.repository;

import br.com.alura.forum.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    public Perfil findByNome(String nome);

  }
