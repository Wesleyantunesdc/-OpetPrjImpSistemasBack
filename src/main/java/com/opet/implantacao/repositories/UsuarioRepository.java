package com.opet.implantacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.opet.implantacao.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
