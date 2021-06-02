package com.udemy.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.domain.Livro;
import com.udemy.bookstore.repository.CategoriaRepository;
import com.udemy.bookstore.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDados() {
		Categoria cat1 = new Categoria(null, "Tecnologia");
		Categoria cat2 = new Categoria(null, "Personal development");

		Livro b1 = new Livro(null, "Código Limpo", "Description from Clean Code", cat1);
		Livro b2 = new Livro(null, "Code Complete", "Description from Code Complete", cat1);
		Livro b3 = new Livro(null, "Padrão de Códigos", "Description from Desingn Patterns", cat1);
		Livro b4 = new Livro(null, "Como fazer amigos e influenciar Pessoas",
				"Description from How to make friends and influence people", cat2);
		Livro b5 = new Livro(null, "O Poder do Agora", "Description from The Power of Now", cat2);

		cat1.getLivro().addAll(Arrays.asList(b1));
		cat2.getLivro().addAll(Arrays.asList(b4, b5));
		System.out.println(cat1.toString());
//		b1.getCategoria().addAll(Arrays.asList(cat1));
		b1.setCategoria(cat1);
		b2.setCategoria(cat1);
		b3.setCategoria(cat1);
		b4.setCategoria(cat2);
		b5.setCategoria(cat2);
//		b2.getCategoria().addAll(Arrays.asList(cat1));
//		b3.getCategoria().addAll(Arrays.asList(cat1));
//		b4.getCategoria().addAll(Arrays.asList(cat2));
//		b5.getCategoria().addAll(Arrays.asList(cat2));
//		categoriaRepository.saveAll(Arrays.asList(cat1));
//		livroRepository.saveAll(Arrays.asList(b1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2 ));
		livroRepository.saveAll(Arrays.asList(b1, b2, b3));
	}
}
