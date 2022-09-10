package atividade04;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "biblioteca")
public class Biblioteca {
	
	private List<Filme> listaDeFilmes;
	
	public Biblioteca() {
		super();
	}
	
	public Biblioteca(List<Filme> listaDeFilmes) {
		this.listaDeFilmes = listaDeFilmes;
	}

	@JacksonXmlElementWrapper(localName = "lista-de-filmes")
	@JacksonXmlProperty(localName = "filme")
	public List<Filme> getListaDeFilmes() {
		return this.listaDeFilmes;
	}
	
	public String toString() {
		return this.listaDeFilmes.toString();
	}

}
