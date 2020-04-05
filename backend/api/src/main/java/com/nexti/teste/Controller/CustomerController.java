package com.nexti.teste.Controller;

import com.nexti.teste.Model.Customer;
import com.nexti.teste.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Customer create(@RequestBody Customer request) {

        Customer customer = new Customer(request.getName(), request.getDocumentNumber(), request.getBirthDate());

        return customerRepository.save(customer);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> get() {
        return customerRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Customer> getById(@PathVariable("id") int idCustomer) {
        return customerRepository.findById(idCustomer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int idCustomer) {
        customerRepository.deleteById(idCustomer);
        return "Cliente removido com sucesso " + idCustomer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Customer edit(@PathVariable("id") int idCustomer, @RequestBody Customer request) throws Exception {
        Customer customerEdited = customerRepository.findById(idCustomer)
                .orElseThrow(() -> new Exception("Cliente não encontrado"));
        customerEdited.setName(request.getName());
        customerEdited.setBirthDate(request.getBirthDate());
        customerEdited.setDocumentNumber(request.getDocumentNumber());

        customerRepository.save(customerEdited);

        return customerEdited;
    }
}