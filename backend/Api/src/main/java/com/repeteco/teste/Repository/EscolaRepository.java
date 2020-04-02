package com.repeteco.teste.Repository;


import java.util.List;

import com.repeteco.teste.Model.Escola;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {
    List<Escola> findByNeighborhood(String neighborhood);
    void deleteById(Integer idEscola);
}