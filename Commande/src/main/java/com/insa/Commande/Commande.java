package com.insa.Commande;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Document
public class Commande {
    @Id
    private String _id;

    private String user, transaction;

    private List<String> products;

    private Date dateCommande;

    public Commande(String user, String transaction, List<String> products) {
        this.user = user;
        this.transaction = transaction;
        this.products = products;
        this.dateCommande = new Date();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Timestamp dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "_id='" + _id + '\'' +
                ", user='" + user + '\'' +
                ", transaction='" + transaction + '\'' +
                ", products=" + products +
                ", dateCommande=" + dateCommande +
                '}';
    }
}
