package trabalho02.dao;

import java.time.Year;
import java.util.List;

import trabalho02.modelos.Filme;

public interface FilmeDao {

	void deleteByIdentifier(int identifier);

	List<Filme> findAll();

	Filme findByIdentifier(int identifier);

	List<String> findNamesOfAllActorsIn(Filme filme);

	List<String> findTitlesOfAllMoviesReleasedIn(Year year);

	List<String> findTitlesOfAllMoviesContaining(String substring);

	long findTotalNumberOfRegisteredMovies();

	Filme save(Filme filme);

}
