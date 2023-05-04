package com.insa.Commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/commandes")
public class CommandeController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CommandeRepository commandeRepository;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Commande createCommande(@RequestBody Commande body){
        return commandeRepository.save(body);
    }
}
