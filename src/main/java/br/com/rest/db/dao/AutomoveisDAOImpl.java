package br.com.rest.db.dao;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.rest.db.exception.DAOException;
import br.com.rest.db.exception.DAOExceptionEnum;

import br.com.rest.model.Automoveis;

@Named
public class AutomoveisDAOImpl  implements AutomoveisDAO{

	@Inject
	private EntityManager manager;
	
	public Automoveis save(Automoveis automoveis) {
		manager.getTransaction().begin();
		manager.persist(automoveis);
		manager.getTransaction().commit();
		return automoveis;
	}

	public Automoveis update(Automoveis automoveis) {
		manager.getTransaction().begin();
		manager.merge(automoveis);
		manager.getTransaction().commit();
		return automoveis;
	}

	public List<Automoveis> findByName(String nome) {
		// SELECT p FROM AutomoveisEntity p ORDER BY p.modelo
		List<Automoveis> auto = null;
		try {
			TypedQuery<Automoveis> query = manager.createQuery("select p from Automoveis p where p.modelo like :modelo", Automoveis.class);
			query.setParameter("modelo", "%" + nome + "%" );
			auto = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return auto;
	}

	public Automoveis findById(Integer id) {
		Automoveis automoveis = null;
		automoveis = manager.find(Automoveis.class, id);
		return automoveis;
	}

	public List<Automoveis> findAll() {
		List<Automoveis> automoveis = null;
		try {
			TypedQuery<Automoveis> query = manager.createQuery("select p FROM Automoveis p ORDER BY p.modelo", Automoveis.class);
			automoveis = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return automoveis;
	}

	public void delete(Automoveis automoveis) {
		manager.getTransaction().begin();
		manager.remove(automoveis);
		manager.getTransaction().commit();
	}

}
