package com.nexti.teste.Repository;

import com.nexti.teste.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByOrderByDtInicialDescIdOrderDesc(String neighborhood);
    void deleteById(Integer idEscola);
}

findByIdClient

        findAllByOrderByDtInicialDescIdOrderDesc