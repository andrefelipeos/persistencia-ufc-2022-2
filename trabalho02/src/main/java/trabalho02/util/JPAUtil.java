package trabalho02.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("postgresql");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
