package com.nexti.teste.Controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.nexti.teste.Model.Order;

import com.nexti.teste.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@RequestBody Order request) {
        Order product = new Order(
                request.getIdClient(),
                request.getIdProductsOrder(),
                request.getAmt_purchase(),
                request.getDt_purchase()
        );
        return orderRepository.save(product);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> get() {
        return orderRepository.findAll();
    }

    @RequestMapping("/order/")
    public List<Order> findAllSorted() {
        return orderRepository.findAllByOrderByDtInicialDescIdOrderDesc();
    }

    @RequestMapping("/{id}")
    public Optional<Order> getById(@PathVariable("id") int idOrder){
        return orderRepository.findById(idOrder);
    }

    @RequestMapping("/cliente/{idClient}")
    public List<Order> getByIdClient(@PathVariable("idClient") int idClient){
        return orderRepository.findByIdClient(idClient);
    }

    @RequestMapping("/produto")
    public List<Order> getByType(@PathVariable("type") String type){
        return orderRepository.findByType(type);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int idAnuncio) {
        orderRepository.deleteById(idAnuncio);
        return "Pedido removido com sucesso " + idAnuncio;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order edit(@PathVariable("id") int idAnuncio, @RequestBody Order request) throws Exception {
        Order productEdited = orderRepository.findById(idAnuncio).orElseThrow(() -> new Exception("Pedido não encontrado"));
        productEdited.setIdClient(request.getIdClient());
        productEdited.setIdProductsOrder(request.getIdProductsOrder());
        productEdited.setAmt_purchase(request.getAmt_purchase());
        productEdited.setDt_purchase(request.getDt_purchase());

        orderRepository.save(productEdited);

        return productEdited;
    }
}