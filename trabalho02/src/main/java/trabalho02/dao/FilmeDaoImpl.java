package trabalho02.dao;

import java.time.Year;
import java.util.List;

import jakarta.persistence.EntityManager;
import trabalho02.modelos.Filme;
import trabalho02.util.JPAUtil;

public class FilmeDaoImpl implements FilmeDao {

	private EntityManager entityManager = null;

	public FilmeDaoImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		entityManager.getTransaction().begin();
		entityManager.remove(findByIdentifier(identifier));
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Filme> findAll() {
		return entityManager.createQuery("SELECT filme FROM Filme filme", Filme.class).getResultList();
	}

	@Override
	public Filme findByIdentifier(int identifier) {
		return entityManager.find(Filme.class, identifier);
	}

	@Override
	public List<String> findNamesOfAllActorsIn(Filme filme) {
		String jpqlQuery = "SELECT ator.nome FROM Filme filme JOIN filme.atores ator WHERE filme.identificador = " + filme.getIdentificador();
		return entityManager.createQuery(jpqlQuery, String.class).getResultList();
	}

	@Override
	public List<String> findTitlesOfAllMoviesContaining(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findTitlesOfAllMoviesReleasedIn(Year year) {
		String jpqlQuery = "SELECT filme.titulo FROM Filme filme WHERE filme.anoDeLancamento = " + year.toString();
		return entityManager.createQuery(jpqlQuery, String.class).getResultList();
	}

	@Override
	public long findTotalNumberOfRegisteredMovies() {
		return entityManager.createQuery("SELECT COUNT(filme) FROM Filme filme", Long.class).getSingleResult();
	}

	@Override
	public Filme save(Filme filme) {
		entityManager.getTransaction().begin();
		filme = entityManager.merge(filme);
		entityManager.getTransaction().commit();
		return filme;
	}

}
