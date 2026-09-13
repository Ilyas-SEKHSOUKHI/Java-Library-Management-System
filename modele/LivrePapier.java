// Sous-classes de Livre

/*
### `LivrePapier`
Ajoute un attribut `int nombreExemplaires` et un attribut `String emplacementRayon`.
`getDetails()` doit mentionner l'emplacement et le nombre d'exemplaires disponibles.
*/

import java.util.UUID;

/*
- `id` : `UUID`, généré via `UUID.randomUUID()` dans le constructeur, **jamais modifiable** (final, pas de setter)
- `titre`, `auteur` : `String`
- `genre` : `Genre`
- `statut` : `StatutLivre`
- `anneePublication` : `int`
*/
public class LivrePapier extends Livre{
    private int nombreExemplaires;
    private String emplacementRayon;
    public LivrePapier(){
        super();
        this.nombreExemplaires = 0;
        this.emplacementRayon = "unknow";
    }
    public LivrePapier(UUID id,String title,String auteur,Genre genre,StatutLivre livre,int anneePublication,int nombreExemplaires,String emplacementRayon){
        super(title,auteur,genre,livre,anneePublication);
        this.nombreExemplaires = nombreExemplaires;
        this.emplacementRayon = emplacementRayon;
    }
    public int getNombreExemplaires(){
        return nombreExemplaires;
    }
    public String getEmplacementRayon(){
        return emplacementRayon;
    }
    public void setNombreExemplaires(int nombreExemplaires){
        this.nombreExemplaires = nombreExemplaires;
    }
    public void setEmplacementRayon(String emplacementRayon){
        this.emplacementRayon = emplacementRayon;
    }
    @Override
    public String getDetails(){
        return "";
    }
    @Override
    public String toString(){ // A Continuer
        return "Id "+getId()+
                " titre "+getTitre()+
                " auteur "+getAuteur()+
                " genre "+getGenre()+
                " status "+getStatus()+
                " Annee Publication "+getAnneePublication()+
                " Nombre Exemplaires "+nombreExemplaires+
                " Emplacement Rayon "+emplacementRayon;
    }
}
