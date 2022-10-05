package atividade06.modelos;

public class Aluno {

	private int id;
	private String cpf;
	private int matricula;
	private String nome;
	private String email;
	private String telefone;

	public Aluno(int id, String cpf, int matricula,
			String nome, String email, String telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id + " : ");
		sb.append(this.matricula + " : ");
		sb.append(this.nome + " : ");
		sb.append(this.cpf + " : ");
		sb.append(this.email + " : ");
		sb.append(this.telefone + "\n");
		return sb.toString();
	}

}
