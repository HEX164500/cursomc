package com.curso.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursomc.domain.Cliente;
import com.curso.cursomc.repositories.ClienteRepository;
import com.curso.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente busca(Integer id) {
		
		Optional<Cliente> obj = clienteRepository.findById(id);
		
		return obj.orElseThrow( 
				() -> new ObjectNotFoundException("Objeto não encontrado Id: "  + id
						+ ", Tipo: " + Cliente.class.getName())
				);
	}
}
