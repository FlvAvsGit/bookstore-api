package com.udemy.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.dto.CategoriaDTO;
import com.udemy.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService catserv;
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@GetMapping (value="/{id}")
	public ResponseEntity<?> find (@PathVariable Integer id) {
		Categoria objRespEnt = catserv.metodoFindService(id);
		return ResponseEntity.ok().body(objRespEnt);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findTudo() {
		List<Categoria> categoriaList = catserv.findTudo();
		// O comando abaixo, converte a lista de objetos categoriaList em categoriaDtoList
		List<CategoriaDTO> categoriaDtoList = categoriaList.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDtoList);
		
	}
}

// localhost:8080/categorias
