package com.insa.Produits;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProduitRepository extends MongoRepository<Produit, String> {
}
