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
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
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
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
