import java.util.ArrayList;
import java.util.UUID;

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
        this.typeAdhesion = TypeAdhesion.STANDARD;
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
    public ArrayList<Livre> getLivresEmpruntes(){
        return new ArrayList<>(livresEmpruntes);
    }

    public boolean peutEmprunter(){
        if(livresEmpruntes.size() < typeAdhesion.getLimiteEmprunts()){
           return true;
        }else{
            return false;
        }
    }

    public void ajouterEmprunt(Livre livre){
        this.livresEmpruntes.add(livre);
    }

    public void retirerEmprunt(Livre livre){
        this.livresEmpruntes.remove(livre);
    }

    @Override
    public String toString(){
        return "Id "+id+
                " Nom "+nom+
                " Prenom "+prenom+
                " TypeAdhesion "+typeAdhesion+
                " LivresEmpruntes "+livresEmpruntes;
    }
}
