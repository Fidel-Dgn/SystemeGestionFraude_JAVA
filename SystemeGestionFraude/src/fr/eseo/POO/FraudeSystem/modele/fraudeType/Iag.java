package fr.eseo.POO.FraudeSystem.modele.fraudeType;

/**
 * Classe représentant une fraude liée à l'utilisation d'un service d'IA générative.
 * Cette classe hérite de la classe abstraite Fraude.
 *
 * Exemples de services IAG :
 *  - ChatGPT
 *  - Copilot
 *  - Gemini
 *  - Claude
 *
 * Ce type de fraude correspond à l'utilisation d'un outil d'IA
 * pour générer du contenu interdit pendant une épreuve.
 */
public class Iag extends Fraude {

    // Nom du service d'IA utilisé (ex : "ChatGPT", "Copilot", etc.)
    private String nomservice;

    /**
     * Constructeur de la fraude IAG.
     *
     * @param description  description générale de la fraude
     * @param contenu      contenu frauduleux généré par l'IA
     * @param nomservice   nom du service d'IA utilisé
     *
     * Le constructeur appelle d'abord celui de la classe mère Fraude
     * pour initialiser la date, la description et le contenu.
     */
    public Iag(String description, String contenu, String nomservice) {
        super(description, contenu);   // Appel au constructeur de Fraude
        this.nomservice = nomservice;  // Nom du service IA
    }

    /**
     * Getter du nom du service IA utilisé.
     * @return nom du service (String)
     */
    public String getNomservice() {
        return nomservice;
    }

    /**
     * Setter permettant de modifier le nom du service IA.
     * @param nomservice nouveau nom du service
     */
    public void setNomservice(String nomservice) {
        this.nomservice = nomservice;
    }

    /**
     * Méthode d'affichage lisible d'une fraude IAG.
     * Elle inclut :
     *  - le contenu frauduleux
     *  - la date du relevé
     *  - la description
     *  - le nom du service IA utilisé
     */
    @Override
    public String toString() {
        return "Iag{" +
                "contenu='" + contenu + '\'' +
                ", datereleve=" + datereleve +
                ", description='" + description + '\'' +
                ", nomservice='" + nomservice + '\'' +
                '}';
    }
}
