public enum TypeAdhesion {
    STANDARD(3),PREMIUM(10),ETUDIANT(5);
    private int limiteEmprunts;
    private TypeAdhesion(int limiteEmprunts){
        this.limiteEmprunts = limiteEmprunts;
    }
    // [Marcus Sterling - Senior Java Architect]:
    // C'est ce getter qui manquait pour Membre.peutEmprunter() ! Ajoute :
    // public int getLimiteEmprunts(){
    //     return this.limiteEmprunts;
    // }
}
