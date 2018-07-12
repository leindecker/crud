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

import br.com.rest.model.Automoveis;
import br.com.rest.db.dao.AutomoveisDAO;


@Path("/automoveis")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@RequestScoped
public class AutomoveisServiceImpl implements AutomoveisService {
	
	
	@Inject
	private AutomoveisDAO dao;
	
	public AutomoveisDAO getDao() {
		return dao;
	}
	
	public void setDao(AutomoveisDAO dao) {
		this.dao = dao;
	}
	
	
	@POST
	@Path("/alterarAutomovel")
	public Response save(Automoveis automoveis) {
		try {
			validaAutomovel(automoveis);
			automoveis = dao.save(automoveis);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return Response.ok().entity(automoveis).build();
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id")Integer id) {
		Automoveis automoveis = null;
		try {
			automoveis = dao.findById(id);
			dao.delete(automoveis);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarAutomovel")
	public Automoveis update(Automoveis automoveis) {
		Automoveis entity = new Automoveis();
		try {
			entity.setId(automoveis.getId());
			entity.setModelo(automoveis.getModelo());
			entity.setCor(automoveis.getCor());
			entity.setPlaca(automoveis.getPlaca());
			automoveis = dao.update(automoveis);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return automoveis;
	}

	@GET
	@Path("{id}")
	public Automoveis findById(@PathParam("id") Integer id) {
		Automoveis automoveis = null;
		try {
			automoveis = dao.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return automoveis;
	}

	
	@GET
	public List<Automoveis> findAll() {
		List<Automoveis> automoveis = null;
		try {
			automoveis = dao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return automoveis;
	}

	@GET
	@Path("modelo/{nome}")
	public List<Automoveis> findByName(@PathParam("nome")String nome) {
		List<Automoveis> automoveis = null;
		try {
			automoveis = dao.findByName(nome);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return automoveis;
	}
	
	private void validaAutomovel(Automoveis automoveis) throws WebApplicationException {
		if (automoveis.getModelo() == null || automoveis.getModelo().isEmpty()) {
			throw new WebApplicationException(Status.NOT_ACCEPTABLE);
		}
	}

}
