package com.insa.Commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/commande")
public class CommandeController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CommandeRepository commandeRepository;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Commande createCommande(@RequestBody Commande body){
        return commandeRepository.save(body);
    }

    @RequestMapping(value = "/pay/{id}/{idCommande}", method = RequestMethod.PUT)
    public Commande findCommandeByPayment(@PathVariable(value = "id") String id, @PathVariable(value = "idCommande") String idCommande){
        Optional<Commande> commande = commandeRepository.findById(idCommande);
        System.out.println("hello");
        Commande commandeFound = commande.get();
        commandeFound.setTransaction(id);
        commandeFound.setPaid(true);
        return commandeRepository.save(commandeFound);
    }
}
