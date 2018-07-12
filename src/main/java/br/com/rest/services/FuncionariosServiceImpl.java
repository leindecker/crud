package br.com.rest.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import br.com.rest.db.dao.FuncionarisDAO;
import br.com.rest.model.Funcionarios;


@Path("/funcionarios")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
@RequestScoped
public class FuncionariosServiceImpl  implements FuncionariosService{

	@Inject
	private FuncionarisDAO dao;
	
	public FuncionarisDAO getDao() {
		return dao;
	}
	
	public void setDao(FuncionarisDAO dao) {
		this.dao = dao;
	}
	
	@POST
	public Response save(Funcionarios funcionarios) {
		try {
			validaFuncionariuo(funcionarios);
			funcionarios = dao.save(funcionarios);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return Response.ok().entity(funcionarios).build();
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Funcionarios funcionarios = null;
		try {
			funcionarios = dao.findById(id);
			dao.delete(funcionarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@PUT
	public Funcionarios update(Funcionarios funcionarios) {
		try {
			validaFuncionariuo(funcionarios);
			funcionarios = dao.update(funcionarios);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return funcionarios;
	}

	@GET
	@Path("{id}")
	public Funcionarios findById(@PathParam("id") Integer id) {
		Funcionarios funcionarios = null;
		try {
			funcionarios = dao.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return funcionarios;
	}

	@GET
	public List<Funcionarios> findAll() {
		List<Funcionarios> funcionarios = null;
		try {
			funcionarios = dao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return funcionarios;
	}

	@GET
	@Path("nome/{nome}")
	public List<Funcionarios> findByName(@PathParam("nome") String nome) {
		List<Funcionarios> funcionarios = null;
		try {
			funcionarios = dao.findByName(nome);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return funcionarios;
	}
	
	private void validaFuncionariuo(Funcionarios funcionarios) throws WebApplicationException {
		if (funcionarios.getNome() == null || funcionarios.getNome().isEmpty()) {
			throw new WebApplicationException(Status.NOT_ACCEPTABLE);
		}
	}

}
