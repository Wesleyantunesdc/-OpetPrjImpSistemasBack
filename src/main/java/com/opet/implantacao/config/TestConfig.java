package com.opet.implantacao.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.opet.implantacao.entities.Curso;
import com.opet.implantacao.entities.Usuario;
import com.opet.implantacao.repositories.CursoRepository;
import com.opet.implantacao.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Curso c1 = new Curso(null,"Psicologia");
		Curso c2 = new Curso(null,"Programação");
		Curso c3 = new Curso(null, "Medicina");
		
		Usuario u1 = new Usuario(null, "Wesley Antunes de Camargo", "123", Instant.parse("2000-12-12T00:00:00Z"),5,c2);
		Usuario u2 = new Usuario(null, "Eduarda Alves de Souza", "123", Instant.parse("2000-09-28T00:00:00Z"),5,c1);

		cursoRepository.saveAll(Arrays.asList(c1,c2,c3));
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
