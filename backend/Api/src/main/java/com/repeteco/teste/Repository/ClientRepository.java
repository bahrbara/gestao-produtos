package com.repeteco.teste.Repository;

import com.repeteco.teste.Model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
    Client findByEmail(String email);
    void deleteById(Integer idCliente);
}
