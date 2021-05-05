package com.opet.implantacao.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.opet.implantacao.entities.Usuario;
import com.opet.implantacao.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long Id) {
		Usuario obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "validar_username/{username}")
	public ResponseEntity<Boolean> validarUsername(@PathVariable String username) {
		 boolean existe = service.validarUsername(username);
		return ResponseEntity.ok().body(existe);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) throws Exception{
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping
	public boolean efetuarLogin(@RequestBody Usuario obj){
		Usuario u = service.efetuarLogin(obj);
		if( u == null) {
			return false;//ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}else {
			return true;//ResponseEntity.accepted().body(u);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
