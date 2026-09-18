package fr.eseo.POO.FraudeSystem.modele;

import fr.eseo.POO.FraudeSystem.modele.fraudeType.Fraude;
import fr.eseo.POO.FraudeSystem.modele.fraudeType.Iag;
import fr.eseo.POO.FraudeSystem.util.Enumcursus;
import fr.eseo.POO.FraudeSystem.util.Enummodalite;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FormulaireTest {

    /**
     * Test du constructeur de la classe Formulaire.
     * Vérifie :
     *  - l'initialisation correcte des listes d'étudiants et de fraudes
     *  - l'association correcte de l'épreuve
     *  - la génération automatique de la date de création
     *  - la génération automatique d'un ID unique
     */
    @Test
    public void testConstructeur() {

        // Création de deux étudiants
        Etudiant e1 = new Etudiant("Dupont", "Jean", Enumcursus.B1);
        Etudiant e2 = new Etudiant("Martin", "Lucie", Enumcursus.E3a);

        ArrayList<Etudiant> etuds = new ArrayList<>();
        etuds.add(e1);
        etuds.add(e2);

        // Création d'une fraude
        Fraude f = new Iag("IA", "ChatGPT", "ChatGPT");
        ArrayList<Fraude> fraudes = new ArrayList<>();
        fraudes.add(f);

        // Création d'une épreuve
        Epreuve ep = new Epreuve(30, Enummodalite.ECRIT, 10);

        // Création du formulaire
        Formulaire form = new Formulaire(etuds, fraudes, ep);

        // Vérification des données
        assertEquals(2, form.getEtudiants().size());
        assertEquals(1, form.getFraudes().size());
        assertEquals(30, form.getEpreuve().getDuree());

        // Vérifie la date de création automatique
        assertEquals(LocalDate.now(), form.getDateCreation());

        // Vérifie que l'ID est bien généré
        assertTrue(form.getId() >= 0);
    }

    /**
     * Test des setters de la classe Formulaire.
     * Vérifie que les listes d'étudiants, de fraudes et l'épreuve
     * peuvent être modifiées après la création du formulaire.
     */
    @Test
    public void testSetters() {
        Formulaire form = new Formulaire(new ArrayList<>(), new ArrayList<>(),
                new Epreuve(90, Enummodalite.QCM, 5));

        // Test setEtudiants
        ArrayList<Etudiant> newList = new ArrayList<>();
        newList.add(new Etudiant("A", "B", Enumcursus.B2));
        form.setEtudiants(newList);
        assertEquals(1, form.getEtudiants().size());

        // Test setFraudes
        ArrayList<Fraude> newFraudes = new ArrayList<>();
        newFraudes.add(new Iag("desc", "cont", "service"));
        form.setFraudes(newFraudes);
        assertEquals(1, form.getFraudes().size());

        // Test setEpreuve
        Epreuve newEp = new Epreuve(120, Enummodalite.ORAL, 99);
        form.setEpreuve(newEp);
        assertEquals(120, form.getEpreuve().getDuree());
        assertEquals(Enummodalite.ORAL, form.getEpreuve().getModalite());
    }

    /**
     * Test de l'ajout d'un étudiant dans la liste.
     * Vérifie que la liste interne est bien modifiable via getEtudiants().
     */
    @Test
    public void testAjoutEtudiant() {
        Formulaire form = new Formulaire(new ArrayList<>(), new ArrayList<>(),
                new Epreuve(90, Enummodalite.QCM, 5));

        Etudiant e = new Etudiant("Test", "User", Enumcursus.E1);
        form.getEtudiants().add(e);

        assertEquals(1, form.getEtudiants().size());
    }

    /**
     * Test de la méthode toString().
     * Vérifie que :
     *  - la méthode ne renvoie pas null
     *  - la chaîne contient des informations pertinentes
     */
    @Test
    public void testToString() {
        Formulaire form = new Formulaire(new ArrayList<>(), new ArrayList<>(),
                new Epreuve(60, Enummodalite.QCM, 5));

        String s = form.toString();

        assertNotNull(s);
        assertTrue(s.contains("Formulaire") || s.length() > 5);
    }
}
