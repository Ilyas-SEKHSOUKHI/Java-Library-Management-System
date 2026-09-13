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
        return "Format: " + format + ", Taille: " + tailleFichierMo + " Mo";
    }
}
