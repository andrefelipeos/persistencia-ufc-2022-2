package trabalho02.dao;

import java.time.Year;
import java.util.List;

import trabalho02.modelos.Ator;

public interface AtorDao {

	void deleteByIdentifier(int identifier);

	List<Ator> findAll();

	List<String> findNamesOfAllActorsBornIn(Year year);

	List<String> findTitlesOfAllMoviesWith(Ator ator);

	Ator findByIdentifier(int identifier);

	Ator save(Ator ator);

}
