package br.com.rest.db.dao;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.rest.db.exception.DAOException;
import br.com.rest.db.exception.DAOExceptionEnum;

import br.com.rest.model.Clientes;
@Named
public class ClientesDAOImpl implements ClientesDAO{
	
	@Inject
	private EntityManager manager;

	public Clientes save(Clientes clientes) throws DAOException {
		manager.getTransaction().begin();
		manager.persist(clientes);
		manager.getTransaction().commit();
		return clientes;
	}

	public Clientes update(Clientes clientes) throws DAOException {
		manager.getTransaction().begin();
		manager.merge(clientes);
		manager.getTransaction().commit();
		return clientes;
	}

	public List<Clientes> findByName(String nome) throws DAOException {
		List<Clientes> clientes = null;
		try {
			TypedQuery<Clientes> query = manager.createQuery("select p from Clientes p where p.nome like :nome", Clientes.class);
			query.setParameter("nome", "%" + nome + "%");
			clientes = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return clientes;
	}

	public Clientes findById(Integer id) throws DAOException {
		Clientes clientes = null;
		clientes = manager.find(Clientes.class, id);
		return clientes;
	}

	public List<Clientes> findAll() throws DAOException {
		List<Clientes> cliente = null;
		try {
			TypedQuery<Clientes> query = manager.createQuery("select p FROM Clientes p ORDER BY p.nome", Clientes.class);
			cliente = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cliente;
	}

	public void delete(Clientes clientes) throws DAOException {
		manager.getTransaction().begin();
		manager.remove(clientes);
		manager.getTransaction().commit();
		
	}

}
