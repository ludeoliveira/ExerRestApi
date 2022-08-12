package com.exerapirest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exerapirest.entidades.Cachorro;
import com.exerapirest.repository.CachorroRepository;

@RestController
@RequestMapping("/")
public class CachorroController {

	@Autowired
	CachorroRepository repo;
	
	@GetMapping
	public String xptop() {
		return "Index de Cachorro";
	}
	
	@GetMapping("/cachorros")
	public ResponseEntity<Iterable<Cachorro>> getCachorros() {
		Iterable<Cachorro> cachorros = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cachorros);
	}
	
	@GetMapping("/cachorros/{idcachorro}")
	public ResponseEntity<Cachorro> getCachorroById(@PathVariable("idcachorro") Long idcachorro) {
		Optional<Cachorro> cachorro = repo.findById(idcachorro);
		return cachorro.isPresent() ? ResponseEntity.ok(cachorro.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cachorros")
	public ResponseEntity<Cachorro> salvarCachorro(@RequestBody Cachorro cachorro) {
		Cachorro ch = repo.save(cachorro);
		return ResponseEntity.status(HttpStatus.CREATED).body(ch);
	}
	
	@DeleteMapping("/cachorros/{idcachorro}")
	public ResponseEntity<Cachorro> deletarCachorroById(@PathVariable("idcachorro") Long idcachorro) {
		repo.deleteById(idcachorro);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/cachorros/{idcachorro}")
	public ResponseEntity<Cachorro> alterarCachorro(@PathVariable("idcachorro") Long idcachorro, 
		@RequestBody Cachorro cachorro) {
		return ResponseEntity.ok(repo.save(cachorro));
	}
}
