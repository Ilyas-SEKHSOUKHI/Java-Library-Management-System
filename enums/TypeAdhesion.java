public enum TypeAdhesion {
    STANDARD(3),PREMIUM(10),ETUDIANT(5);
    private int limiteEmprunts;
    private TypeAdhesion(int limiteEmprunts){
        this.limiteEmprunts = limiteEmprunts;
    }

    public int getLimiteEmprunts(){
         return this.limiteEmprunts;
    }
}
