import java.util.ArrayList;
import java.util.UUID;

/*
## 6. Classe `Membre`
Attributs privés :
- `id` : `UUID`
- `nom`, `prenom` : `String`
- `typeAdhesion` : `TypeAdhesion`
- `livresEmpruntes` : une `List<Livre>` (utilise `ArrayList` en interne)

Méthodes :
- Constructeur classique
- `getLivresEmpruntes()` doit retourner une **copie non modifiable** de la liste (`Collections.unmodifiableList(...)` ou une copie défensive) — ne jamais retourner la référence interne directement. C'est un point d'encapsulation important en Java.
- `peutEmprunter()` : retourne `true` si `livresEmpruntes.size() < typeAdhesion.getLimiteEmprunts()`
- `ajouterEmprunt(Livre livre)` et `retirerEmprunt(Livre livre)` (package-private ou appelées uniquement depuis `Bibliotheque`, à toi de décider de la visibilité)
- `toString()` redéfini
*/
public class Membre {
    private UUID id;
    private String nom;
    private String prenom;
    private TypeAdhesion typeAdhesion;
    private ArrayList<Livre> livresEmpruntes;

    public Membre(){
        this.id = UUID.randomUUID();
        this.nom = "unknow";
        this.prenom = "unknow";
        this.typeAdhesion = TypeAdhesion.valueOf("unknow");
        this.livresEmpruntes = new ArrayList<>();
    }
    public Membre(String nom,String prenom,TypeAdhesion typeAdhesion,ArrayList<Livre> livresEmpruntes){
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.prenom = prenom;
        this.typeAdhesion = typeAdhesion;
        this.livresEmpruntes = new ArrayList<>(livresEmpruntes);
    }
    public Membre(Membre other){
        this.id = UUID.randomUUID();
        this.nom = other.nom;
        this.prenom = other.prenom;
        this.typeAdhesion = other.typeAdhesion;
        this.livresEmpruntes = new ArrayList<>(other.livresEmpruntes);
    }

    public UUID getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public TypeAdhesion getTypeAdhesion(){
        return typeAdhesion;
    }
    public void setTypeAdhesion(TypeAdhesion typeAdhesion){
        this.typeAdhesion = typeAdhesion;
    }
    public ArrayList<Livre> getLivresEmpruntes(){ // I Think it will not work
        return livresEmpruntes;                   // I should not do it like that
    }
    public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes){
        this.livresEmpruntes = livresEmpruntes;
    }

    // Method not completed
    public boolean peutEmprunter(){ // I should complete this method
        if(livresEmpruntes.size() < typeAdhesion.getLimiteEmprunts()){ // how should i get getLimiteEmprunts()
           return true;
        }else{
            return false;
        }
    }

    // I should understand how to do it
    private void ajouterEmprunt(Livre livre){

    }
    private void retirerEmprunt(Livre livre){

    }

    //toString
    @Override
    public String toString(){
        return "Id "+id+
                " Nom "+nom+
                " Prenom "+prenom+
                " TypeAdhesion "+typeAdhesion+
                " LivresEmpruntes "+livresEmpruntes;
    }
}
