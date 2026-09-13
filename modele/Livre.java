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
        // [Marcus Sterling - Senior Java Architect]:
        // ATTENTION : Genre.valueOf("unknow") va faire crasher ton programme avec IllegalArgumentException !
        // 'valueOf' cherche le nom exact d'une constante déclarée dans l'enum. Comme "unknow" n'existe pas,
        // ça explose à l'exécution.
        // Solution : Mets une constante existante par défaut (ex: Genre.ROMAN) ou supprime ce constructeur vide.
        this.genre = Genre.BD; // I should know what should valueOf() do
        // [Marcus Sterling - Senior Java Architect]:
        // Idem ici : StatutLivre.valueOf("unknow") va crasher. Mets plutôt : this.status = StatutLivre.DISPONIBLE;
        this.status = StatutLivre.DISPONIBLE; // same
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
    // [Marcus Sterling - Senior Java Architect]:
    // 'Membre' est la classe Membre.java située dans le même dossier.
    // Dans le corps de cette méthode, pour emprunter :
    // this.status = StatutLivre.EMPRUNTE;
    public void emprunter(Membre membre){ // where is Menbre type should i created
        this.status = StatutLivre.EMPRUNTE;
    }
    // [Marcus Sterling - Senior Java Architect]:
    // Pour rendre le livre :
    // this.status = StatutLivre.DISPONIBLE;
    public void rendre(){
        this.status = StatutLivre.DISPONIBLE;
    }
    // [Marcus Sterling - Senior Java Architect]:
    // Un livre est disponible si son statut est StatutLivre.DISPONIBLE :
    // return this.status == StatutLivre.DISPONIBLE;
    public boolean estDisponible(){
        return this.status == StatutLivre.DISPONIBLE;
    }

    // toString
    // [Marcus Sterling - Senior Java Architect]:
    // Pour exploiter le polymorphisme, Livre.toString() doit appeler getDetails() :
    // return "Id: " + id + ", Titre: " + titre + ", Auteur: " + auteur + ", Genre: " + genre +
    //        ", Statut: " + status + ", Année: " + anneePublication + " | " + getDetails();
    @Override
    public String toString(){ // A Continuer
        return "Id "+id+
                " titre "+titre+
                " auteur "+auteur+
                " genre "+genre+
                " status "+status+
                " Annee Publication "+anneePublication+
                " | "+getDetails();
    }
}
