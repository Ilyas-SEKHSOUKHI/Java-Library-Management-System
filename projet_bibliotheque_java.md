# Projet Java — Système de gestion de bibliothèque

Instructions complètes, pensées spécifiquement pour Java. Aucun code fourni : à toi d'écrire les classes. Respecte les conventions Java (nommage PascalCase pour les classes, camelCase pour les méthodes/attributs, un fichier `.java` par classe publique).

---

## 1. Organisation du projet
Crée un package `bibliotheque` (ou `com.tonnom.bibliotheque`) avec, si tu veux structurer proprement, des sous-packages :
- `bibliotheque.modele` → tes classes métier (Livre, Membre, etc.)
- `bibliotheque.enums` → tes enums
- `bibliotheque.exceptions` → tes exceptions personnalisées
- `bibliotheque.service` → la classe `Bibliotheque` qui orchestre tout
- `bibliotheque.app` → la classe `Main` avec la méthode `public static void main(String[] args)`

---

## 2. Enums à créer

### `Genre`
Valeurs : `ROMAN`, `BD`, `ESSAI`, `MANGA`, `SCIENCE_FICTION`.

### `StatutLivre`
Valeurs : `DISPONIBLE`, `EMPRUNTE`, `PERDU`, `EN_REPARATION`.
Donne à cet enum un **constructeur privé** avec un attribut `String libelleAffichage` (ex: "Disponible à l'emprunt") et une méthode `getLibelleAffichage()`. C'est une bonne occasion de pratiquer les enums "riches" en Java (les enums peuvent avoir des attributs, constructeurs et méthodes comme des classes normales).

### `TypeAdhesion`
Valeurs : `STANDARD`, `PREMIUM`, `ETUDIANT`, chacune avec un attribut `int limiteEmprunts` défini dans le constructeur de l'enum (ex: STANDARD=3, PREMIUM=10, ETUDIANT=5).

---

## 3. Interface `Empruntable`
Déclare une interface Java `Empruntable` avec les méthodes abstraites :
- `void emprunter(Membre membre)`
- `void rendre()`
- `boolean estDisponible()`

Rappel Java : une interface peut aussi avoir des méthodes `default` — tu peux par exemple ajouter une méthode `default` `afficherStatut()` qui appelle `estDisponible()`.

---

## 4. Classe abstraite `Livre`
Attributs privés :
- `id` : `UUID`, généré via `UUID.randomUUID()` dans le constructeur, **jamais modifiable** (final, pas de setter)
- `titre`, `auteur` : `String`
- `genre` : `Genre`
- `statut` : `StatutLivre`
- `anneePublication` : `int`

Doit **implémenter `Empruntable`** et déclarer une méthode abstraite `String getDetails()`.

