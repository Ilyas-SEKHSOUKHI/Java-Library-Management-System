public enum StatutLivre {
    // [Marcus Sterling - Senior Java Architect]:
    // Pour que chaque statut ait son propre libellé au lieu d'avoir "Disponible à l'emprunt" partout,
    // passe la valeur entre parenthèses comme ceci :
    // DISPONIBLE("Disponible à l'emprunt"),
    // EMPRUNTE("Actuellement emprunté"),
    // PERDU("Déclaré perdu"),
    // EN_REPARATION("En cours de réparation");
    DISPONIBLE,EMPRUNTE,PERDU,EN_REPARATION;
    private String libelleAffichage;
    // [Marcus Sterling - Senior Java Architect]:
    // Et change le constructeur pour accepter le paramètre :
    // private StatutLivre(String libelleAffichage) {
    //     this.libelleAffichage = libelleAffichage;
    // }
    private StatutLivre(){
        this.libelleAffichage = "Disponible à l'emprunt";
    }
    public String getLibelleAffichage(){
        return libelleAffichage;
    }
}
