package com.opet.implantacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.opet.implantacao.entities.Usuario;

@EnableJpaRepositories
@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.username = ?1 AND u.senha = ?2 ")
	Usuario efetuarLogin(String username, String senha);
	
	@Query("SELECT count(1) from Usuario u WHERE u.username = ?1")
	int usuarioExistente(String username);
	
	Usuario findByUsernameIgnoreCase(String username);
}
