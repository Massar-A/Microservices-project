package com.insa.Paiement;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.insa.Paiement.Exception.PaiementExistantException;
import com.insa.Paiement.Exception.PaiementImpossibleException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping(value = "/paiement")
@CrossOrigin(origins = "*")
public class PaiementController {
    private final PaiementDao paiementDao;

    public PaiementController(PaiementDao paiementDao){
        this.paiementDao = paiementDao;
    }

    @RequestMapping(value = "/payer", method = RequestMethod.POST)
    public ResponseEntity<Paiement>  payerUneCommande(@RequestBody Paiement paiement) throws IOException, InterruptedException {
        //Vérifions s'il y a déjà un paiement enregistré pour cette commande
        Paiement paiementExistant = paiementDao.findByidCommande(paiement.getIdCommande());
        if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");

        //Enregistrer le paiement
        Paiement nouveauPaiement = paiementDao.save(paiement);


        if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");

        return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);

    }
    
}
