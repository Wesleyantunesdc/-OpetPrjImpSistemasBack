package com.opet.implantacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opet.implantacao.entities.Usuario;
import com.opet.implantacao.repositories.SistemaRepository;

@Service
public class SistemaService {
	
	@Autowired
	private SistemaRepository repository;
	
	
	public Usuario efetuarLogin(Usuario usuario) {
		return repository.efetuarLogin(usuario.getNome(), usuario.getSenha());
	}
}
