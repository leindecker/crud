package br.com.rest.services;


import java.util.List;
import javax.ws.rs.core.Response;

import br.com.rest.model.Funcionarios;

public interface FuncionariosService {
	
public Response save(Funcionarios funcionarios);
	
	public void delete(Integer id);
	
	public Funcionarios update(Funcionarios funcionarios);
	
	public Funcionarios findById(Integer id);
	
	public List<Funcionarios> findAll();
	
	public List<Funcionarios> findByName(String nome);

}
