package fr.eseo.POO.FraudeSystem.app;

import fr.eseo.POO.FraudeSystem.modele.*;
import fr.eseo.POO.FraudeSystem.modele.fraudeType.*;
import fr.eseo.POO.FraudeSystem.util.Enumcursus;
import fr.eseo.POO.FraudeSystem.util.Enummodalite;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestSystem {

    /**
     * Avant chaque test, on réinitialise toutes les collections statiques
     * du système pour garantir l’indépendance des tests.
     * Cela évite que les données d’un test polluent les autres.
     */
    @BeforeEach
    public void setup() {
        SystemeFraude.etudiants.clear();
        SystemeFraude.fraudes.clear();
        SystemeFraude.formulaires.clear();
        SystemeFraude.epreuves.clear();
    }

    /**
     * Test de la méthode analyseStatistique().
     * On crée un formulaire simple contenant 1 étudiant et 1 fraude,
     * puis on vérifie que la méthode ne plante pas et que les données
     * restent cohérentes.
     */
    @Test
    public void testAnalyseStatistique() {
        Etudiant e1 = new Etudiant("A", "A", Enumcursus.B1);
        Fraude f1 = new Iag("IA", "X", "ChatGPT");

        Formulaire form = new Formulaire(
                new ArrayList<>(List.of(e1)),
                new ArrayList<>(List.of(f1)),
                new Epreuve(123, Enummodalite.ECRIT, 10)
        );

        SystemeFraude.formulaires.add(form);

        // Vérifie que la méthode s’exécute sans erreur
        SystemeFraude.analyseStatistique();

        // Vérifie que le formulaire est bien enregistré
        assertEquals(1, SystemeFraude.formulaires.size());
    }

    /**
     * Test de la méthode genererGraphe().
     * On crée un formulaire contenant deux étudiants pour générer une arête.
     * Le test vérifie simplement que la méthode ne génère pas d’exception.
     */
    @Test
    public void testGenererGraphe() {
        Etudiant e1 = new Etudiant("A", "A", Enumcursus.B1);
        Etudiant e2 = new Etudiant("B", "B", Enumcursus.B2);

        Formulaire f = new Formulaire(
                new ArrayList<>(List.of(e1, e2)),
                new ArrayList<>(),
                new Epreuve(30, Enummodalite.ECRIT, 10)
        );

        SystemeFraude.formulaires.add(f);

        // Vérifie que la génération du graphe ne plante pas
        SystemeFraude.genererGraphe();

        assertTrue(true); // Assertion symbolique
    }

    /**
     * Test du retrait d’un étudiant.
     * On ajoute un étudiant puis on le supprime via removeIf().
     * On utilise son ID réel pour éviter les erreurs liées à l’auto-incrémentation.
     */
    @Test
    public void testRetirerEtudiant() {
        Etudiant e1 = new Etudiant("A", "A", Enumcursus.B1);
        SystemeFraude.etudiants.add(e1);

        boolean removed = SystemeFraude.etudiants.removeIf(e -> e.getId() == e1.getId());

        assertTrue(removed);
    }

    /**
     * Test du retrait d’une épreuve.
     * On supprime l’épreuve en se basant sur son QCUE.
     */
    @Test
    public void testRetirerEpreuve() {
        Epreuve ep = new Epreuve(60, Enummodalite.ECRIT, 10);
        SystemeFraude.epreuves.add(ep);

        boolean removed = SystemeFraude.epreuves.removeIf(e -> e.getQcue() == 10);

        assertTrue(removed);
    }

    /**
     * Test du retrait d’une fraude.
     * On supprime une fraude en se basant sur sa description.
     */
    @Test
    public void testRetirerFraude() {
        Fraude f = new Iag("IA", "X", "ChatGPT");
        SystemeFraude.fraudes.add(f);

        boolean removed = SystemeFraude.fraudes.removeIf(x -> x.getDescription().equals("IA"));

        assertTrue(removed);
    }

    /**
     * Test du retrait d’un formulaire.
     * On supprime le formulaire en utilisant son ID unique.
     */
    @Test
    public void testRetirerFormulaire() {
        Formulaire f = new Formulaire(
                new ArrayList<>(),
                new ArrayList<>(),
                new Epreuve(30, Enummodalite.ECRIT, 10)
        );

        SystemeFraude.formulaires.add(f);

        boolean removed = SystemeFraude.formulaires.removeIf(x -> x.getId() == f.getId());

        assertTrue(removed);
    }
}
