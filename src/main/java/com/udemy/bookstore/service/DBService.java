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
		Categoria cat3 = new Categoria(null, "auto-ajuda");
		Categoria cat4 = new Categoria(null, "Biografia");
		Categoria cat5 = new Categoria(null, "Física");
		Categoria cat6 = new Categoria(null, "Romance");
		Categoria cat7 = new Categoria(null, "Espiritismo e Religiao");
		

		Livro b1 = new Livro(null, "Código Limpo", "Description from Clean Code", cat1);
		Livro b2 = new Livro(null, "Code Complete", "Description from Code Complete", cat1);
		Livro b3 = new Livro(null, "Padrão de Códigos", "Description from Desingn Patterns", cat1);
		Livro b4 = new Livro(null, "Como fazer amigos e influenciar Pessoas",
				"Description from How to make friends and influence people", cat2);
		Livro b5 = new Livro(null, "Dos Faraos à física Quantica", "Description from Dos Faraos a Fisica quantica", cat5);
		Livro b6 = new Livro(null, "Churchill Caminhando com o Destino", "Description from TChurchill", cat4);
		Livro b7 = new Livro(null, "A sutil arte de ligar o foda-se", "Mark Manson usa toda a sua sagacidade de escritor e seu olhar crítico para propor um novo caminho rumo a uma vida melhor, mais coerente com a realidade e consciente dos nossos limites. E ele faz isso da melhor maneira. Como um verdadeiro amigo, Mark se senta ao seu lado e diz, olhando nos seus olhos: você não é tão especial. Ele conta umas piadas aqui, dá uns exemplos inusitados ali, joga umas verdades na sua cara e pronto, você já se sente muito mais alerta e capaz de enfrentar esse mundo cão.", cat3);
		Livro b8 = new Livro(null, "Mais esperto que o diabo", "Escrito em 1938, após uma das maiores crises econômicas, e precedendo a Segunda Guerra Mundial, este livro não somente é uma fonte de inspiração e coragem, mas deve ser considerado um manual para todas aquelas pessoas que desejam ser mais espertas que seus medos, problemas e limitações, pois, como o próprio Hill fala - em toda adversidade existe uma semente de benefício equivalente.", cat3);
		Livro b9 = new Livro(null, "Steve Jobs", "Paixões e Demônios de uma Figura da Era Digital", cat4);
		Livro b10 = new Livro(null, "Violetas na Janela", "é um dos livros espíritas mais vendidos entre os jovens", cat7);
		
		cat1.getLivro().addAll(Arrays.asList(b1, b2, b3));
		cat2.getLivro().addAll(Arrays.asList(b4));
		cat3.getLivro().addAll(Arrays.asList(b7, b8));
		cat4.getLivro().addAll(Arrays.asList(b6, b9));
		cat5.getLivro().addAll(Arrays.asList(b5));
//		cat6.getLivro().addAll(Arrays.asList(b4, b5));
		cat7.getLivro().addAll(Arrays.asList(b10));
		
		System.out.println(cat1.toString());
//		b1.getCategoria().addAll(Arrays.asList(cat1));
//		b1.setCategoria(cat1);
//		b2.setCategoria(cat1);
//		b3.setCategoria(cat1);/
//		b4.setCategoria(cat2);
//		b5.setCategoria(cat2);
//		b2.getCategoria().addAll(Arrays.asList(cat1));
//		b3.getCategoria().addAll(Arrays.asList(cat1));
//		b4.getCategoria().addAll(Arrays.asList(cat2));
//		b5.getCategoria().addAll(Arrays.asList(cat2));
//		categoriaRepository.saveAll(Arrays.asList(cat1));
//		livroRepository.saveAll(Arrays.asList(b1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2 , cat3, cat4, cat5, cat6, cat7));
		livroRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6 ,b7, b8, b9, b10));
	}
}
