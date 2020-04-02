package com.repeteco.teste.Repository;


import com.repeteco.teste.Model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
    List<Anuncio> findByIdClient(int id);
    List<Anuncio> findByType(String type);
    List<Anuncio> findAllByOrderByDtInicialDescIdAnuncioDesc();
    void deleteById(Integer idAnuncio);
}