package br.com.rest.db.dao;

import java.util.List;
import br.com.rest.model.Funcionarios;

public interface FuncionarisDAO {

	public Funcionarios save(Funcionarios funcionarios);
	
	public Funcionarios update(Funcionarios funcionarios);
	
	public List<Funcionarios> findByName(String nome);
	
	public Funcionarios findById(Integer id);
	
	public List<Funcionarios> findAll();
	
	public void delete(Funcionarios funcionarios);
	
}
