package trabalho02.dao;

import java.util.List;

import trabalho02.modelos.Filme;

public interface FilmeDao {

	void deleteByIdentifier(int identifier);

	List<Filme> findAll();

	Filme findByIdentifier(int identifier);

	Filme save(Filme filme);

}
