package atividade08.modelos;

public class Aluno {

	private Integer identificador;
	private String cpf;
	private int matricula;
	private String nome;
	private String email;
	private String telefone;

	public Aluno(int matricula, String nome, String cpf, String email, String telefone) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.matricula);
		sb.append(" : ");
		sb.append(this.nome);
		sb.append(" : ");
		sb.append(this.cpf);
		sb.append(" : ");
		sb.append(this.email);
		sb.append(" : ");
		sb.append(this.telefone);
		return sb.toString();
	}

}
