package fr.eseo.POO.FraudeSystem.modele.fraudeType;

/**
 * Classe représentant une fraude de type "Papier".
 *
 * Cette classe hérite de la classe abstraite Fraude.
 * Elle correspond à une fraude classique : anti‑sèche, note manuscrite,
 * papier plié caché, etc.
 *
 * Elle ajoute deux attributs spécifiques :
 *  - dimension : taille du papier (ex : "5x5 cm")
 *  - plie : indique si le papier était plié ou non
 */
public class Papier extends Fraude {

    // Dimension du papier frauduleux (ex : "5x5 cm")
    private String dimension;

    // Indique si le papier était plié (true/false)
    boolean plie;

    /**
     * Constructeur de la fraude Papier.
     *
     * @param description description générale de la fraude
     * @param contenu     contenu écrit sur le papier
     * @param dimension   taille du papier
     * @param plie        indique si le papier était plié
     *
     * Le constructeur appelle d'abord celui de la classe mère Fraude
     * pour initialiser la date, la description et le contenu.
     */
    public Papier(String description, String contenu, String dimension, boolean plie) {
        super(description, contenu);  // Appel au constructeur de Fraude
        this.dimension = dimension;   // Taille du papier
        this.plie = plie;             // Papier plié ou non
    }

    /**
     * Getter de la dimension du papier.
     * @return dimension (String)
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * Setter permettant de modifier la dimension du papier.
     * @param dimension nouvelle dimension
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     * Getter indiquant si le papier était plié.
     * @return true si plié, false sinon
     */
    public boolean isPlie() {
        return plie;
    }

    /**
     * Setter permettant de modifier l'état plié/non plié.
     * @param plie nouvelle valeur
     */
    public void setPlie(boolean plie) {
        this.plie = plie;
    }

    /**
     * Méthode d'affichage lisible d'une fraude Papier.
     * Elle inclut :
     *  - le contenu frauduleux
     *  - la date du relevé
     *  - la description
     *  - la dimension
     *  - l'état plié ou non
     */
    @Override
    public String toString() {
        return "Papier{" +
                "contenu='" + contenu + '\'' +
                ", datereleve=" + datereleve +
                ", description='" + description + '\'' +
                ", dimension='" + dimension + '\'' +
                ", plie=" + plie +
                '}';
    }
}
