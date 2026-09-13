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
        // [Marcus Sterling - Senior Java Architect]:
        // Tu as raison de douter : retourner directement 'livresEmpruntes' permet à n'importe quel code externe
        // de faire membre.getLivresEmpruntes().clear() et de modifier la liste en cachette.
        // Pour protéger ta collection (encapsulation défensive), utilise :
        // return new ArrayList<>(livresEmpruntes); // copie défensive
        // ou encore mieux : Collections.unmodifiableList(livresEmpruntes);
        return livresEmpruntes;                   // I should not do it like that
    }
    public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes){
        // [Marcus Sterling - Senior Java Architect]:
        // Conseil : En bonne pratique POO, supprime ce setter. Un membre ajoute ou retire des livres
        // un par un (via ajouterEmprunt/retirerEmprunt), on ne remplace jamais toute sa liste d'un coup.
        this.livresEmpruntes = livresEmpruntes;
    }

    // Method not completed
    public boolean peutEmprunter(){ // I should complete this method
        // [Marcus Sterling - Senior Java Architect]:
        // Si 'typeAdhesion.getLimiteEmprunts()' était en rouge, c'est tout simplement parce que dans
        // 'TypeAdhesion.java', il manquait le getter :
        // public int getLimiteEmprunts() { return limiteEmprunts; }
        // Dès que tu ajoutes ce getter dans TypeAdhesion, cette méthode fonctionnera parfaitement !
        // Tu pourras même la simplifier en une seule ligne :
        // return livresEmpruntes.size() < typeAdhesion.getLimiteEmprunts();
        if(livresEmpruntes.size() < typeAdhesion.getLimiteEmprunts()){ // how should i get getLimiteEmprunts()
           return true;
        }else{
            return false;
        }
    }

    // I should understand how to do it
    // [Marcus Sterling - Senior Java Architect]:
    // 1. Change la visibilité de 'private' à package-private (sans mot clé) ou 'public',
    //    sinon la classe Bibliotheque ne pourra pas y accéder !
    // 2. Écris : this.livresEmpruntes.add(livre);
    private void ajouterEmprunt(Livre livre){

    }
    // [Marcus Sterling - Senior Java Architect]:
    // 1. Change la visibilité de 'private' à package-private ou 'public'.
    // 2. Écris : this.livresEmpruntes.remove(livre);
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
