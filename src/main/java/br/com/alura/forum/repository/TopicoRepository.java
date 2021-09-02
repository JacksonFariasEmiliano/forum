package br.com.alura.forum.repository;

import br.com.alura.forum.domain.StatusTopico;
import br.com.alura.forum.domain.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

    Optional<Topico> findByTitulo(String titulo);


    //Query com dois parametros

//  Caso eu não queira seguir o padrão jpa de nomeclatura, porem o jpa montar as query
//  @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCuro)
//  List<Topico> carregarPorNOmeDoCurso(@Param("nomeCurso")String nomeCurso);
}
