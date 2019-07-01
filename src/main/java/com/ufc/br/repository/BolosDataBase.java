package com.ufc.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.br.model.Bolo;


@Repository
public interface BolosDataBase extends JpaRepository<Bolo, Long> {
}
