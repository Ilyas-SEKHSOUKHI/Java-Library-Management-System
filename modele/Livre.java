import java.util.UUID;
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
        this.genre = Genre.BD;
        this.status = StatutLivre.DISPONIBLE;
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

    public abstract String getDetails();

    @Override
    public void emprunter(Membre membre){
        this.status = StatutLivre.EMPRUNTE;
    }

    @Override
    public void rendre(){
        this.status = StatutLivre.DISPONIBLE;
    }

    @Override
    public boolean estDisponible(){
        return this.status == StatutLivre.DISPONIBLE;
    }

    @Override
    public String toString(){
        return "Id "+id+
                " titre "+titre+
                " auteur "+auteur+
                " genre "+genre+
                " status "+status+
                " Annee Publication "+anneePublication+
                " | "+getDetails();
    }
}
