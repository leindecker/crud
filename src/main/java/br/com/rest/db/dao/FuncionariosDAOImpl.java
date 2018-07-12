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
import br.com.rest.model.Funcionarios;

@Named
public class FuncionariosDAOImpl implements FuncionarisDAO {
	
	@Inject
	private EntityManager manager;

	public Funcionarios save(Funcionarios funcionarios) {
		manager.getTransaction().begin();
		manager.persist(funcionarios);
		manager.getTransaction().commit();
		return funcionarios;
	}

	public Funcionarios update(Funcionarios funcionarios) {
		manager.getTransaction().begin();
		manager.merge(funcionarios);
		manager.getTransaction().commit();
		return funcionarios;
	}

	public List<Funcionarios> findByName(String nome) {
		List<Funcionarios> funcionarios = null;
		try {
			TypedQuery<Funcionarios> query = manager.createQuery("select p from Funcionarios p where p.nome like :nome", Funcionarios.class);
			query.setParameter("nome", "%" + nome + "%");
			funcionarios = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return funcionarios;
	}

	public Funcionarios findById(Integer id) {
		Funcionarios funcionarios = null;
		funcionarios = manager.find(Funcionarios.class, id);
		return funcionarios;
	}

	public List<Funcionarios> findAll() {
		List<Funcionarios> funcionarios = null;
		try {
			TypedQuery<Funcionarios> query = manager.createQuery("select p FROM Funcionarios p ORDER BY p.nome", Funcionarios.class);
			funcionarios = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return funcionarios;
	}

	public void delete(Funcionarios funcionarios) {
		manager.getTransaction().begin();
		manager.remove(funcionarios);
		manager.getTransaction().commit();
		
	}
	
	
}
