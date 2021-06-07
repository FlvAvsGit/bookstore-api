package com.udemy.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.dto.CategoriaDTO;
import com.udemy.bookstore.repository.CategoriaRepository;
import com.udemy.bookstore.service.exception.ObjectNotFndException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositorio;

	public Categoria metodoFindService(Integer id) {
		Optional<Categoria> objeto = categoriaRepositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFndException("Objeto não encontrado. Id : " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findTudo() {
//		List<Categoria> catAll = categoriaRepositorio.findAll();
//		return catAll;
//      ou return o comando abaixo
		return categoriaRepositorio.findAll();
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = metodoFindService(id);
		obj.setNome(objDto.getNome());
		return categoriaRepositorio.save(obj);

	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepositorio.save(obj);
	}

	public void delete(Integer id) {
		try {
			categoriaRepositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.udemy.bookstore.service.exception.DataIntegrityViolationException(
					"Erro. Objeto Categoria possui Livros associados.");
		}

	}

}
