package br.com.rest.services;

import java.util.List;
import javax.ws.rs.core.Response;

import br.com.rest.model.Clientes;

public interface ClientesService {

	public Response save(Clientes Clientes);
	
	public void delete(Integer id);
	
	public Clientes update(Clientes Clientes);
	
	public Clientes findById(Integer id);
	
	public List<Clientes> findAll();
	
	public List<Clientes> findByName(String nome);
	
}
