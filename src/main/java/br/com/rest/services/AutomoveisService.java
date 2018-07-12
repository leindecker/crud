package br.com.rest.services;

import java.util.List;
import javax.ws.rs.core.Response;
import br.com.rest.model.Automoveis;

public interface AutomoveisService {
	
	public Response save(Automoveis automoveis);
	
	public void delete(Integer id);
	
	public Automoveis update(Automoveis automoveis);
	
	public Automoveis findById(Integer id);
	
	public List<Automoveis> findAll();
	
	public List<Automoveis> findByName(String nome);

}
