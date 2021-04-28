package com.opet.implantacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opet.implantacao.entities.Usuario;
import com.opet.implantacao.services.SistemaService;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {
	
	@Autowired
	private SistemaService service;
	
	
	@PutMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		Usuario u = service.efetuarLogin(obj);
		if(u!=null) {
			return ResponseEntity.accepted().body(u);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
}
