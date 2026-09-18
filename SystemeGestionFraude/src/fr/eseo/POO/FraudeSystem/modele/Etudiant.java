package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.util.Enumcursus;

import java.time.LocalDate;

/**
 * Classe représentant un étudiant dans le système de fraude.
 * Chaque étudiant possède :
 *  - un identifiant unique généré automatiquement
 *  - un nom
 *  - un prénom
 *  - un cursus (Enum : B1, B2, B3, E1, E2, E3e, etc.)
 */
public class Etudiant {

    // Identifiant unique de l'étudiant
    private int id;

    // Nom de famille
    private String nom;

    // Prénom
    private String prenom;

    // Cursus de l'étudiant (Enum)
    private Enumcursus cursus;

    /**
     * Compteur statique utilisé pour générer automatiquement les IDs.
     * Il est initialisé à l'année actuelle + 1000.
     * Exemple : en 2026 → compteur = 3026.
     *
     * Chaque nouvel étudiant aura un ID unique :
     * 3026, 3027, 3028, ...
     */
    private static int compteur = LocalDate.now().getYear() + 1000;

    /**
     * Constructeur de la classe Etudiant.
     * Lorsqu'on crée un étudiant :
     *  - un ID unique lui est attribué automatiquement
     *  - son nom, prénom et cursus sont enregistrés
     */
    public Etudiant(String nom, String prenom, Enumcursus cursus) {
        this.id = compteur++;   // Génération automatique de l'ID
        this.nom = nom;
        this.prenom = prenom;
        this.cursus = cursus;
    }

    // ---------------------- GETTERS ----------------------

    public int getId() {
        return id;
    }

    public Enumcursus getCursus() {
        return cursus;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    // ---------------------- SETTERS ----------------------

    public void setCursus(Enumcursus cursus) {
        this.cursus = cursus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
