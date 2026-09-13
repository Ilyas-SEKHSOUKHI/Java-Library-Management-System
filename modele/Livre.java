import java.util.UUID;

/*
## 4. Classe abstraite `Livre`
Attributs privés :
- `id` : `UUID`, généré via `UUID.randomUUID()` dans le constructeur, **jamais modifiable** (final, pas de setter)
- `titre`, `auteur` : `String`
- `genre` : `Genre`
- `statut` : `StatutLivre`
- `anneePublication` : `int`

Doit **implémenter `Empruntable`** et déclarer une méthode abstraite `String getDetails()`.

Fournis :
- Un constructeur qui prend titre, auteur, genre, année (le statut démarre à `DISPONIBLE`, l'id est généré automatiquement)
- Getters pour tout, setter uniquement pour `statut`
- Redéfinition de `toString()` qui utilise `getDetails()` en interne (polymorphisme : `toString()` de la classe mère appelle une méthode que chaque sous-classe redéfinit différemment)
- Redéfinition de `equals()` et `hashCode()` basée sur `id` (deux livres sont égaux si et seulement si leur UUID est identique) — bonne pratique Java quand on stocke des objets dans des `Set` ou des `Map`
*/
public abstract class Livre implements Empruntable {
    private UUID id;
    private String titre;
    private String auteur;
    private Genre genre;
    private StatutLivre status;
    private int anneePublication;
    public Livre(){
        this.id = UUID.randomUUID();
        this.titre = "unknow";
        this.auteur = "unknow";
        this.genre = Genre.valueOf("unknow"); // I should know what should valueOf() do
        this.status = StatutLivre.valueOf("unknow"); // same
        this.anneePublication = 0;

    }
    public Livre(String title,String auteur,Genre genre,StatutLivre status,int anneePublication){
        this.id = UUID.randomUUID();
        this.titre = title;
        this.auteur = auteur;
        this.genre = genre;
        this.status = status;
        this.anneePublication = anneePublication;
    }
    public Livre(Livre other){
        this.id = UUID.randomUUID();
        this.titre = other.titre;
        this.auteur = other.auteur;
        this.genre = other.genre;
        this.status = other.status;
        this.anneePublication = other.anneePublication;
    }
    public UUID getId(){
        return id;
    }
    public String getTitre(){
        return titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public Genre getGenre(){
        return genre;
    }
    public StatutLivre getStatus(){
        return status;
    }
    public int getAnneePublication(){
        return anneePublication;
    }
    public void setStatus(StatutLivre status){
        this.status = status;
    }

    // Method Abstract
    public abstract String getDetails();

    // Method Implemented from Empruntable
    public void emprunter(Membre membre){ // where is Menbre type should i created

    }
    public void rendre(){

    }
    public boolean estDisponible(){
        return false;
    }

    // toString
    @Override
    public String toString(){ // A Continuer
        return "Id "+id+
                " titre "+titre+
                " auteur "+auteur+
                " genre "+genre+
                " status "+status+
                " Annee Publication "+anneePublication;
    }
}
