package trabalho02.modelos;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idenficador;
	private String titulo;
	private Year anoDeLancamento;

	@ManyToMany
	Set<Ator> atores = new HashSet<Ator>();

	public Filme() { }

	public Filme(String titulo, int anoDeLancamento) {
		this.titulo = titulo;
		this.anoDeLancamento = Year.of(anoDeLancamento);
	}

	public void setTitulo(String novoTitulo) {
		this.titulo = novoTitulo;
	}

	public void setAnoDeLancamento(int novoAnoDeLacamento) {
		this.anoDeLancamento = Year.of(novoAnoDeLacamento);
	}

	@Override
	public String toString() {
		return titulo + " (" + anoDeLancamento.toString() + ")";
	}

	public void adicionarParticipacaoDo(Ator ator) {
		atores.add(ator);
		ator.adicionarParticipacaoNo(this);
	}

}
