package com.nexti.teste.Controller;

import com.nexti.teste.Model.Product;
import com.nexti.teste.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product request) {
        Product product = new Product(request.getSku(), request.getName(), request.getDescription(),
                request.getPrice());
        return productRepository.save(product);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> get() {
        return productRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Product> getById(@PathVariable("id") int idProduct) {
        return productRepository.findById(idProduct);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int idAnuncio) {
        productRepository.deleteById(idAnuncio);
        return "Produto removido com sucesso " + idAnuncio;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product edit(@PathVariable("id") int idAnuncio, @RequestBody Product request) throws Exception {
        Product productEdited = productRepository.findById(idAnuncio)
                .orElseThrow(() -> new Exception("Anúncio não encontrado"));
        productEdited.setSku(request.getSku());
        productEdited.setName(request.getName());
        productEdited.setDescription(request.getDescription());
        productEdited.setPrice(request.getPrice());

        productRepository.save(productEdited);

        return productEdited;
    }
}