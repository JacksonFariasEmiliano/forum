package br.com.alura.forum.test;

import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.domain.dto.TopicoDto;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.service.TopicoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TopicoServiceTeste {

    @Mock
    CursoRepository cursoRepository;

    @Mock
    TopicoRepository topicoRepository;

    @InjectMocks
    TopicoService topicoService;

    @Test
    public void deveGravarTopicoNoBanco() {
        //Cenario
        Curso curso = new Curso();
        curso.setNome("Lab 5");
        curso.setCategoria("Java");
        curso.setId(1L);

        TopicoForm form = new TopicoForm();
        form.setTitulo("Java");
        form.setMensagem("Erro ao executar");

        when(cursoRepository.findByNome(anyString())).thenReturn(curso);

        TopicoDto actual= topicoService.cadastrar(form);
        assertEquals("Java", actual.getTitulo());

        verify(topicoRepository).save(any());
    }

    //fazer teste o crud completo com erro e sucesso
}
