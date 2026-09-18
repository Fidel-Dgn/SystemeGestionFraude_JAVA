package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.util.Enummodalite;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class EpreuveTest {

    /**
     * Test du constructeur de la classe Epreuve.
     * Vérifie :
     *  - l'initialisation correcte des attributs passés en paramètres
     *  - l'initialisation automatique de la date et de l'heure
     */
    @Test
    public void testConstructeur() {
        Epreuve ep = new Epreuve(45, Enummodalite.ECRIT, 10);

        // Vérification des valeurs passées au constructeur
        assertEquals(45, ep.getDuree());
        assertEquals(Enummodalite.ECRIT, ep.getModalite());
        assertEquals(10, ep.getQcue());

        // Vérifie que la date du jour est bien enregistrée automatiquement
        assertEquals(LocalDate.now(), ep.getDatePassage());

        // Vérifie que l'heure de passage est bien initialisée
        assertNotNull(ep.getHeurePassage());
    }

    /**
     * Test des setters principaux.
     * Vérifie que les modifications appliquées via les setters
     * sont correctement reflétées dans les getters.
     */
    @Test
    public void testSetters() {
        Epreuve ep = new Epreuve(90, Enummodalite.QCM, 5);

        // Modification des valeurs
        ep.setDuree(60);
        ep.setModalite(Enummodalite.ORAL);
        ep.setQcue(99);

        // Vérification des nouvelles valeurs
        assertEquals(60, ep.getDuree());
        assertEquals(Enummodalite.ORAL, ep.getModalite());
        assertEquals(99, ep.getQcue());
    }

    /**
     * Test des setters de date et d'heure.
     * Permet de vérifier que les valeurs temporelles peuvent être modifiées
     * manuellement après la création de l'objet.
     */
    @Test
    public void testSetDateEtHeure() {
        Epreuve ep = new Epreuve(30, Enummodalite.ECRIT, 3);

        // Nouvelles valeurs temporelles
        LocalDate newDate = LocalDate.of(2024, 5, 10);
        LocalDateTime newHeure = LocalDateTime.of(2024, 5, 10, 14, 30);

        // Application des setters
        ep.setDatePassage(newDate);
        ep.setHeurePassage(newHeure);

        // Vérification
        assertEquals(newDate, ep.getDatePassage());
        assertEquals(newHeure, ep.getHeurePassage());
    }

    /**
     * Test de la méthode toString().
     * Vérifie que :
     *  - la méthode ne renvoie pas null
     *  - la chaîne contient bien les informations essentielles
     */
    @Test
    public void testToString() {
        Epreuve ep = new Epreuve(20, Enummodalite.ECRIT, 10);

        String s = ep.toString();

        // Vérifie que la chaîne existe
        assertNotNull(s);

        // Vérifie que les champs importants apparaissent dans la chaîne
        assertTrue(s.contains("Epreuve"));
        assertTrue(s.contains("duree"));
        assertTrue(s.contains("modalite"));
        assertTrue(s.contains("qcue"));
    }
}
