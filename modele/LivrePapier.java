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
        return "Rayon: " + emplacementRayon + " (" + nombreExemplaires + " exemplaires disponibles)";
    }
}
