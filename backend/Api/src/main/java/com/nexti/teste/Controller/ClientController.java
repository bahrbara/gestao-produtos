package com.nexti.teste.Controller;

import com.nexti.teste.Model.Client;
import com.nexti.teste.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Client create(@RequestBody Client request) {

        Client client = new Client(
                request.getName(),
                request.getCpf(),
                request.getBirthDate()
                );

        return clientRepository.save(client);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Client> get() {
        return clientRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int idClient){
        return clientRepository.findById(idClient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int idClient) {
        clientRepository.deleteById(idClient);
        return "Cliente removido com sucesso " + idClient;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Client edit(@PathVariable("id") int idClient, @RequestBody Client request) throws Exception {
        Client clientEdited = clientRepository.findById(idClient).orElseThrow(() -> new Exception("Cliente não encontrado"));
        clientEdited.setName(request.getName());
        clientEdited.setBirthDate(request.getBirthDate());
        clientEdited.setCpf(request.getCpf());

        clientRepository.save(clientEdited);

        return clientEdited;
    }
}