package com.max.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.bookstore.domain.Livro;
import com.max.bookstore.repositories.LivroRepository;
import com.max.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! Id: "+id+" , Tipo: "+Livro.class.getName()));
				
	}
}
