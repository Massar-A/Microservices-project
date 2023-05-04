package com.insa.Paiement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends MongoRepository<Paiement, Integer>{

    Paiement findByidCommande(String idCommande);
}
