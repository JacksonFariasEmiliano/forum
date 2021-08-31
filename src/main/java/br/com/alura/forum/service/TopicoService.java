package br.com.alura.forum.service;

import br.com.alura.forum.controller.form.AtualizacaoTopicoform;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.domain.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.domain.dto.TopicoDto;
import br.com.alura.forum.exceptions.FalhaAoAtualizarException;
import br.com.alura.forum.exceptions.FalhaAoDeletarTopico;
import br.com.alura.forum.exceptions.FalhaAoDetalharTopicoPorID;
import br.com.alura.forum.exceptions.TopicoNaoEncontradoException;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    //Lista topicos  por quantidade por pagina, numero de pagina e ordem a ser exibida
    public Page<TopicoDto> lista(String nomeCurso, int pagina, int qtd, String ordenacao) {

        Pageable paginacao = PageRequest.of(pagina, qtd, Sort.Direction.ASC, ordenacao);
//		Pageable paginacao = PageRequest.of(pagina, qtd, Sort.Direction.DESC, ordenacao);

        if (nomeCurso == null) {
            Page<Topico> topicos = topicoRepository.findAll(paginacao);
            return TopicoDto.converter(topicos);
        }else{
            //Busca utilizando entidade + atributo de relacionamento
            Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
            return TopicoDto.converter(topicos);
        }
    }

    //Lista topicos por id
    public DetalhesDoTopicoDto detalhar (Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()){
            return new DetalhesDoTopicoDto(topico.get());
        }
        throw new FalhaAoDetalharTopicoPorID("Falha ao buscar id");
    }

    //Busca utilizando dois parametros
    public TopicoDto buscarPorIdTitulo(Long id, String titulo){
        if(id == null){

            return new TopicoDto(topicoRepository.findByTitulo(titulo).orElseThrow(
                    () -> new TopicoNaoEncontradoException("Topico não encontrado")));
        }
        return new TopicoDto(topicoRepository.findById(id).orElseThrow(
                () -> new TopicoNaoEncontradoException("Topico não encontrado")));
    }

    //Cadastra novo topico
    public TopicoDto cadastrar(TopicoForm form){
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico) ;

        return new TopicoDto(topico);
    }

    //Atualizar topico
    public TopicoDto atualizar(Long id, AtualizacaoTopicoform form){
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()){
            Topico topico = form.atualizar(id, topicoRepository);
            return new TopicoDto(topico);
        }
        throw new FalhaAoAtualizarException("Não foi possivel atualizar");
    }

    public void remover (Long id) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            topicoRepository.deleteById(id);
        }
        throw new FalhaAoDeletarTopico("Id não encontrado");
    }

}
