import java.util.ArrayList;

/*
## 8. Classe `Bibliotheque` (le service central)
Attributs :
- `List<Livre> catalogue`
- `List<Membre> membres`

Méthodes obligatoires :
- `ajouterLivre(Livre livre)`
- `inscrireMembre(Membre membre)`
- `emprunterLivre(UUID idLivre, UUID idMembre) throws LivreIndisponibleException, LimiteEmpruntAtteinteException`
- `rendreLivre(UUID idLivre, UUID idMembre)`
- `rechercherParGenre(Genre genre)` → retourne une `List<Livre>` filtrée (tu peux utiliser les Streams Java : `catalogue.stream().filter(...).collect(...)`)
- `rechercherParStatut(StatutLivre statut)` → idem
- `afficherCatalogue()` → parcourt et affiche chaque livre en utilisant le polymorphisme (une seule boucle, `toString()` s'adapte au type réel de chaque objet)
*/
public class Bibliotheque {
    private ArrayList<Livre> catalogue;
    private ArrayList<Membre> membres;
    public Bibliotheque(){
        this.catalogue = new ArrayList<>();
        this.membres = new ArrayList<>();
    }
    public Bibliotheque(ArrayList<Livre> catalogue,ArrayList<Membre> membres){
        this.catalogue = catalogue;
        this.membres = membres;
    }
    public Bibliotheque(Bibliotheque other){
        this.catalogue = other.catalogue;
        this.membres = other.membres;
    }
    public ArrayList<Livre> getCatalogue(){
        return catalogue;
    }
    public ArrayList<Membre> getMembres(){
        return membres;
    }
    public void setCatalogue(ArrayList<Livre> catalogue){
        this.catalogue = catalogue;
    }
    public void setMembres(ArrayList<Membre> membres){
        this.membres = membres;
    }
    /* ******************************** */
    public void ajouterLivre(Livre livre){
        // I should now how can i do it
        // [Marcus Sterling - Senior Java Architect]:
        // Pour implémenter cette méthode sans changer la signature :
        // 1. (Optionnel mais recommandé) : Vérifie que le paramètre n'est pas null : if (livre != null)
        // 2. Ajoute le livre à la liste interne : this.catalogue.add(livre);
    }
    public void inscrireMembre(Membre membre){
        // I should now how can i do it
        // [Marcus Sterling - Senior Java Architect]:
        // Même principe ici :
        // 1. (Optionnel) : Vérifie if (membre != null)
        // 2. Ajoute le membre à la liste interne : this.membres.add(membre);
    }

    // I should complete bibliotheque methods , I still don't know how to do it
    /*
     * [Marcus Sterling - Senior Java Architect]:
     * Voici exactement la liste des méthodes manquantes obligatoires à ajouter ici,
     * avec le code à écrire pour chacune d'elles :
     *
     * ---------------------------------------------------------------------------------
     * 1. MÉTHODE UTILITAIRE (RECOMMANDÉE) : Trouver un livre par son UUID
     * ---------------------------------------------------------------------------------
     * public Livre trouverLivreParId(UUID idLivre) {
     *     return this.catalogue.stream()
     *         .filter(l -> l.getId().equals(idLivre))
     *         .findFirst()
     *         .orElse(null); // ou lever une exception si non trouvé
     * }
     *
     * ---------------------------------------------------------------------------------
     * 2. MÉTHODE UTILITAIRE (RECOMMANDÉE) : Trouver un membre par son UUID
     * ---------------------------------------------------------------------------------
     * public Membre trouverMembreParId(UUID idMembre) {
     *     return this.membres.stream()
     *         .filter(m -> m.getId().equals(idMembre))
     *         .findFirst()
     *         .orElse(null);
     * }
     *
     * ---------------------------------------------------------------------------------
     * 3. MÉTHODE : emprunterLivre
     * Signature obligatoire :
     * public void emprunterLivre(UUID idLivre, UUID idMembre)
     *         throws LivreIndisponibleException, LimiteEmpruntAtteinteException {
     *
     *     Livre livre = trouverLivreParId(idLivre);
     *     Membre membre = trouverMembreParId(idMembre);
     *
     *     if (livre == null || !livre.estDisponible()) {
     *         throw new LivreIndisponibleException("Le livre n'est pas disponible ou introuvable.");
     *     }
     *     if (membre == null || !membre.peutEmprunter()) {
     *         throw new LimiteEmpruntAtteinteException("Le membre a atteint sa limite maximale d'emprunts.");
     *     }
     *
     *     // Appliquer les changements d'état
     *     livre.emprunter(membre);
     *     membre.ajouterEmprunt(livre);
     * }
     *
     * ---------------------------------------------------------------------------------
     * 4. MÉTHODE : rendreLivre
     * Signature obligatoire :
     * public void rendreLivre(UUID idLivre, UUID idMembre) {
     *     Livre livre = trouverLivreParId(idLivre);
     *     Membre membre = trouverMembreParId(idMembre);
     *
     *     if (livre != null && membre != null) {
     *         livre.rendre();
     *         membre.retirerEmprunt(livre);
     *     }
     * }
     *
     * ---------------------------------------------------------------------------------
     * 5. MÉTHODE : rechercherParGenre (avec Java Streams)
     * Signature obligatoire :
     * public ArrayList<Livre> rechercherParGenre(Genre genre) {
     *     return this.catalogue.stream()
     *         .filter(livre -> livre.getGenre() == genre)
     *         .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
     * }
     *
     * ---------------------------------------------------------------------------------
     * 6. MÉTHODE : rechercherParStatut (avec Java Streams)
     * Signature obligatoire :
     * public ArrayList<Livre> rechercherParStatut(StatutLivre statut) {
     *     return this.catalogue.stream()
     *         .filter(livre -> livre.getStatus() == statut)
     *         .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
     * }
     *
     * ---------------------------------------------------------------------------------
     * 7. MÉTHODE : afficherCatalogue (Polymorphisme)
     * Signature obligatoire :
     * public void afficherCatalogue() {
     *     System.out.println("=== CATALOGUE DE LA BIBLIOTHEQUE ===");
     *     for (Livre livre : catalogue) {
     *         System.out.println(livre); // appelle automatiquement toString() adapté
     *     }
     * }
     */
}
