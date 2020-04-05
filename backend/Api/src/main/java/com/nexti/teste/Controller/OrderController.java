package com.nexti.teste.Controller;

import java.util.List;
import java.util.Optional;

import com.nexti.teste.Model.Order;
import com.nexti.teste.Repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@RequestBody Order request) {
        Order product = new Order(request.getIdCustomer(), request.getTotal());
        return orderRepository.save(product);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> get() {
        return orderRepository.findAll();
    }

    @RequestMapping("/order/")
    public List<Order> findAllSorted() {
        return orderRepository.findAllByOrderByCreatedAtDescIdOrderDesc();
    }

    @RequestMapping("/{id}")
    public Optional<Order> getById(@PathVariable("id") int idOrder) {
        return orderRepository.findById(idOrder);
    }

    @RequestMapping("/cliente/{idCustomer}")
    public List<Order> getByIdClient(@PathVariable("idCustomer") int idCustomer) {
        return orderRepository.findByIdCustomer(idCustomer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int idOrder) {
        orderRepository.deleteById(idOrder);
        return "Pedido removido com sucesso " + idOrder;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order edit(@PathVariable("id") int idOrder, @RequestBody Order request) throws Exception {
        Order orderEdited = orderRepository.findById(idOrder).orElseThrow(() -> new Exception("Pedido não encontrado"));
        orderEdited.setIdCustomer(request.getIdCustomer());
        orderEdited.setTotal(request.getTotal());
        orderEdited.setUpdatedAt(request.getUpdatedAt());

        orderRepository.save(orderEdited);

        return orderEdited;
    }
}