package com.nexti.teste.Repository;

import com.nexti.teste.Model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
    void deleteById(Integer idClient);
}
