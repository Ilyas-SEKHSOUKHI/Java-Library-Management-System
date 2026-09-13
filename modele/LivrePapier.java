// Sous-classes de Livre

/*
### `LivrePapier`
Ajoute un attribut `int nombreExemplaires` et un attribut `String emplacementRayon`.
`getDetails()` doit mentionner l'emplacement et le nombre d'exemplaires disponibles.
*/

import java.util.UUID;
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
        // [Marcus Sterling - Senior Java Architect]:
        // Remplis cette méthode avec les détails spécifiques de l'ouvrage papier :
        // return "Rayon: " + emplacementRayon + " (" + nombreExemplaires + " exemplaires disponibles)";
        return "Rayon: " + emplacementRayon + " (" + nombreExemplaires + " exemplaires disponibles)";
    }
    // [Marcus Sterling - Senior Java Architect]:
    // Comme pour LivreNumerique, tu peux supprimer ce toString() :
    // Livre.toString() va automatiquement appeler getDetails() pour formater les détails du papier !
    /*@Override
    public String toString(){ // A Continuer
        return "Id "+getId()+
                " titre "+getTitre()+
                " auteur "+getAuteur()+
                " genre "+getGenre()+
                " status "+getStatus()+
                " Annee Publication "+getAnneePublication()+
                " Nombre Exemplaires "+nombreExemplaires+
                " Emplacement Rayon "+emplacementRayon;
    }*/
}
