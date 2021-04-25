package com.opet.implantacao.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.opet.implantacao.entities.Curso;
import com.opet.implantacao.repositories.CursoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void run(String... args) throws Exception {
		Curso c1 = new Curso(null,"Psicologia");
		Curso c2 = new Curso(null,"Programação");
		Curso c3 = new Curso(null, "Medicina");
		
		cursoRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
	
}
