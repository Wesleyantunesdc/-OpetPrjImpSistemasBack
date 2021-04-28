package com.opet.implantacao.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.opet.implantacao.entities.Usuario;

@EnableJpaRepositories
@Repository
@Transactional
public interface SistemaRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.nome = ?1 AND u.senha = ?2 ")
	Usuario efetuarLogin(String username, String senha);
}
