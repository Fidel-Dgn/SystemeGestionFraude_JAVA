package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.util.Enummodalite;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe représentant une épreuve (examen, test, QCM, etc.)
 * Chaque épreuve possède :
 *  - une durée
 *  - une modalité (écrit, oral, QCM…)
 *  - un identifiant QCUE
 *  - une date et une heure de passage
 */
public class Epreuve {

    // Identifiant unique de l’épreuve (QCUE)
    private int qcue;

    // Date du passage de l’épreuve (sans l’heure)
    private LocalDate datePassage;

    // Heure exacte du passage (avec date + heure)
    private LocalDateTime heurePassage;

    // Durée de l’épreuve en minutes
    private int duree;

    // Modalité de l’épreuve (Enum : ECRIT, ORAL, QCM, PROJET, TP)
    private Enummodalite modalite;


    /**
     * Constructeur principal.
     * Lorsqu’on crée une épreuve :
     *  - la date du jour est automatiquement enregistrée
     *  - l’heure actuelle est enregistrée
     *  - la durée, la modalité et le QCUE sont fournis par l’utilisateur
     */
    public Epreuve(int duree, Enummodalite modalite, int qcue) {
        this.datePassage = LocalDate.now();        // Date du jour
        this.duree = duree;                        // Durée en minutes
        this.heurePassage = LocalDateTime.now();   // Heure actuelle
        this.modalite = modalite;                  // Modalité choisie
        this.qcue = qcue;                          // Identifiant QCUE
    }

    // ---------------------- GETTERS & SETTERS ----------------------

    public LocalDate getDatePassage() {
        return datePassage;
    }

    public void setDatePassage(LocalDate datePassage) {
        this.datePassage = datePassage;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public LocalDateTime getHeurePassage() {
        return heurePassage;
    }

    public void setHeurePassage(LocalDateTime heurePassage) {
        this.heurePassage = heurePassage;
    }

    public Enummodalite getModalite() {
        return modalite;
    }

    public void setModalite(Enummodalite modalite) {
        this.modalite = modalite;
    }

    public int getQcue() {
        return qcue;
    }

    public void setQcue(int qcue) {
        this.qcue = qcue;
    }

    /**
     * Méthode d'affichage lisible de l'épreuve.
     * Utile pour afficher les informations dans la console.
     */
    @Override
    public String toString() {
        return "Epreuve{" +
                "datePassage=" + datePassage +
                ", qcue=" + qcue +
                ", heurePassage=" + heurePassage +
                ", duree en minutes='" + duree + '\'' +
                ", modalite=" + modalite +
                '}';
    }
}
