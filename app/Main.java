import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        // Main Created By AI

        System.out.println("=================================================");
        System.out.println("   SYSTEME DE GESTION DE BIBLIOTHEQUE - TESTS   ");
        System.out.println("=================================================\n");

        // -------------------------------------------------------------
        // Etape 1 : Creer la bibliotheque
        // -------------------------------------------------------------
        System.out.println("--- [1] Initialisation de la Bibliotheque ---");
        Bibliotheque biblio = new Bibliotheque();
        System.out.println("Bibliotheque initialisee avec succes.\n");

        // -------------------------------------------------------------
        // Etape 2 : Ajouter 3-4 LivrePapier et 2-3 LivreNumerique
        // -------------------------------------------------------------
        System.out.println("--- [2] Ajout des livres au catalogue ---");
        LivrePapier p1 = new LivrePapier(UUID.randomUUID(), "Les Miserables", "Victor Hugo", Genre.ROMAN, StatutLivre.DISPONIBLE, 1862, 3, "Rayon A1");
        LivrePapier p2 = new LivrePapier(UUID.randomUUID(), "Asterix le Gaulois", "Rene Goscinny", Genre.BD, StatutLivre.DISPONIBLE, 1961, 5, "Rayon B2");
        LivrePapier p3 = new LivrePapier(UUID.randomUUID(), "Le Petit Prince", "Antoine de Saint-Exupery", Genre.ROMAN, StatutLivre.DISPONIBLE, 1943, 2, "Rayon A2");
        LivrePapier p4 = new LivrePapier(UUID.randomUUID(), "Dune", "Frank Herbert", Genre.SCIENCE_FICTION, StatutLivre.DISPONIBLE, 1965, 4, "Rayon C3");

        LivreNumerique n1 = new LivreNumerique("Clean Code", "Robert C. Martin", Genre.ESSAI, StatutLivre.DISPONIBLE, 2008, 2.5, "PDF");
        LivreNumerique n2 = new LivreNumerique("One Piece Tome 1", "Eiichiro Oda", Genre.MANGA, StatutLivre.DISPONIBLE, 1997, 45.0, "EPUB");
        LivreNumerique n3 = new LivreNumerique("Fondation", "Isaac Asimov", Genre.SCIENCE_FICTION, StatutLivre.DISPONIBLE, 1951, 1.8, "EPUB");

        biblio.ajouterLivre(p1);
        biblio.ajouterLivre(p2);
        biblio.ajouterLivre(p3);
        biblio.ajouterLivre(p4);
        biblio.ajouterLivre(n1);
        biblio.ajouterLivre(n2);
        biblio.ajouterLivre(n3);
        System.out.println("7 livres ajoutes au catalogue.\n");

        // -------------------------------------------------------------
        // Etape 3 : Inscrire 2-3 Membres avec differents TypeAdhesion
        // -------------------------------------------------------------
        System.out.println("--- [3] Inscription des membres ---");
        Membre m1 = new Membre("Dupont", "Alice", TypeAdhesion.STANDARD, new ArrayList<>());   // Limite = 3
        Membre m2 = new Membre("Martin", "Bob", TypeAdhesion.ETUDIANT, new ArrayList<>());       // Limite = 5
        Membre m3 = new Membre("Bernard", "Claire", TypeAdhesion.PREMIUM, new ArrayList<>());   // Limite = 10

        biblio.inscrireMembre(m1);
        biblio.inscrireMembre(m2);
        biblio.inscrireMembre(m3);
        System.out.println("Membres inscrits : Alice (STANDARD - limite 3), Bob (ETUDIANT - limite 5), Claire (PREMIUM - limite 10).\n");

        // -------------------------------------------------------------
        // Etape 4 : Tester les emprunts et le declenchement des exceptions
        // -------------------------------------------------------------
        System.out.println("--- [4] Tests des emprunts et exceptions ---");

        // Emprunts normaux pour Alice jusqu'a sa limite (3 livres)
        try {
            biblio.emprunterLivre(p1.getId(), m1.getId());
            System.out.println("[OK] Alice a emprunte : " + p1.getTitre());
            
            biblio.emprunterLivre(p2.getId(), m1.getId());
            System.out.println("[OK] Alice a emprunte : " + p2.getTitre());
            
            biblio.emprunterLivre(p3.getId(), m1.getId());
            System.out.println("[OK] Alice a emprunte : " + p3.getTitre());
        } catch (LivreIndisponibleException | LimiteEmpruntAtteinteException e) {
            System.err.println("[ERREUR] " + e.getMessage());
        }

        // Test de LimiteEmpruntAtteinteException : Alice tente un 4eme emprunt
        System.out.println("\n-> Test Exception: Alice (limite 3) essaie d'emprunter un 4eme livre :");
        try {
            biblio.emprunterLivre(p4.getId(), m1.getId());
            System.out.println("[ANOMALIE] L'emprunt n'aurait pas du reussir !");
        } catch (LimiteEmpruntAtteinteException e) {
            System.out.println("[EXCEPTION ATTRAPEE COMME PREVU] " + e.getMessage());
        } catch (LivreIndisponibleException e) {
            System.out.println("[ERREUR INATTENDUE] " + e.getMessage());
        }

        // Test de LivreIndisponibleException : Bob essaie d'emprunter p1 (deja emprunte par Alice)
        System.out.println("\n-> Test Exception: Bob essaie d'emprunter 'Les Miserables' (deja emprunte) :");
        try {
            biblio.emprunterLivre(p1.getId(), m2.getId());
            System.out.println("[ANOMALIE] L'emprunt n'aurait pas du reussir !");
        } catch (LivreIndisponibleException e) {
            System.out.println("[EXCEPTION ATTRAPEE COMME PREVU] " + e.getMessage());
        } catch (LimiteEmpruntAtteinteException e) {
            System.out.println("[ERREUR INATTENDUE] " + e.getMessage());
        }

        // -------------------------------------------------------------
        // Etape 5 : Rendre un livre et reessayer un emprunt
        // -------------------------------------------------------------
        System.out.println("\n--- [5] Restitution d'un livre et nouvel emprunt ---");
        System.out.println("Alice rend : " + p1.getTitre());
        biblio.rendreLivre(p1.getId(), m1.getId());

        System.out.println("Alice retente d'emprunter 'Dune' (p4) maintenant qu'elle n'a que 2 emprunts :");
        try {
            biblio.emprunterLivre(p4.getId(), m1.getId());
            System.out.println("[OK] Emprunt reussi ! Alice a maintenant : " + p4.getTitre());
        } catch (LivreIndisponibleException | LimiteEmpruntAtteinteException e) {
            System.err.println("[ERREUR] " + e.getMessage());
        }

        // -------------------------------------------------------------
        // Etape 6 : Afficher le catalogue filtre
        // -------------------------------------------------------------
        System.out.println("\n--- [6] Recherches filtrees dans le catalogue ---");
        System.out.println("Livres du genre SCIENCE_FICTION :");
        for (Livre l : biblio.rechercherParGenre(Genre.SCIENCE_FICTION)) {
            System.out.println(" - " + l.getTitre() + " (" + l.getAuteur() + ") - Statut: " + l.getStatus());
        }

        System.out.println("\nLivres avec statut DISPONIBLE :");
        for (Livre l : biblio.rechercherParStatut(StatutLivre.DISPONIBLE)) {
            System.out.println(" - " + l.getTitre() + " [" + l.getStatus().getLibelleAffichage() + "]");
        }

        // -------------------------------------------------------------
        // Etape 7 : Afficher la liste des emprunts de chaque membre
        // -------------------------------------------------------------
        System.out.println("\n--- [7] Liste des emprunts en cours par membre ---");
        System.out.println("Emprunts d'Alice (" + m1.getLivresEmpruntes().size() + "/" + m1.getTypeAdhesion().getLimiteEmprunts() + ") :");
        for (Livre l : m1.getLivresEmpruntes()) {
            System.out.println(" -> " + l.getTitre() + " (" + l.getGenre() + ")");
        }

        System.out.println("\nEmprunts de Bob (" + m2.getLivresEmpruntes().size() + "/" + m2.getTypeAdhesion().getLimiteEmprunts() + ") :");
        if (m2.getLivresEmpruntes().isEmpty()) {
            System.out.println(" -> Aucun emprunt en cours.");
        } else {
            for (Livre l : m2.getLivresEmpruntes()) {
                System.out.println(" -> " + l.getTitre());
            }
        }

        System.out.println("\n=================================================");
        System.out.println("          FIN DU SCENARIO DE TEST                ");
        System.out.println("=================================================");
    }
}
