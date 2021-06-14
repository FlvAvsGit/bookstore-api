package com.udemy.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.bookstore.domain.Livro;
import com.udemy.bookstore.dto.LivroDTO;
import com.udemy.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livserv;

//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find (@PathVariable Integer id) {
//		System.out.println("Entrei no /id");
		Livro objRespEnt = livserv.metodoFindService(id);
		return ResponseEntity.ok().body(objRespEnt);
	}
//	@RequestMapping(value = "/tudo", method = RequestMethod.GET)
	@GetMapping(value="/")
	public ResponseEntity<?> findAll() {
		List<Livro> objRespEnt = livserv.metodoFindAllService();
		return ResponseEntity.ok().body(objRespEnt);
	}

	// localhost:8080/livros?categoria=1  			Todos os livros (Somente Id e Titulo) da Categoria 1
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findLivroDto(@RequestParam(value = "catigoria", defaultValue = "0") Integer id_cat) {
		List<Livro> listLivro = livserv.livrosPorCat(id_cat);
//		List<CategoriaDTO> categoriaDtoList = categoriaList.stream().map(obj -> new CategoriaDTO(obj))
//				.collect(Collectors.toList());
		List<LivroDTO> livroDtoList = listLivro.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDtoList);
	}
		
}

