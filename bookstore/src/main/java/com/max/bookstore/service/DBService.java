package com.max.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.bookstore.domain.Categoria;
import com.max.bookstore.domain.Livro;
import com.max.bookstore.repositories.CategoriaRepository;
import com.max.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		Categoria cat1 = new Categoria(null, "informatica", "livros de ti");
		Categoria cat2 = new Categoria(null, "ficção cientifica", "ficção cientifica");
		Categoria cat3 = new Categoria(null, "biografias", "livros de biografias");

		Livro l1 = new Livro(null, "clear code", "robert Martin", "lores ipsum", cat1);
		Livro l2 = new Livro(null, "clear code", "robert Martin", "lores ipsum", cat1);
		Livro l3 = new Livro(null, "clear code", "robert Martin", "lores ipsum", cat2);
		Livro l4 = new Livro(null, "clear code", "robert Martin", "lores ipsum", cat2);
		Livro l5 = new Livro(null, "clear code", "robert Martin", "lores ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

	}

}
