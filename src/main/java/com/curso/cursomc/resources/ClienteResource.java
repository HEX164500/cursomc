package com.curso.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.cursomc.domain.Cliente;
import com.curso.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id){
		
		Cliente obj = clienteService.busca(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
