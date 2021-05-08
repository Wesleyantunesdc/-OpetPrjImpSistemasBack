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
	
	public Curso save(Curso obj) {
		return repository.save(obj);
	}
	
	public Curso update(Long id,Curso obj) {
		Curso entity = repository.getOne(id);
		updateDate(entity,obj);
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	//Método auxiliar
	private void updateDate(Curso entity, Curso obj) {
		entity.setNomeCurso(obj.getNomeCurso());
		
	}
}
