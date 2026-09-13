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
        // [Marcus Sterling - Senior Java Architect]:
        // C'est ici que tu dois renvoyer les spécificités du livre numérique :
        // return "Format: " + format + ", Taille: " + tailleFichierMo + " Mo";
        return "Format: " + format + ", Taille: " + tailleFichierMo + " Mo";
    }

    // toString
    // didnt work why ? => i dont know ( I get it i should use det method encapsulation things)
    // [Marcus Sterling - Senior Java Architect]:
    // Pourquoi ça ne marchait pas directement : les attributs de la classe mère Livre (titre, auteur, etc.)
    // sont déclarés 'private', donc invisibles pour les sous-classes. C'est la règle d'encapsulation de Java.
    //
    // ASTUCE SENIOR : Tu n'as même PAS besoin de redéfinir toString() ici !
    // Si tu supprimes ce toString() de LivreNumerique et que tu laisses Livre.toString() appeler getDetails(),
    // Java appellera automatiquement le getDetails() ci-dessus quand tu affiches un LivreNumerique !

    /*@Override
    public String toString(){ // A Continuer
        return "Id "+getId()+
                " titre "+getTitre()+
                " auteur "+getAuteur()+
                " genre "+getGenre()+
                " status "+getStatus()+
                " Annee Publication "+getAnneePublication()+
                " tailleFichierMo "+tailleFichierMo+
                " Format "+format;
    }*/
}
