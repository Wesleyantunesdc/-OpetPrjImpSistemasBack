package com.opet.implantacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opet.implantacao.entities.Usuario;
import com.opet.implantacao.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id){
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) throws Exception {
		//Seta como nulo o Id para que o mesmo não sobreescreva outros objetos
		if(obj.getId()!=null)
			obj.setId(null);
		//Valida o username
		if(!validarUsername(obj.getUsername())) {
			return repository.save(obj);
		}else {
			throw new Exception("Usuario ja cadastrado!");
		}
		
	}
	
	public Usuario efetuarLogin(Usuario obj) {
		return repository.efetuarLogin(obj.getUsername(), obj.getSenha());
	}
	
	public boolean validarUsername(String username) {
		if(repository.usuarioExistente(username) == 1)
			return true;
		else
			return false;
	}
	
	public Usuario findByUsuario(String username) {
		return repository.findByUsernameIgnoreCase(username);
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getOne(id);
		updateDate(entity,obj);
		return repository.save(entity);
	}
	
	private void updateDate(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setUsername(obj.getUsername());
		entity.setSenha(obj.getSenha());
		entity.setPeriodo(obj.getPeriodo());
		entity.setCurso(obj.getCurso());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
