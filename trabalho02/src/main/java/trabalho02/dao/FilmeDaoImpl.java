package trabalho02.dao;

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
	public Filme save(Filme filme) {
		entityManager.getTransaction().begin();
		filme = entityManager.merge(filme);
		entityManager.getTransaction().commit();
		return filme;
	}

}
