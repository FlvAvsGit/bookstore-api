package com.udemy.bookstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.bookstore.domain.Livro;
import com.udemy.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livserv;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find (@PathVariable Integer id) {
//		System.out.println("Entrei no /id");
		Livro objRespEnt = livserv.metodoFindService(id);
		return ResponseEntity.ok().body(objRespEnt);
	}
	@RequestMapping(value = "/tudo", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Livro> objRespEnt = livserv.metodoFindAllService();
		return ResponseEntity.ok().body(objRespEnt);
	}

}

// localhost:8080/categorias
