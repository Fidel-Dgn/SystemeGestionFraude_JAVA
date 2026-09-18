package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.util.Enumcursus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EtudiantTest {

    /**
     * Test du constructeur de la classe Etudiant.
     * Vérifie :
     *  - l'initialisation correcte du nom, prénom et cursus
     *  - la génération automatique d'un ID unique et strictement positif
     */
    @Test
    public void testConstructeur() {
        Etudiant e = new Etudiant("Dupont", "Jean", Enumcursus.B1);

        // Vérification des valeurs passées au constructeur
        assertEquals("Dupont", e.getNom());
        assertEquals("Jean", e.getPrenom());
        assertEquals(Enumcursus.B1, e.getCursus());

        // Vérifie que l'ID auto-généré est valide
        assertTrue(e.getId() > 0);
    }

    /**
     * Test des setters de la classe Etudiant.
     * Vérifie que les modifications appliquées via les setters
     * sont correctement reflétées dans les getters.
     */
    @Test
    public void testSetters() {
        Etudiant e = new Etudiant("X", "Y", Enumcursus.B1);

        // Modification des attributs
        e.setNom("Martin");
        e.setPrenom("Alice");
        e.setCursus(Enumcursus.E3a);

        // Vérification des nouvelles valeurs
        assertEquals("Martin", e.getNom());
        assertEquals("Alice", e.getPrenom());
        assertEquals(Enumcursus.E3a, e.getCursus());
    }

    /**
     * Test de l'auto-incrémentation des IDs.
     * Vérifie que :
     *  - deux étudiants créés successivement n'ont pas le même ID
     *  - l'ID du second est strictement supérieur à celui du premier
     * Cela garantit le bon fonctionnement du compteur statique.
     */
    @Test
    public void testIdAutoIncrement() {
        Etudiant e1 = new Etudiant("A", "A", Enumcursus.B1);
        Etudiant e2 = new Etudiant("B", "B", Enumcursus.B2);

        // Les IDs doivent être différents
        assertNotEquals(e1.getId(), e2.getId());

        // L'ID doit augmenter dans le bon ordre
        assertTrue(e2.getId() > e1.getId());
    }
}