Fournis :
- Un constructeur qui prend titre, auteur, genre, année (le statut démarre à `DISPONIBLE`, l'id est généré automatiquement)
- Getters pour tout, setter uniquement pour `statut`
- Redéfinition de `toString()` qui utilise `getDetails()` en interne (polymorphisme : `toString()` de la classe mère appelle une méthode que chaque sous-classe redéfinit différemment)
- Redéfinition de `equals()` et `hashCode()` basée sur `id` (deux livres sont égaux si et seulement si leur UUID est identique) — bonne pratique Java quand on stocke des objets dans des `Set` ou des `Map`

---

## 5. Sous-classes de `Livre`

### `LivrePapier`
Ajoute un attribut `int nombreExemplaires` et un attribut `String emplacementRayon`.
`getDetails()` doit mentionner l'emplacement et le nombre d'exemplaires disponibles.

### `LivreNumerique`
Ajoute un attribut `double tailleFichierMo` et un attribut `String format` (ex: "EPUB", "PDF").
`getDetails()` doit mentionner le format et la taille.
Un livre numérique n'a pas vraiment besoin de limiter les emprunts simultanés (il peut être "emprunté" par plusieurs membres à la fois) — réfléchis si tu veux gérer ce cas particulier dans `emprunter()`.

---

## 6. Classe `Membre`
Attributs privés :
- `id` : `UUID`
- `nom`, `prenom` : `String`
- `typeAdhesion` : `TypeAdhesion`
- `livresEmpruntes` : une `List<Livre>` (utilise `ArrayList` en interne)

Méthodes :
- Constructeur classique
- `getLivresEmpruntes()` doit retourner une **copie non modifiable** de la liste (`Collections.unmodifiableList(...)` ou une copie défensive) — ne jamais retourner la référence interne directement. C'est un point d'encapsulation important en Java.
- `peutEmprunter()` : retourne `true` si `livresEmpruntes.size() < typeAdhesion.getLimiteEmprunts()`
- `ajouterEmprunt(Livre livre)` et `retirerEmprunt(Livre livre)` (package-private ou appelées uniquement depuis `Bibliotheque`, à toi de décider de la visibilité)
- `toString()` redéfini

---

## 7. Exceptions personnalisées
Crée au moins deux exceptions qui héritent de `Exception` (checked) ou `RuntimeException` (unchecked), à toi de choisir et de justifier :
- `LimiteEmpruntAtteinteException`
- `LivreIndisponibleException`

Elles doivent être levées (`throw`) dans `Bibliotheque.emprunterLivre(...)` selon les cas, et avoir un constructeur qui prend un message descriptif.

---

## 8. Classe `Bibliotheque` (le service central)
Attributs :
- `List<Livre> catalogue`
- `List<Membre> membres`

Méthodes obligatoires :
- `ajouterLivre(Livre livre)`
- `inscrireMembre(Membre membre)`
- `emprunterLivre(UUID idLivre, UUID idMembre) throws LivreIndisponibleException, LimiteEmpruntAtteinteException`
- `rendreLivre(UUID idLivre, UUID idMembre)`
- `rechercherParGenre(Genre genre)` → retourne une `List<Livre>` filtrée (tu peux utiliser les Streams Java : `catalogue.stream().filter(...).collect(...)`)
- `rechercherParStatut(StatutLivre statut)` → idem
- `afficherCatalogue()` → parcourt et affiche chaque livre en utilisant le polymorphisme (une seule boucle, `toString()` s'adapte au type réel de chaque objet)

---

## 9. Classe `Main`
Écris un scénario de test qui :
1. Crée une `Bibliotheque`
2. Ajoute 3-4 `LivrePapier` et 2-3 `LivreNumerique`
3. Inscrit 2-3 `Membre` avec des types d'adhésion différents
4. Fait emprunter des livres jusqu'à ce qu'un membre atteigne sa limite (vérifie que l'exception est bien levée et attrapée avec `try/catch`)
5. Fait rendre un livre puis réessaie un emprunt qui échouait avant
6. Affiche le catalogue filtré par genre, puis par statut
7. Affiche la liste des emprunts en cours de chaque membre

---

## 10. Points d'attention spécifiques à Java (auto-vérification)
Une fois que tu as codé, vérifie que tu as bien :
- [ ] Utilisé `private` par défaut pour tous les attributs, jamais `public`
- [ ] Utilisé `@Override` sur chaque méthode redéfinie (`toString`, `equals`, `hashCode`, méthodes d'interface)
- [ ] Évité de retourner directement une référence à une collection mutable interne
- [ ] Utilisé `UUID.randomUUID()` uniquement dans le constructeur, jamais recalculé ailleurs
- [ ] Choisi correctement entre classe abstraite (`Livre`) et interface (`Empruntable`) — sais-tu expliquer pourquoi l'un plutôt que l'autre ici ?
- [ ] Une exception checked oblige l'appelant à gérer le cas avec `try/catch` ou `throws` — a-t-il du sens de rendre tes exceptions checked ou unchecked dans ce contexte ?

Pas de correction fournie : si tu bloques sur un point précis (par exemple la gestion des exceptions ou les Streams), dis-le moi et je t'oriente sans te donner la solution complète.
