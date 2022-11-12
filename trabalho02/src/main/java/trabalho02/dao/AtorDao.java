package trabalho02.dao;

import java.util.List;

import trabalho02.modelos.Ator;

public interface AtorDao {

	void deleteByIdentifier(int identifier);

	List<Ator> findAll();

	Ator findByIdentifier(int identifier);

	Ator save(Ator ator);

}
