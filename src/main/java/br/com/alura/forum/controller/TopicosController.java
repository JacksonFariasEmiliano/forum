package br.com.alura.forum.controller;

import br.com.alura.forum.controller.form.AtualizacaoTopicoform;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.domain.dto.TopicoDto;
import br.com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoService topicoService;

	@GetMapping
	public ResponseEntity<Page<TopicoDto>> lista(@RequestParam(required = false) String nomeCurso, @RequestParam int pagina,
												 @RequestParam int qtd, @RequestParam String ordenacao){
		Page<TopicoDto> list = topicoService.lista(nomeCurso, 1,10,ordenacao);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/busca")
	public ResponseEntity<TopicoDto> buscaPorIdOuTitulo(@RequestParam Long id, @RequestParam String titulo){
		return ResponseEntity.ok(topicoService.buscarPorIdTitulo(id, titulo));
	}


	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id){
		return ResponseEntity.ok().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form){
		return ResponseEntity.ok(topicoService.cadastrar(form));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto>atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoform form){
		return ResponseEntity.ok(topicoService.atualizar(id, form));
	}

	//Deletar topico
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<Topico> remover(@PathVariable Long id){
		return ResponseEntity.ok().build();
	}
}
