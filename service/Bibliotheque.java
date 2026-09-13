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
    }
    public void inscrireMembre(Membre membre){
        // I should now how can i do it
    }

    // I should complete bibliotheque methods , I still don't know how to do it
}
