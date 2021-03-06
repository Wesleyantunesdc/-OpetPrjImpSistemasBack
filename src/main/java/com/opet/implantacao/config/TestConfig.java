package com.opet.implantacao.config;

import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Curso c1 = new Curso(null,"Psicologia");
		Curso c2 = new Curso(null,"Programação");
		Curso c3 = new Curso(null, "Medicina");
		
		Usuario u1 = new Usuario(null, "Wesley Antunes de Camargo", "wesley","123", sdf.parse("2000-12-12T00:00:00Z"),5,c2);
		Usuario u2 = new Usuario(null, "Eduarda Alves de Souza","dudas", "1234", sdf.parse("2000-09-28T00:00:00Z"),5,c1);
		Usuario u3 = new Usuario(null, "test","test", "123", sdf.parse("2000-09-28T00:00:00Z"),5,c1);


		cursoRepository.saveAll(Arrays.asList(c1,c2,c3));
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
	}
	
}
