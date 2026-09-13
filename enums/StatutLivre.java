public enum StatutLivre {
    DISPONIBLE("Disponible à l'emprunt"),
    EMPRUNTE("Actuellement emprunté"),
    PERDU("Déclaré perdu"),
    EN_REPARATION("En cours de réparation");

    private String libelleAffichage;

    private StatutLivre(String libelleAffichage) {
         this.libelleAffichage = libelleAffichage;
    }
    public String getLibelleAffichage(){
        return libelleAffichage;
    }
}
