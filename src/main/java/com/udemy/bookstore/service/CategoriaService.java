package com.udemy.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.dto.CategoriaDTO;
import com.udemy.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	public Categoria metodoFindService (Integer Id ) {
		Optional<Categoria> objeto = categoriaRepositorio.findById(Id);
		
		return objeto.orElse(null);
	}
	public List<Categoria> findTudo() {
//		List<Categoria> catAll = categoriaRepositorio.findAll();
//		return catAll;
//      ou return o comando abaixo
		return categoriaRepositorio.findAll();
	}
	
	public Categoria update (Integer id, CategoriaDTO objDto) {
		Categoria obj = metodoFindService(id);
		obj.setNome(objDto.getNome());
		return categoriaRepositorio.save(obj);
		
	}
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepositorio.save(obj);
	}
	
	
}
