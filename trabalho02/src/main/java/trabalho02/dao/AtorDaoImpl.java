package trabalho02.dao;

import java.time.MonthDay;
import java.time.Year;
import java.util.List;

import jakarta.persistence.EntityManager;
import trabalho02.modelos.Ator;
import trabalho02.util.JPAUtil;

public class AtorDaoImpl implements AtorDao {

	private EntityManager entityManager = null;

	public AtorDaoImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		entityManager.getTransaction().begin();
		entityManager.remove(findByIdentifier(identifier));
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Ator> findAll() {
		return entityManager.createQuery("SELECT ator FROM Ator ator", Ator.class).getResultList();
	}

	@Override
	public Ator findByIdentifier(int identifier) {
		return entityManager.find(Ator.class, identifier);
	}

	@Override
	public List<String> findNamesOfAllActorsBornIn(Year year) {
		String jpqlQuery = "SELECT ator.nome FROM Ator ator WHERE ator.dataDeNascimento >= '" + year.atMonthDay(MonthDay.of(1, 1))
			+ "' AND ator.dataDeNascimento <= '" + year.atMonthDay(MonthDay.of(12, 31)) + "'";
		return entityManager.createQuery(jpqlQuery, String.class).getResultList();
	}

	@Override
	public List<String> findTitlesOfAllMoviesWith(Ator ator) {
		String jpqlQuery = "SELECT filme.titulo FROM Ator ator JOIN ator.filmes filme WHERE ator.identificador = " + ator.getIdentificador();
		return entityManager.createQuery(jpqlQuery, String.class).getResultList();
	}

	@Override
	public Ator save(Ator ator) {
		entityManager.getTransaction().begin();
		ator = entityManager.merge(ator);
		entityManager.getTransaction().commit();
		return ator;
	}

}
