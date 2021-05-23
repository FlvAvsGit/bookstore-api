package com.udemy.bookstore.domain;

public class Livro {
	private int id;
	private String titulo;
	private String nomeAutor;
	private String descricao;
	private String texto;

	private Categoria categoria;

	public Livro() {
	}

	public Livro(int id, String titulo, String nomeAutor, String descricao, String texto, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.descricao = descricao;
		this.texto = texto;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
