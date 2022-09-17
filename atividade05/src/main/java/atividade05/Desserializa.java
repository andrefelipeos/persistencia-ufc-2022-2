package atividade05;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import atividade05.model.Livro;

public class Desserializa {

	public static void main(String[] args) throws Exception {
		String localDoArquivo = "livros.json";
		
		ObjectMapper mapper = new ObjectMapper();
		Livro livro = mapper.readValue(new File(localDoArquivo), Livro.class);
		System.out.println(livro.toString());
	}

}
