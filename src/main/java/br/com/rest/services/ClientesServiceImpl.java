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
import br.com.rest.db.dao.ClientesDAO;
import br.com.rest.model.Clientes;

@Path("/clientes")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
@RequestScoped
public class ClientesServiceImpl implements ClientesService {

	@Inject
	private ClientesDAO dao;

	public ClientesDAO getDao() {
		return dao;
	}

	public void setDao(ClientesDAO dao) {
		this.dao = dao;
	}

	@POST
	public Response save(Clientes clientes) {
		try {
			validaCliente(clientes);
			clientes = dao.save(clientes);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return Response.ok().entity(clientes).build();
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Clientes clientes = null;
		try {
			clientes = dao.findById(id);
			dao.delete(clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@PUT
	public Clientes update(Clientes clientes) {
		try {
			validaCliente(clientes);
			clientes = dao.update(clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return clientes;
	}

	@GET
	@Path("{id}")
	public Clientes findById(@PathParam("id") Integer id) {
		Clientes clientes = null;
		try {
			clientes = dao.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return clientes;
	}

	@GET
	public List<Clientes> findAll() {
		List<Clientes> clientes = null;
		try {
			clientes = dao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return clientes;
	}

	@GET
	@Path("nome/{nome}")
	public List<Clientes> findByName(@PathParam("nome") String nome) {
		List<Clientes> clientes = null;
		try {
			clientes = dao.findByName(nome);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return clientes;
	}

	private void validaCliente(Clientes clientes) throws WebApplicationException {
		if (clientes.getNome() == null || clientes.getNome().isEmpty()) {
			throw new WebApplicationException(Status.NOT_ACCEPTABLE);
		}
	}

}
