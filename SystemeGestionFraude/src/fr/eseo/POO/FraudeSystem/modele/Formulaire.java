package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.modele.fraudeType.Fraude;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe représentant un formulaire de fraude.
 * Un formulaire regroupe :
 *  - un ou plusieurs étudiants
 *  - une ou plusieurs fraudes
 *  - une épreuve associée
 *  - une date de création
 *  - un identifiant unique
 *
 * Le formulaire est donc l’unité centrale du système :
 * il relie les étudiants, les fraudes et l’épreuve.
 */
public class Formulaire {

    // Identifiant unique du formulaire
    private final int id;

    /**
     * Compteur statique permettant de générer automatiquement
     * un ID unique pour chaque formulaire créé.
     *
     * Exemple : 0, 1, 2, 3, ...
     */
    private static int compteur = 0;

    // Date de création du formulaire
    private LocalDate dateCreation;

    // Liste des étudiants concernés par ce formulaire
    private ArrayList<Etudiant> etudiants;

    // Liste des fraudes détectées dans ce formulaire
    private ArrayList<Fraude> fraudes;

    // Épreuve à laquelle ce formulaire est associé
    private Epreuve epreuve;

    /**
     * Constructeur du formulaire.
     * Lorsqu’on crée un formulaire :
     *  - la date de création est automatiquement mise à aujourd’hui
     *  - les étudiants, fraudes et l’épreuve sont fournis
     *  - un ID unique est attribué automatiquement
     */
    public Formulaire(ArrayList<Etudiant> etudiants, ArrayList<Fraude> fraudes, Epreuve epreuve) {
        this.dateCreation = LocalDate.now();   // Date du jour
        this.etudiants = etudiants;            // Liste des étudiants
        this.fraudes = fraudes;                // Liste des fraudes
        this.epreuve = epreuve;                // Épreuve associée
        this.id = compteur++;                  // Génération automatique de l'ID
    }

    // ---------------------- GETTERS & SETTERS ----------------------

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public ArrayList<Fraude> getFraudes() {
        return fraudes;
    }

    public void setFraudes(ArrayList<Fraude> fraudes) {
        this.fraudes = fraudes;
    }

    public int getId() {
        return id;
    }
}
