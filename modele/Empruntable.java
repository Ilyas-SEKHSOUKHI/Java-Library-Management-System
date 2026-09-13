/*
## 3. Interface `Empruntable`
Déclare une interface Java `Empruntable` avec les méthodes abstraites :
- `void emprunter(Membre membre)`
- `void rendre()`
- `boolean estDisponible()`

Rappel Java : une interface peut aussi avoir des méthodes `default` — tu peux par exemple ajouter une méthode `default` `afficherStatut()` qui appelle `estDisponible()`.

*/

public interface Empruntable {
    public void emprunter(Membre membre); // where is Menbre type should i created
    public void rendre();
    public boolean estDisponible();
}
