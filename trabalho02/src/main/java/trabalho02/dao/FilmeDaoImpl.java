package trabalho02.dao;

import java.time.Year;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
		String jpqlQuery = "SELECT ator.nome FROM Filme filme JOIN filme.atores ator WHERE filme.identificador = :identificador";
		return entityManager.createQuery(jpqlQuery, String.class).setParameter("identificador", filme.getIdentificador()).getResultList();
	}

	@Override
	public List<String> findTitlesOfAllMoviesContaining(String substring) {
		String jpqlQuery = "SELECT filme.titulo FROM Filme filme WHERE filme.titulo LIKE :string";
		return entityManager.createQuery(jpqlQuery, String.class).setParameter("string", "%" + substring + "%").getResultList();
	}

	@Override
	public List<String> findTitlesOfAllMoviesReleasedIn(Year ano) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Filme> root = criteriaQuery.from(Filme.class);
		criteriaQuery.select(root.get("titulo"));
		criteriaQuery.where(criteriaBuilder.equal(root.get("anoDeLancamento"), ano));

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public long findTotalNumberOfRegisteredMovies() {
		return (long) entityManager.createNativeQuery("SELECT COUNT(*) FROM filmes", Long.class).getSingleResult();
	}

	@Override
	public Filme save(Filme filme) {
		entityManager.getTransaction().begin();
		filme = entityManager.merge(filme);
		entityManager.getTransaction().commit();
		return filme;
	}

}
