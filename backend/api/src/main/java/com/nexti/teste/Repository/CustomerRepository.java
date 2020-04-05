package com.nexti.teste.Repository;

import com.nexti.teste.Model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    void deleteById(Integer idCustomer);
}
