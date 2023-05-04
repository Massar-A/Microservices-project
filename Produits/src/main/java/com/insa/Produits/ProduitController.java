package com.insa.Produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produits")
public class ProduitController {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProduitRepository produitRepository;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit body) { return produitRepository.save(body); }
}
