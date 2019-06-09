package br.com.rogerio.desafioViaNuvem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.rogerio.desafioViaNuvem.entity.Planeta;
import br.com.rogerio.desafioViaNuvem.http.PlanetaHttp;
import br.com.rogerio.desafioViaNuvem.repository.PlanetaRepository;

@Path("/service")
public class PlanetaController {
	
	private final PlanetaRepository repository = new PlanetaRepository();
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(PlanetaHttp planeta) {
		
		Planeta planeta_entity = new Planeta();
		
		try {
			planeta_entity.setNome(planeta.getNome());
			planeta_entity.setClima(planeta.getClima());
			planeta_entity.setTerreno(planeta.getTerreno());
			planeta_entity.setQt_filmes(planeta.getQt_filmes());
			
			repository.Salvar(planeta_entity);
			
			return "Registro cadastrado com sucesso";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao cadastrar registro "+e.getMessage();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todos")
	public List<PlanetaHttp> TodosOsPlanetas(){
		
		List<PlanetaHttp> planetaHttp = new ArrayList<PlanetaHttp>();
		
		List<Planeta> listaDePlanetas = repository.TodosOsPlanetas();
		
		for(Planeta planeta:listaDePlanetas) {
			planetaHttp.add(new PlanetaHttp(planeta.getCod_planeta(),planeta.getNome(), planeta.getClima(), planeta.getTerreno(), planeta.getQt_filmes()));
		}
		
		return planetaHttp;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getplanetaCodigo/{codigo}")
	public PlanetaHttp odosOsPlanetas(@PathParam("codigo") int cod){
		
		try {
		Planeta planeta = repository.PlanetasPorId(cod);
		
			return new PlanetaHttp(planeta.getCod_planeta(), planeta.getNome(), planeta.getClima(), planeta.getTerreno(), planeta.getQt_filmes());
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getplanetapornome/{nome}")
	public PlanetaHttp planetasPorNome(@PathParam("nome") String nome){
		
		try {
		Planeta planeta = repository.PlanetasPorNome(nome);
		
			return new PlanetaHttp(planeta.getCod_planeta(), planeta.getNome(), planeta.getClima(), planeta.getTerreno(), planeta.getQt_filmes());
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")
	public String excluir(@PathParam("codigo") Integer codigo) {
		try {
			
			repository.ExcluirPlaneta(codigo);
			
			return "Resgistro excluido com sucesso!";
			
		}catch (Exception e) {
			return "Erro ao excluir o resgistro "+e.getMessage();
		}
	}
	

}
