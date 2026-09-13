// Sous-classes de Livre

/*
### `LivreNumerique`
Ajoute un attribut `double tailleFichierMo` et un attribut `String format` (ex: "EPUB", "PDF").
`getDetails()` doit mentionner le format et la taille.
Un livre numérique n'a pas vraiment besoin de limiter les emprunts simultanés (il peut être "emprunté" par plusieurs membres à la fois)
— réfléchis si tu veux gérer ce cas particulier dans `emprunter()`.
*/

/*
## 4. Classe abstraite `Livre`
Attributs privés :
- `id` : `UUID`, généré via `UUID.randomUUID()` dans le constructeur, **jamais modifiable** (final, pas de setter)
- `titre`, `auteur` : `String`
- `genre` : `Genre`
- `statut` : `StatutLivre`
- `anneePublication` : `int`
*/
public class LivreNumerique extends Livre{
    private double tailleFichierMo;
    private String format;
    public LivreNumerique(){
        super();
        this.tailleFichierMo = 0.00;
        this.format = "unknow";
    }
    public LivreNumerique(String title,String auteur,Genre genre,StatutLivre status,int anneePublication,double tailleFichierMo,String format){
        super(title,auteur,genre,status,anneePublication);
        this.tailleFichierMo = tailleFichierMo;
        this.format = format;
    }
    public double getTailleFichierMo(){
        return tailleFichierMo;
    }
    public String getFormat(){
        return format;
    }
    public void setTailleFichierMo(double tailleFichierMo){
        this.tailleFichierMo = tailleFichierMo;
    }
    public void setFormat(String format){
        this.format = format;
    }
    @Override
    public String getDetails(){
        return "";
    }

    // toString
    // didnt work why ? => i dont know ( I get it i should use det method encapsulation things)
    @Override
    public String toString(){ // A Continuer
        return "Id "+getId()+
                " titre "+getTitre()+
                " auteur "+getAuteur()+
                " genre "+getGenre()+
                " status "+getStatus()+
                " Annee Publication "+getAnneePublication()+
                " tailleFichierMo "+tailleFichierMo+
                " Format "+format;
    }
}
