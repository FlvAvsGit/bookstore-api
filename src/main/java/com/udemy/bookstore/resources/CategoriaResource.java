package com.udemy.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.dto.CategoriaDTO;
import com.udemy.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService catServ;

//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria objRespEnt = catServ.findCategoriaService(id);
		return ResponseEntity.ok().body(objRespEnt);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findTudo() {
		List<Categoria> categoriaList = catServ.findTudo();
		// O comando abaixo, converte a lista de objetos categoriaList em
		// categoriaDtoList
		List<CategoriaDTO> categoriaDtoList = categoriaList.stream().map(obj -> new CategoriaDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDtoList);
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
		obj = catServ.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto) {
		Categoria newObj = catServ.update(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
// testar o update com o PUT no Postamn !!!!!!!!!!		
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		catServ.delete(id);
	}
}
// localhost:8080/categorias
