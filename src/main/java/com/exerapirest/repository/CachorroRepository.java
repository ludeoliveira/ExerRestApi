package com.exerapirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exerapirest.entidades.Cachorro;

@Repository
public interface CachorroRepository extends CrudRepository<Cachorro, Long>{

}
