package com.insa.Produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8888")
@RequestMapping(value = "/produits")
public class ProduitController {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProduitRepository produitRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit body) {
        return produitRepository.save(body);
    }

    @RequestMapping(value = "/create_list", method = RequestMethod.POST)
    public List<Produit> createMultipleProduits(@RequestBody List<Produit> body){ return produitRepository.saveAll(body);}

    @PatchMapping("/patch/{id}")
    public ResponseEntity<Produit> updateProduct(@PathVariable String id, @RequestBody Produit product) {
        Optional<Produit> productOptional = produitRepository.findById(id);
        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Produit existingProduct = productOptional.get();
        if (product.getNom() != null) {
            existingProduct.setNom(product.getNom());
        }
        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }
        if (product.getPrix() != 0) {
            existingProduct.setPrix(product.getPrix());
        }

        Produit updatedProduct = produitRepository.save(existingProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") String produitId,
                                                 @RequestBody Produit produitDetails) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow();

        produit.setNom(produitDetails.getNom());
        produit.setDescription(produitDetails.getDescription());
        produit.setPrix(produitDetails.getPrix());
        Produit updatedProduit = produitRepository.save(produit);
        return ResponseEntity.ok(updatedProduit);
    }


    @RequestMapping(value = "/find_all_products", method = RequestMethod.GET)
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduit(@PathVariable String id) {
        try {
            produitRepository.deleteById(id);
            return new ResponseEntity<>("Produit supprimé avec succès", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression du produit: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
