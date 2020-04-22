package com.curso.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursomc.domain.Pedido;
import com.curso.cursomc.repositories.PedidoRepository;
import com.curso.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido busca(Integer id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado: "+ id
				+ ", Tipo:" + Pedido.class.getName())
				);
	}
}
