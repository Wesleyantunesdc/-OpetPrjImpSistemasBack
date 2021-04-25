package com.opet.implantacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opet.implantacao.entities.Curso;
import com.opet.implantacao.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso findById(Long id){
		Optional<Curso> obj = repository.findById(id);
		return obj.get();
	}
}
