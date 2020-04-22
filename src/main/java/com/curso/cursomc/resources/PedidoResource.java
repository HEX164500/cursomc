package com.curso.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.cursomc.domain.Pedido;
import com.curso.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id){
		
		Pedido pedido = service.busca(id);
		
		return ResponseEntity.ok().body(pedido);
		
	}
}
