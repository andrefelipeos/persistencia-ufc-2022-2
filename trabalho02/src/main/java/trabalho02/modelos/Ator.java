package trabalho02.modelos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identificador;
	private String nome;
	private LocalDate dataDeNascimento;

	public Ator() { }

	public Ator(String nome, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String toString() {
		return nome + ", nascido em " + dataDeNascimento.toString();
	}

}
