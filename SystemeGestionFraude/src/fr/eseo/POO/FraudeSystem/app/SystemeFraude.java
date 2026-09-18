package fr.eseo.POO.FraudeSystem.app;

import fr.eseo.POO.FraudeSystem.modele.*;
import fr.eseo.POO.FraudeSystem.modele.fraudeType.*;
import fr.eseo.POO.FraudeSystem.util.Enumcursus;
import fr.eseo.POO.FraudeSystem.util.Enummodalite;

import java.util.*;

public class SystemeFraude {

    static Set<Etudiant> etudiants = new HashSet<>();
    static Set<Fraude> fraudes = new HashSet<>();
    static Set<Formulaire> formulaires = new HashSet<>();
    static Set<Epreuve> epreuves = new HashSet<>();

    public static final Scanner scanner = new Scanner(System.in);

    // ============================================================
    // RECHERCHE ETUDIANT
    // ============================================================

    public static void rechercheEtudiant() {

        boolean c = true;
        System.out.println("→ Recherche d'un étudiant...\n");

        while (c) {

            System.out.println("""
                Choisir le numéro de l'option :
                1- Rechercher par nom
                2- Rechercher par prénom
                3- Rechercher par ID
                """);

            System.out.print("Votre choix : ");

            int option = 0;
            boolean ok1 = false;

            while (!ok1) {
                try {
                    option = scanner.nextInt();
                    ok1 = true;
                } catch (Exception e) {
                    System.out.println("Saisie invalide. Réessayez : ");
                } finally {
                    scanner.nextLine();
                }
            }

            if (option == 1) {
                c = false;
                boolean b = true;

                System.out.println("Entrez le nom : ");
                String nom = scanner.nextLine();

                for (Etudiant e : etudiants) {
                    if (e.getNom().equalsIgnoreCase(nom)) {
                        b = false;
                        System.out.println(e);
                    }
                }

                if (b) System.out.println("Cet étudiant n'existe pas.\n");

            } else if (option == 2) {

                c = false;
                boolean b = true;

                System.out.println("Entrez le prénom : ");
                String prenom = scanner.nextLine();

                for (Etudiant e : etudiants) {
                    if (e.getPrenom().equalsIgnoreCase(prenom)) {
                        b = false;
                        System.out.println(e);
                    }
                }

                if (b) System.out.println("Cet étudiant n'existe pas.\n");

            } else if (option == 3) {

                c = false;
                boolean b = true;

                System.out.println("Entrez l'ID : ");

                int id = 0;
                boolean ok2 = false;

                while (!ok2) {
                    try {
                        id = scanner.nextInt();
                        ok2 = true;
                    } catch (Exception e) {
                        System.out.println("Saisie invalide. Réessayez : ");
                    } finally {
                        scanner.nextLine();
                    }
                }

                for (Etudiant e : etudiants) {
                    if (e.getId() == id) {
                        b = false;
                        System.out.println(e);
                    }
                }

                if (b) System.out.println("Cet étudiant n'existe pas.\n");

            } else {
                System.out.println("Erreur : Choisissez un nombre valide.");
            }
        }
    }

    // ============================================================
    // RECHERCHE FORMULAIRE
    // ============================================================

    public static void rechercherFormulaire() {

        System.out.println("→ Recherche d'un formulaire...\n");
        boolean b = true;

        while (b) {

            System.out.println("""
                Choisissez l'option :
                1- Formulaires d'un étudiant
                2- Formulaires d'une épreuve
                """);

            System.out.print("Votre choix : ");

            int d = 0;
            boolean ok3 = false;

            while (!ok3) {
                try {
                    d = scanner.nextInt();
                    ok3 = true;
                } catch (Exception e) {
                    System.out.println("Saisie invalide. Réessayez : ");
                } finally {
                    scanner.nextLine();
                }
            }

            if (d == 1) {

                b = false;
                boolean o = true;
                List<Formulaire> lf = new ArrayList<>();

                System.out.println("Entrez l'ID étudiant : ");

                int ide = 0;
                boolean ok4 = false;

                while (!ok4) {
                    try {
                        ide = scanner.nextInt();
                        ok4 = true;
                    } catch (Exception e) {
                        System.out.println("Saisie invalide. Réessayez : ");
                    } finally {
                        scanner.nextLine();
                    }
                }

                for (Formulaire f : formulaires) {
                    for (Etudiant e : f.getEtudiants()) {
                        if (e.getId() == ide) {
                            lf.add(f);
                            o = false;
                        }
                    }
                }

                if (o) System.out.println("Aucun formulaire trouvé.\n");
                else lf.forEach(System.out::println);

            } else if (d == 2) {

                b = false;
                boolean o = true;
                List<Formulaire> lf = new ArrayList<>();

                System.out.println("Entrez le QCUE : ");

                int t = 0;
                boolean ok5 = false;

                while (!ok5) {
                    try {
                        t = scanner.nextInt();
                        ok5 = true;
                    } catch (Exception e) {
                        System.out.println("Saisie invalide. Réessayez : ");
                    } finally {
                        scanner.nextLine();
                    }
                }

                for (Formulaire f : formulaires) {
                    if (f.getEpreuve().getQcue() == t) {
                        lf.add(f);
                        o = false;
                    }
                }

                if (o) System.out.println("Aucun formulaire trouvé.\n");
                else lf.forEach(System.out::println);

            } else {
                System.out.println("Erreur : choix invalide.\n");
            }
        }
    }


