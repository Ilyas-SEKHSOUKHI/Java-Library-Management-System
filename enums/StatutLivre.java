public enum StatutLivre {
    DISPONIBLE,EMPRUNTE,PERDU,EN_REPARATION;
    private String libelleAffichage;
    private StatutLivre(){
        this.libelleAffichage = "Disponible à l'emprunt";
    }
    public String getLibelleAffichage(){
        return libelleAffichage;
    }
}
