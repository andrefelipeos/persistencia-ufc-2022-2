package trabalho02.modelos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identificador;
	private String nome;
	private LocalDate dataDeNascimento;

	@ManyToMany(mappedBy = "atores")
	Set<Filme> filmes = new HashSet<Filme>();

	public Ator() { }

	public Ator(String nome, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String toString() {
		return nome + ", nascido em " + dataDeNascimento.toString();
	}

	public void adicionarParticipacaoNo(Filme filme) {
		filmes.add(filme);
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

}
