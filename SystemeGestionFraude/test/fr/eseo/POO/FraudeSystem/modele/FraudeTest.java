package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.modele.fraudeType.Calculatrice;
import fr.eseo.POO.FraudeSystem.modele.fraudeType.Iag;
import fr.eseo.POO.FraudeSystem.modele.fraudeType.Iagconnecte;
import fr.eseo.POO.FraudeSystem.modele.fraudeType.Papier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FraudeTest {

    /**
     * Test de la classe Iag (fraude liée à l'utilisation d'un service d'IA).
     * Vérifie :
     *  - l'initialisation correcte des attributs
     *  - le bon fonctionnement des setters
     *  - la génération automatique de la date de relevé
     *  - la validité du toString()
     */
    @Test
    public void testIag() {
        Iag f = new Iag("IA", "ChatGPT", "ChatGPT");

        // Vérification des valeurs initiales
        assertEquals("IA", f.getDescription());
        assertEquals("ChatGPT", f.getContenu());
        assertEquals("ChatGPT", f.getNomservice());

        // Test des setters
        f.setDescription("Nouvelle desc");
        f.setContenu("Nouveau contenu");
        f.setNomservice("Copilot");

        assertEquals("Nouvelle desc", f.getDescription());
        assertEquals("Nouveau contenu", f.getContenu());
        assertEquals("Copilot", f.getNomservice());

        // Vérifie la date automatique
        assertEquals(LocalDate.now(), f.getDatereleve());

        // Vérifie que toString() renvoie bien une chaîne valide
        assertNotNull(f.toString());
    }

    /**
     * Test de la classe Iagconnecte (fraude liée à l'utilisation d'un service IA via réseau).
     * Vérifie :
     *  - l'initialisation correcte des attributs
     *  - la modification de l'adresse IP et des autres champs
     *  - la date de relevé automatique
     *  - la validité du toString()
     */
    @Test
    public void testIagConnecte() {
        Iagconnecte f = new Iagconnecte("IA connectée", "Discord", "192.168.1.1");

        // Vérification des valeurs initiales
        assertEquals("IA connectée", f.getDescription());
        assertEquals("Discord", f.getContenu());
        assertEquals("192.168.1.1", f.getAdresseIp());

        // Test des setters
        f.setAdresseIp("10.0.0.1");
        f.setDescription("Modif");
        f.setContenu("Modif2");

        assertEquals("10.0.0.1", f.getAdresseIp());
        assertEquals("Modif", f.getDescription());
        assertEquals("Modif2", f.getContenu());

        // Vérifie la date automatique
        assertEquals(LocalDate.now(), f.getDatereleve());

        // Vérifie que toString() renvoie bien une chaîne valide
        assertNotNull(f.toString());
    }

    /**
     * Test de la classe Papier (fraude liée à une antisèche papier).
     * Vérifie :
     *  - l'initialisation correcte des attributs
     *  - la modification de la dimension, du statut plié et des champs hérités
     *  - la date de relevé automatique
     *  - la validité du toString()
     */
    @Test
    public void testPapier() {
        Papier f = new Papier("Anti-sèche", "Formules", "5cm", true);

        // Vérification des valeurs initiales
        assertEquals("5cm", f.getDimension());
        assertTrue(f.isPlie());

        // Test des setters
        f.setDimension("10cm");
        f.setPlie(false);
        f.setDescription("Desc modif");
        f.setContenu("Contenu modif");

        assertEquals("10cm", f.getDimension());
        assertFalse(f.isPlie());
        assertEquals("Desc modif", f.getDescription());
        assertEquals("Contenu modif", f.getContenu());

        // Vérifie la date automatique
        assertEquals(LocalDate.now(), f.getDatereleve());

        // Vérifie que toString() renvoie bien une chaîne valide
        assertNotNull(f.toString());
    }

    /**
     * Test de la classe Calculatrice (fraude liée à l'utilisation d'une calculatrice non autorisée).
     * Vérifie :
     *  - l'initialisation correcte des attributs
     *  - la modification de la marque et des champs hérités
     *  - la date de relevé automatique
     *  - la validité du toString()
     */
    @Test
    public void testCalculatrice() {
        Calculatrice f = new Calculatrice("Calc", "TI-82", "Texas Instruments");

        // Vérification des valeurs initiales
        assertEquals("Texas Instruments", f.getMarque());
        assertEquals("Calc", f.getDescription());
        assertEquals("TI-82", f.getContenu());

        // Test des setters
        f.setMarque("Casio");
        f.setDescription("Modif desc");
        f.setContenu("Modif contenu");

        assertEquals("Casio", f.getMarque());
        assertEquals("Modif desc", f.getDescription());
        assertEquals("Modif contenu", f.getContenu());

        // Vérifie la date automatique
        assertEquals(LocalDate.now(), f.getDatereleve());

        // Vérifie que toString() renvoie bien une chaîne valide
        assertNotNull(f.toString());
    }
}
