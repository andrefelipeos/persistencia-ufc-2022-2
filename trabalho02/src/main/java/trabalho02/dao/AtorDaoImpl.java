package trabalho02.dao;

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
	public Ator save(Ator ator) {
		entityManager.getTransaction().begin();
		ator = entityManager.merge(ator);
		entityManager.getTransaction().commit();
		return ator;
	}

}
