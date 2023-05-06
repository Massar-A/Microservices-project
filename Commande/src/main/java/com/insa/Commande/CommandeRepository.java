package com.insa.Commande;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends MongoRepository<Commande, String> {
    Commande findCommandeByTransaction(String transaction);
}