    // ============================================================
    // AJOUT ETUDIANT
    // ============================================================

    public static void ajouterEtudiant() {

        System.out.println("→ Ajout d'un étudiant...\n");
        System.out.println("Entrez les informations de l'étudiant.\n");

        System.out.println("Nom : ");
        String nom = scanner.nextLine();

        System.out.println("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.println("Cursus {B1, B2, B3, E1, E2, E3e, E3a, E4e, E4a, E5e, E5a} : ");

        Enumcursus cursus = null;
        boolean ok = false;

        while (!ok) {
            try {
                cursus = Enumcursus.valueOf(scanner.nextLine());
                ok = true;
            } catch (Exception e) {
                System.out.println("Cursus invalide. Réessayez : ");
            }
        }

        etudiants.add(new Etudiant(nom, prenom, cursus));
        System.out.println("Étudiant ajouté avec succès.\n");
    }

    // ============================================================
    // AJOUT FORMULAIRE
    // ============================================================

    public static void ajouterFormulaire() {

        System.out.println("→ Ajout d'un formulaire...\n");

        ArrayList<Etudiant> etuds = new ArrayList<>();
        ArrayList<Fraude> fraudesForm = new ArrayList<>();

        System.out.println("Entrer les informations de l'épreuve : ");
        System.out.println("Durée : ");

        int duree = 0;
        boolean ok6 = false;

        while (!ok6) {
            try {
                duree = scanner.nextInt();
                ok6 = true;
            } catch (Exception e) {
                System.out.println("Saisie invalide. Réessayez : ");
            } finally {
                scanner.nextLine();
            }
        }

        System.out.println("Modalité {ECRIT, ORAL, QCM, PROJET, TP} : ");

        Enummodalite mod = null;
        boolean okMod = false;

        while (!okMod) {
            try {
                mod = Enummodalite.valueOf(scanner.nextLine());
                okMod = true;
            } catch (Exception e) {
                System.out.println("Modalité invalide. Réessayez : ");
            }
        }

        System.out.println("QCUE : ");

        int qcue = 0;
        boolean ok7 = false;

        while (!ok7) {
            try {
                qcue = scanner.nextInt();
                ok7 = true;
            } catch (Exception e) {
                System.out.println("Saisie invalide. Réessayez : ");
            } finally {
                scanner.nextLine();
            }
        }

        Epreuve ep = new Epreuve(duree, mod, qcue);
        epreuves.add(ep);

        System.out.println("Combien d'étudiants dans ce formulaire ?");

        int nbE = 0;
        boolean ok8 = false;

        while (!ok8) {
            try {
                nbE = scanner.nextInt();
                ok8 = true;
            } catch (Exception e) {
                System.out.println("Saisie invalide. Réessayez : ");
            } finally {
                scanner.nextLine();
            }
        }

        for (int i = 0; i < nbE; i++) {

            System.out.println("Nom : ");
            String nom = scanner.nextLine();

            System.out.println("Prénom : ");
            String prenom = scanner.nextLine();

            System.out.println("Cursus {B1, B2, B3, E1, E2, E3e, E3a, E4e, E4a, E5e, E5a} : ");

            Enumcursus cursus = null;
            boolean okCurcus = false;

            while (!okCurcus) {
                try {
                    cursus = Enumcursus.valueOf(scanner.nextLine());
                    okCurcus = true;
                } catch (Exception e) {
                    System.out.println("Cursus invalide. Réessayez : ");
                }
            }

            Etudiant et = new Etudiant(nom, prenom, cursus);
            etudiants.add(et);
            etuds.add(et);
        }

        System.out.println("Nombre de fraudes à enregistrer : ");

        int nbF = 0;
        boolean ok9 = false;

        while (!ok9) {
            try {
                nbF = scanner.nextInt();
                ok9 = true;
            } catch (Exception e) {
                System.out.println("Saisie invalide. Réessayez : ");
            } finally {
                scanner.nextLine();
            }
        }

        for (int i = 0; i < nbF; i++) {

            System.out.println("Description : ");
            String des = scanner.nextLine();

            System.out.println("Contenu : ");
            String contenu = scanner.nextLine();

            System.out.println("Type {Iag, IagConnecte, Papier, Calculatrice} : ");

            boolean okType = false;

            while (!okType) {

                String t = scanner.nextLine();

                switch (t) {

                    case "Iag":
                        System.out.println("Nom service : ");
                        String ns = scanner.nextLine();
                        fraudesForm.add(new Iag(des, contenu, ns));
                        okType = true;
                        break;


                    case "IagConnecte":
                        String ip = "";
                        boolean ipValide = false;

                        while (!ipValide) {
                            System.out.println("Adresse IP : ");
                            ip = scanner.nextLine().trim();

                            // Vérification du format IPv4
                            String regexIP = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";

                            if (ip.matches(regexIP)) {
                                ipValide = true;
                            } else {
                                System.out.println("Adresse IP invalide. Format attendu : x.x.x.x (0-255). Réessayez : ");
                            }
                        }

                        fraudes.add(new Iagconnecte(des, contenu, ip));
                        okType = true;
                        break;



                    case "Papier":
                        System.out.println("Dimension : ");
                        String dim = scanner.nextLine();

                        System.out.println("Plié (true/false) : ");

                        boolean plie = false;
                        boolean okBool = false;

                        while (!okBool) {
                            try {
                                plie = scanner.nextBoolean();
                                okBool = true;
                            } catch (Exception e) {
                                System.out.println("Saisie invalide. Tapez true/false : ");
                            } finally {
                                scanner.nextLine(); // vider le buffer
                            }
                        }

                        fraudesForm.add(new Papier(des, contenu, dim, plie));
                        okType = true;
                        break;

                    case "Calculatrice":
                        System.out.println("Marque : ");
                        String m = scanner.nextLine();
                        fraudesForm.add(new Calculatrice(des, contenu, m));
                        okType = true;
                        break;

                    default:
                        System.out.println("Type invalide. Réessayez : ");
                        break;
                }

            }
        }

        formulaires.add(new Formulaire(etuds, fraudesForm, ep));
        System.out.println("Formulaire ajouté.\n");
    }

    // ============================================================
    // AJOUT EPREUVE
    // ============================================================

    public static void ajouterEpreuve() {

        System.out.println("→ Ajout d'une épreuve...\n");

        System.out.println("Durée : ");

        int duree = 0;
        boolean a2 = false;

        while (!a2) {
            try {
                duree = scanner.nextInt();
                a2 = true;
            } catch (Exception e) {
                System.out.println("Saisie invalide. Réessayez : ");
            } finally {
                scanner.nextLine();
            }
        }

        System.out.println("Modalité {ECRIT, ORAL, QCM, PROJET, TP} : ");

        Enummodalite mod = null;
        boolean okMod = false;

        while (!okMod) {
            try {
                mod = Enummodalite.valueOf(scanner.nextLine());
                okMod = true;
            } catch (Exception e) {
                System.out.println("Modalité invalide. Réessayez : ");
            }
        }

        System.out.println("QCUE : ");

        int qcue = 0;
        boolean a3 = false;

        while (!a3) {
            try {
                qcue = scanner.nextInt();
                a3 = true;
            } catch (Exception e) {
                System.out.println("Saisie invalide. Réessayez : ");
            } finally {
                scanner.nextLine();
            }
        }

        epreuves.add(new Epreuve(duree, mod, qcue));
        System.out.println("Épreuve ajoutée.\n");
    }

    // ============================================================
    // AJOUT FRAUDE
    // ============================================================

    public static void ajouterFraude() {

        System.out.println("→ Ajout d'une fraude...\n");

        System.out.println("Description : ");
        String des = scanner.nextLine();

        System.out.println("Contenu : ");
        String contenu = scanner.nextLine();

        System.out.println("Type {Iag, IagConnecte, Papier, Calculatrice} : ");

        boolean okType = false;

        while (!okType) {

            String t = scanner.nextLine();

            switch (t) {

                case "Iag":
                    System.out.println("Nom service : ");
                    String ns = scanner.nextLine();
                    fraudes.add(new Iag(des, contenu, ns));
                    okType = true;
                    break;

                case "IagConnecte":
                    String ip = "";
                    boolean ipValide = false;

                    while (!ipValide) {
                        System.out.println("Adresse IP : ");
                        ip = scanner.nextLine().trim();

                        // Vérification du format IPv4
                        String regexIP = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";

                        if (ip.matches(regexIP)) {
                            ipValide = true;
                        } else {
                            System.out.println("Adresse IP invalide. Format attendu : x.x.x.x (0-255). Réessayez : ");
                        }
                    }

                    fraudes.add(new Iagconnecte(des, contenu, ip));
                    okType = true;
                    break;


                case "Papier":
                    System.out.println("Dimension : ");
                    String dim = scanner.nextLine();

                    System.out.println("Plié (true/false) : ");

                    boolean pl = false;
                    boolean okBool = false;

                    while (!okBool) {
                        try {
                            pl = scanner.nextBoolean();
                            okBool = true;
                        } catch (Exception e) {
                            System.out.println("Saisie invalide. Tapez true/false : ");
                        } finally {
                            scanner.nextLine();
                        }
                    }

                    fraudes.add(new Papier(des, contenu, dim, pl));
                    okType = true;
                    break;

                case "Calculatrice":
                    System.out.println("Marque : ");
                    String m = scanner.nextLine();
                    fraudes.add(new Calculatrice(des, contenu, m));
                    okType = true;
                    break;

                default:
                    System.out.println("Type invalide. Réessayez : ");
                    break;
            }

        }

        System.out.println("Fraude ajoutée.\n");
    }

    // ============================================================
    // RETIRER ETUDIANT
    // ============================================================

    public static void retirerEtudiant() {

        System.out.println("→ Retrait d'un étudiant...\n");

        System.out.println("Liste des étudiants :");
        etudiants.forEach(System.out::println);

        boolean supprime = false;

        while (!supprime) {

            System.out.print("\nEntrez l'ID de l'étudiant à retirer : ");

            int id1 = 0;
            boolean a4 = false;

            while (!a4) {
                try {
                    id1 = scanner.nextInt();
                    a4 = true;
                } catch (Exception e) {
                    System.out.println("Saisie invalide. Réessayez : ");
                } finally {
                    scanner.nextLine();
                }
            }

            int finalId = id1;
            supprime = etudiants.removeIf(e -> e.getId() == finalId);

            if (supprime) {
                System.out.println("Étudiant retiré.\n");
            } else {
                System.out.println("Aucun étudiant trouvé avec cet ID. Réessayez.\n");
            }
        }
    }

    // ============================================================
    // RETIRER FORMULAIRE
    // ============================================================

    public static void retirerFormulaire() {

        System.out.println("→ Retrait d'un formulaire...\n");

        System.out.println("Liste des formulaires :");
        formulaires.forEach(System.out::println);

        boolean supprime = false;

        while (!supprime) {

            System.out.print("\nEntrez l'ID du formulaire à retirer : ");

            int id = 0;
            boolean a5 = false;

            while (!a5) {
                try {
                    id = scanner.nextInt();
                    a5 = true;
                } catch (Exception e) {
                    System.out.println("Saisie invalide. Réessayez : ");
                } finally {
                    scanner.nextLine();
                }
            }

            int finalId = id;
            supprime = formulaires.removeIf(f -> f.getId() == finalId);

            if (supprime) {
                System.out.println("Formulaire retiré.\n");
            } else {
                System.out.println("Aucun formulaire trouvé avec cet ID. Réessayez.\n");
            }
        }
    }

    // ============================================================
    // RETIRER EPREUVE
    // ============================================================

    public static void retirerEpreuve() {

        System.out.println("→ Retrait d'une épreuve...\n");

        System.out.println("Liste des épreuves :");
        epreuves.forEach(System.out::println);

        boolean supprime = false;

        while (!supprime) {

            System.out.print("\nEntrez le QCUE de l'épreuve à retirer : ");

            int qcue = 0;
            boolean a6 = false;

            while (!a6) {
                try {
                    qcue = scanner.nextInt();
                    a6 = true;
                } catch (Exception e) {
                    System.out.println("Saisie invalide. Réessayez : ");
                } finally {
                    scanner.nextLine();
                }
            }

            int finalQcue = qcue;
            supprime = epreuves.removeIf(e -> e.getQcue() == finalQcue);

            if (supprime) {
                System.out.println("Épreuve retirée.\n");
            } else {
                System.out.println("Aucune épreuve trouvée avec ce QCUE. Réessayez.\n");
            }
        }
    }

    // ============================================================
    // RETIRER FRAUDE
    // ============================================================

    public static void retirerFraude() {

        System.out.println("→ Retrait d'une fraude...\n");

        System.out.println("Liste des fraudes :");
        fraudes.forEach(System.out::println);

        boolean supprime = false;

        while (!supprime) {

            System.out.print("\nEntrez la description de la fraude à retirer : ");
            String desc = scanner.nextLine().trim();

            supprime = fraudes.removeIf(f -> f.getDescription().equalsIgnoreCase(desc));

            if (supprime) {
                System.out.println("Fraude retirée.\n");
            } else {
                System.out.println("Aucune fraude trouvée avec cette description. Réessayez.\n");
            }
        }
    }




    // ============================================================
    // ANALYSE STATISTIQUE
    // ============================================================

    public static void analyseStatistique() {

        System.out.println("→ Analyse statistique des fraudes...\n");

        int nbFormulaires = formulaires.size();

        // Ensemble des étudiants distincts
        Set<Etudiant> etudiantsDistincts = new HashSet<>();
        for (Formulaire f : formulaires) {
            etudiantsDistincts.addAll(f.getEtudiants());
        }
        int nbEtudiantsDistincts = etudiantsDistincts.size();

        // Nombre total de fraudes
        int nbFraudes = 0;
        List<Integer> listeFraudesParFormulaire = new ArrayList<>();

        for (Formulaire f : formulaires) {
            int nbF = f.getFraudes().size();
            nbFraudes += nbF;
            listeFraudesParFormulaire.add(nbF);
        }

        // Moyenne
        double moyenne = 0;
        if (nbFormulaires > 0) {
            moyenne = (double) nbFraudes / nbFormulaires;
        }

        // Écart-type
        double variance = 0;
        if (nbFormulaires > 0) {
            double somme = 0;
            for (int x : listeFraudesParFormulaire) {
                somme += Math.pow(x - moyenne, 2);
            }
            variance = somme / nbFormulaires;
        }
        double ecartType = Math.sqrt(variance);

        // Affichage
        System.out.println("================== STATISTIQUES =================");
        System.out.println("Nombre total de formulaires : " + nbFormulaires);
        System.out.println("Nombre d'étudiants distincts concernés : " + nbEtudiantsDistincts);
        System.out.println("Nombre total de fraudes enregistrées : " + nbFraudes);
        System.out.println("Moyenne de fraudes par formulaire : " + moyenne);
        System.out.println("Écart-type du nombre de fraudes : " + ecartType);
        System.out.println("=================================================\n");
    }

    // ============================================================
    // GENERER GRAPHE
    // ============================================================

    public static void genererGraphe() {

        System.out.println("→ Génération du graphe non orienté des étudiants fraudeurs...\n");

        Map<Etudiant, Set<Etudiant>> graphe = new HashMap<>();

        // Ajout des étudiants présents dans au moins un formulaire
        for (Formulaire f : formulaires) {
            for (Etudiant e : f.getEtudiants()) {
                graphe.putIfAbsent(e, new HashSet<>());
            }
        }

        // Ajout des arêtes
        for (Formulaire f : formulaires) {
            List<Etudiant> liste = new ArrayList<>(f.getEtudiants());

            for (int i = 0; i < liste.size(); i++) {
                for (int j = i + 1; j < liste.size(); j++) {

                    Etudiant e1 = liste.get(i);
                    Etudiant e2 = liste.get(j);

                    graphe.get(e1).add(e2);
                    graphe.get(e2).add(e1);
                }
            }
        }

        // Affichage
        System.out.println("===== GRAPHE DES ETUDIANTS FRAUDEURS =====");

        if (graphe.isEmpty()) {
            System.out.println("Aucun étudiant n'est associé à un formulaire.");
            return;
        }

        for (Etudiant e : graphe.keySet()) {
            System.out.print(e.getNom() + " " + e.getPrenom() + " → ");

            Set<Etudiant> voisins = graphe.get(e);

            if (voisins.isEmpty()) {
                System.out.println("Aucun lien");
            } else {
                for (Etudiant v : voisins) {
                    System.out.print(v.getNom() + " " + v.getPrenom() + "  ");
                }
                System.out.println();
            }
        }

        System.out.println("==========================================\n");
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        // Étudiants initiaux
        Etudiant e1 = new Etudiant("Martin", "Badlane", Enumcursus.E1);
        Etudiant e2 = new Etudiant("Dupont", "Karim", Enumcursus.E2);
        Etudiant e3 = new Etudiant("Leroy", "Sophie", Enumcursus.E3a);
        Etudiant e4 = new Etudiant("Bernard", "Lucas", Enumcursus.E4e);

        etudiants.add(e1);
        etudiants.add(e2);
        etudiants.add(e3);
        etudiants.add(e4);

        // Épreuves initiales
        Epreuve ep1 = new Epreuve(120, Enummodalite.ECRIT, 101);
        Epreuve ep2 = new Epreuve(90, Enummodalite.QCM, 205);

        epreuves.add(ep1);
        epreuves.add(ep2);

        // Fraudes initiales
        Iag fIAG = new Iag("Utilisation d'un service IAG", "Contenu généré automatiquement", "ChatGPT");
        fraudes.add(fIAG);

        Iagconnecte fIAGC = new Iagconnecte("Consultation d'un service IAG via réseau", "Réponses obtenues en ligne", "192.168.1.42");
        fraudes.add(fIAGC);

        Papier fPapier = new Papier("Anti-sèche papier", "Texte manuscrit", "5x5 cm", true);
        fraudes.add(fPapier);

        Calculatrice fCalc = new Calculatrice("Programme interdit", "Formules intégrales", "Casio");
        fraudes.add(fCalc);

        // Formulaires initiaux
        Formulaire f1 = new Formulaire(new ArrayList<>(List.of(e1)), new ArrayList<>(List.of(fCalc)), ep1);
        Formulaire f2 = new Formulaire(new ArrayList<>(List.of(e2)), new ArrayList<>(List.of(fCalc, fIAG)), ep1);
        Formulaire f3 = new Formulaire(new ArrayList<>(List.of(e1, e2)), new ArrayList<>(List.of(fIAGC, fPapier)), ep1);

        formulaires.add(f1);
        formulaires.add(f2);
        formulaires.add(f3);

        // Menu principal
        while (true) {

            System.out.println("----------------------------------------------------SystemeFraude----------------------------------------------------------");
            System.out.println("                                           *** BIENVENUE SUR SYSTEMEFRAUDE ***                                                   ");

            System.out.println("""
                Veuillez choisir l'action à exécuter :
                1- Rechercher un étudiant
                2- Rechercher un formulaire
                3- Ajouter un étudiant
                4- Ajouter un formulaire
                5- Ajouter une épreuve
                6- Ajouter une fraude
                7- Retirer un étudiant
                8- Retirer un formulaire
                9- Retirer une épreuve
                10- Retirer une fraude
                11- Analyse statistique
                12- Générer graphe non orienté
                """);

            System.out.print("Votre choix : ");

            int choix = 0;
            boolean ok = false;

            while (!ok) {
                try {
                    choix = scanner.nextInt();
                    ok = true;
                } catch (Exception e) {
                    System.out.println("Saisie invalide. Réessayez : ");
                } finally {
                    scanner.nextLine();
                }
            }

            switch (choix) {
                case 1:
                    rechercheEtudiant();
                    break;

                case 2:
                    rechercherFormulaire();
                    break;

                case 3:
                    ajouterEtudiant();
                    break;

                case 4:
                    ajouterFormulaire();
                    break;

                case 5:
                    ajouterEpreuve();
                    break;

                case 6:
                    ajouterFraude();
                    break;

                case 7:
                    retirerEtudiant();
                    break;

                case 8:
                    retirerFormulaire();
                    break;

                case 9:
                    retirerEpreuve();
                    break;

                case 10:
                    retirerFraude();
                    break;

                case 11:
                    analyseStatistique();
                    break;

                case 12:
                    genererGraphe();
                    break;

                default:
                    System.out.println("Erreur : numéro invalide.\n");
                    break;
            }

        }
    }
}


