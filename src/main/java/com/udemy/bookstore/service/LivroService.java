package com.udemy.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.domain.Livro;
import com.udemy.bookstore.repository.LivroRepository;
import com.udemy.bookstore.service.exception.ObjectNotFndException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepositorio;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro metodoFindService (Integer id ) {
		Optional<Livro> objLivro= livroRepositorio.findById(id);
		
		return objLivro.orElseThrow(() -> new ObjectNotFndException("Objeto nçao encontrado. id: " + id + ",Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> metodoFindAllService () {
		 List<Livro> objLivro = livroRepositorio.findAll();
		return objLivro;
	}

	public List<Livro> livrosPorCat(Integer id_cat) {
		// Ver se a Categoria existe
		categoriaService.findCategoriaService(id_cat);
		return livroRepositorio.findLivrosByCategoria(id_cat);
	}

	public Livro create(Integer id_cat, Livro livroObj) {
		livroObj.setId(null);
		Categoria cat = categoriaService.findCategoriaService(id_cat);
		livroObj.setCategoria(cat);
		return livroRepositorio.save(livroObj);

	}

	public Livro update(Integer id, Livro livroObj) {
		Livro livroObjNew = metodoFindService(id);
		atualizaLivro(livroObjNew, livroObj);
		return livroRepositorio.save(livroObjNew);
		
	}

	private void atualizaLivro(Livro livroObjNew, Livro livroObj) {
		livroObjNew.setTexto(livroObj.getTexto());
		livroObjNew.setTitulo(livroObj.getTitulo());
	}

	
	

	
}
