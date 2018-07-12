package br.com.rest.db.dao;

import java.util.List;

import br.com.rest.db.exception.DAOException;
import br.com.rest.model.Clientes;

public interface ClientesDAO {

	public Clientes save(Clientes clientes) throws DAOException;
	
	public Clientes update(Clientes clientes) throws DAOException;
	
	public List<Clientes> findByName(String name) throws DAOException;
	
	public Clientes findById(Integer id) throws DAOException;
	
	public List<Clientes> findAll() throws DAOException;
	
	public void delete(Clientes person) throws DAOException;

}
