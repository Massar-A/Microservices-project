package com.insa.Client;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
    @Id
    private String _id;

    private String mail;

    private String password;

    private String nom;

    private String prenom;

    public Client(String mail, String password, String nom, String prenom) {
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "_id='" + _id + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", nom=" + nom +
                ", prenom=" + prenom +
                '}';
    }
}