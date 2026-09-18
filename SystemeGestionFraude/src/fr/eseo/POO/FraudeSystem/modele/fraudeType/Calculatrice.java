package fr.eseo.POO.FraudeSystem.modele.fraudeType;

/**
 * Classe représentant une fraude liée à une calculatrice.
 * Cette classe hérite de la classe mère Fraude.
 *
 * Une fraude de type Calculatrice correspond par exemple à :
 *  - une calculatrice programmable
 *  - une calculatrice contenant des formules interdites
 *  - une mémoire non effacée
 */
public class Calculatrice extends Fraude {

    // Marque de la calculatrice utilisée (Casio, TI, NumWorks, etc.)
    private String marque;

    /**
     * Constructeur de la fraude Calculatrice.
     *
     * @param description  description générale de la fraude
     * @param contenu      contenu frauduleux trouvé (programme, formules…)
     * @param marque       marque de la calculatrice utilisée
     *
     * Le constructeur appelle d'abord le constructeur de la classe mère Fraude
     * grâce à super(description, contenu), puis initialise la marque.
     */
    public Calculatrice(String description, String contenu, String marque) {
        super(description, contenu);  // Appel au constructeur de Fraude
        this.marque = marque;         // Marque spécifique à la calculatrice
    }

    /**
     * Getter de la marque de la calculatrice.
     * @return la marque (String)
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Setter permettant de modifier la marque de la calculatrice.
     * @param marque nouvelle marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }
}
