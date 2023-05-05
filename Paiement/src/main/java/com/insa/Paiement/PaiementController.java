package com.insa.Paiement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.insa.Paiement.Exception.PaiementExistantException;
import com.insa.Paiement.Exception.PaiementImpossibleException;

@RestController
public class PaiementController {
    private final PaiementDao paiementDao;

    public PaiementController(PaiementDao paiementDao){
        this.paiementDao = paiementDao;
    }

    @PostMapping(value = "/paiement")
    public ResponseEntity<Paiement>  payerUneCommande(@RequestBody Paiement paiement){
        //Vérifions s'il y a déjà un paiement enregistré pour cette commande
        Paiement paiementExistant = paiementDao.findByidCommande(paiement.getIdCommande());
        if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");

        //Enregistrer le paiement
        Paiement nouveauPaiement = paiementDao.save(paiement);


        if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");



        //TODO Nous allons appeler le Microservice Commandes ici pour lui signifier que le paiement est accepté
        return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);

    }
    
}
