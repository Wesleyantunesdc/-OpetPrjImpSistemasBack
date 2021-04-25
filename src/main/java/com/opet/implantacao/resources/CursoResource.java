package com.opet.implantacao.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opet.implantacao.entities.Curso;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

	@GetMapping
	public ResponseEntity<Curso> listarTodos(){
		Curso u1 = new Curso(null, "Analise");
		return ResponseEntity.ok().body(u1);
	}
}
