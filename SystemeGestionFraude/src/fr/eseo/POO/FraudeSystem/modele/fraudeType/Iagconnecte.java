package fr.eseo.POO.FraudeSystem.modele.fraudeType;

/**
 * Classe représentant une fraude liée à l'utilisation d'un service d'IA
 * via une connexion réseau (adresse IP détectée).
 *
 * Cette classe hérite de la classe abstraite Fraude.
 *
 * Elle est utilisée lorsqu'un étudiant a consulté un service d'IA
 * pendant une épreuve via Internet (ex : ChatGPT, Copilot, Gemini…).
 */
public class Iagconnecte extends Fraude {

    // Adresse IP utilisée pour accéder au service d'IA
    private String adresseIp;

    /**
     * Constructeur de la fraude IAG connectée.
     *
     * @param description description générale de la fraude
     * @param contenu     contenu frauduleux trouvé (réponses, texte généré…)
     * @param adresseIp   adresse IP utilisée pour accéder au service IA
     *
     * Le constructeur appelle d'abord celui de la classe mère Fraude
     * pour initialiser la date, la description et le contenu.
     */
    public Iagconnecte(String description, String contenu, String adresseIp) {
        super(description, contenu);   // Appel au constructeur de Fraude
        this.adresseIp = adresseIp;    // Adresse IP spécifique
    }

    /**
     * Getter de l'adresse IP utilisée.
     * @return adresse IP (String)
     */
    public String getAdresseIp() {
        return adresseIp;
    }

    /**
     * Setter permettant de modifier l'adresse IP.
     * @param adresseIp nouvelle adresse IP
     */
    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    /**
     * Méthode d'affichage lisible d'une fraude IAG connectée.
     * Elle inclut :
     *  - le contenu frauduleux
     *  - la date du relevé
     *  - la description
     *  - l'adresse IP utilisée
     */
    @Override
    public String toString() {
        return "Iagconnecte{" +
                "contenu='" + contenu + '\'' +
                ", datereleve=" + datereleve +
                ", description='" + description + '\'' +
                ", adresseIp='" + adresseIp + '\'' +
                '}';
    }
}
