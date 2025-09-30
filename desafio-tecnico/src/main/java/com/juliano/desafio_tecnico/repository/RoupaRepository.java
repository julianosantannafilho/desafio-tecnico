package com.juliano.desafio_tecnico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliano.desafio_tecnico.model.Roupa;

@Repository
public interface RoupaRepository extends JpaRepository<Roupa, Long> {

}
