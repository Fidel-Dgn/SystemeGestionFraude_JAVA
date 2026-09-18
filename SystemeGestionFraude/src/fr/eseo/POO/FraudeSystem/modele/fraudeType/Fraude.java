package fr.eseo.POO.FraudeSystem.modele.fraudeType;

import java.time.LocalDate;

/**
 * Classe abstraite représentant une fraude.
 *
 * Cette classe sert de base (classe mère) pour tous les types de fraudes :
 *  - Iag
 *  - IagConnecte
 *  - Papier
 *  - Calculatrice
 *
 * Elle contient les informations communes à toutes les fraudes :
 *  - la date du relevé
 *  - une description
 *  - un contenu frauduleux
 *
 * Comme elle est abstraite, on ne peut PAS créer directement un objet Fraude.
 * On doit obligatoirement créer un objet d’une classe fille.
 */
public abstract class Fraude {

    // Date à laquelle la fraude a été relevée (automatiquement mise à aujourd’hui)
    protected LocalDate datereleve;

    // Description générale de la fraude (ex : "Anti-sèche", "IA utilisée", etc.)
    protected String description;

    // Contenu frauduleux trouvé (ex : texte, programme, adresse IP…)
    protected String contenu;

    /**
     * Constructeur de la classe Fraude.
     * Il initialise :
     *  - la date du relevé à la date actuelle
     *  - la description
     *  - le contenu
     *
     * Ce constructeur est appelé par les classes filles via super().
     */
    public Fraude(String description, String contenu) {
        this.datereleve = LocalDate.now();  // Date du jour
        this.description = description;     // Description fournie
        this.contenu = contenu;             // Contenu frauduleux
    }

    // ---------------------- GETTERS & SETTERS ----------------------

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDate getDatereleve() {
        return datereleve;
    }

    public void setDatereleve(LocalDate datereleve) {
        this.datereleve = datereleve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Méthode d'affichage lisible d'une fraude.
     * Elle affiche :
     *  - le contenu frauduleux
     *  - la date du relevé
     *  - la description
     *
     * Les classes filles héritent de cette méthode.
     */
    @Override
    public String toString() {
        return "Fraude{" +
                "contenu='" + contenu + '\'' +
                ", datereleve=" + datereleve +
                ", description='" + description + '\'' +
                '}';
    }
}
