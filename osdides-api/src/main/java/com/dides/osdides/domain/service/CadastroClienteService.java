package com.dides.osdides.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dides.osdides.domain.exception.NegocioException;
import com.dides.osdides.domain.model.Cliente;
import com.dides.osdides.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente ) {
		
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long  clienteId ) {
		clienteRepository.deleteById(clienteId);
	}
}
