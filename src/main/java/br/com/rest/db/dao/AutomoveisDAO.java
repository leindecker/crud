package br.com.rest.db.dao;

import java.util.List;
import br.com.rest.model.Automoveis;

public interface AutomoveisDAO {

	public Automoveis save(Automoveis automoveis);
	
	public Automoveis update(Automoveis automoveis);
	
	public List<Automoveis> findByName(String nome);
	
	public Automoveis findById(Integer id);
	
	public List<Automoveis> findAll();
	
	public void delete(Automoveis automoveis);
}
