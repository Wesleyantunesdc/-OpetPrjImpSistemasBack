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
import com.opet.implantacao.error.ResourceNotFoundException;
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
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@GetMapping(value = "/validar_username/{username}")
//	public ResponseEntity<Boolean> validarUsername(@PathVariable String username) {
//		 boolean existe = service.validarUsername(username);
//		return ResponseEntity.ok().body(existe);
//	}
	
	@GetMapping(value = "/validar_username/{username}")
	public ResponseEntity<Usuario> validar_username(@PathVariable String username){
		Usuario usuario = service.findByUsuario(username);
		if(usuario ==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(usuario);
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) throws Exception{
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/login")
	public ResponseEntity<?> efetuarLogin(@RequestBody Usuario obj){
		Usuario u = service.efetuarLogin(obj);
		if( u == null) {
			throw new ResourceNotFoundException("Usuario e/ou senha incorretos!\n"+obj.getUsername()+"/"+obj.getSenha());
		}
		return ResponseEntity.accepted().body(u);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario obj){
		Usuario usuario = service.update(id, obj);
		return ResponseEntity.ok().body(usuario);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
