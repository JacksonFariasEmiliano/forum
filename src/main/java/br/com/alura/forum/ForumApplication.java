package br.com.alura.forum;

import br.com.alura.forum.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
//public class ForumApplication implements CommandLineRunner{
public class ForumApplication {

//	@Autowired
//	private PerfilRepository perfilRepository;

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Perfil administrador = new Perfil();
//		administrador.setNome("ROLE_ADM");
//
//		Perfil usuario = new Perfil();
//		usuario.setNome("ROLE_USR");
//
//		perfilRepository.saveAll(Arrays.asList(administrador, usuario));
//
//	}

}

