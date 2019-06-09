package br.com.rogerio.desafioViaNuvem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rogerio.desafioViaNuvem.entity.Planeta;

public class PlanetaRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public PlanetaRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("desafio_planeta");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/*
	 * Cria um resgistro dentro do Banco
	 */
	public void Salvar(Planeta planeta_entity) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(planeta_entity);
		this.entityManager.getTransaction().commit();
	}

	/*
	 * busca todos os registros no banco
	 */
	@SuppressWarnings("unchecked")
	public List<Planeta> TodosOsPlanetas() {

		List<Planeta> planetas = this.entityManager.createQuery("From Planeta order by cod_planeta asc")
				.getResultList();

		return planetas;
	}

	/*
	 * busca os registros no banco por ID
	 */
	public Planeta PlanetasPorId(int cod_planeta) {

		Planeta planeta = new Planeta();
		try {
			planeta = this.entityManager.createQuery("From Planeta where cod_planeta =:cod_planeta", Planeta.class)
					.setParameter("cod_planeta", cod_planeta).getSingleResult();
			return planeta;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * busca os registros no banco por Nome
	 */
	public Planeta PlanetasPorNome(String nome) throws Exception {
		
		Planeta planeta = new Planeta();
		try {
			planeta = this.entityManager.createQuery("From Planeta where nome =:nome", Planeta.class)
					.setParameter("nome", nome).getSingleResult();
			return planeta;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/*
	 * Excluindo um registro
	 */
	public void ExcluirPlaneta(int cod) {
		
		Planeta planeta = new Planeta();
		try {
			planeta = this.entityManager.createQuery("From Planeta where cod_planeta =:cod_planeta", Planeta.class)
					.setParameter("cod_planeta", cod).getSingleResult();
			
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(planeta);
			this.entityManager.getTransaction().commit();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
