import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Classe fournie, permet de stocker des valeurs associées au nœud et des parents
 * - un nœud est représenté par un String (son nom)
 * - on accède avec des gets (getValeur et getParent)
 * - on modifie avec des sets (setValeur et setParent)
 */
public class Valeur {

    /**
     * attributs pour stocker les informations (type Table = Dictionnaire)
     * dans le programme de 2 annee.
     */
    Map<String, Double> valeur;
    Map<String, String> parent;

    /**
     * constructeur vide (initialise la possibilité de stocker des valeurs)
     */
    public Valeur() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * permet d'associer une valeur a un nom de noeud (ici L(X))
     *
     * @param nom    le nom du nœud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        // modifie valeur
        this.valeur.put(nom, valeur);
    }

    /**
     * * permet d'associer un parent a un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du nœud parent associe
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * accede au parent stocke associe au nœud nom passe en paramètre
     *
     * @param nom nom du noeud
     * @return le nom du nœud parent
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }


    /**
     * accede a la valeur associée au nœud nom passe en paramètre
     *
     * @param nom nom du noeud
     * @return la valeur stockée
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * retourne une chaine qui affiche le contenu
     * - par nœud stocke
     * - a chaque nœud, affiche la valeur puis le nœud parent
     *
     * @return descriptif du nœud
     */
    public String toString() {
        String res = "";
        // pour chaque nœud
        for (String s : this.valeur.keySet()) {
            // ajoute la valeur et le nœud parent
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;

    }
    public List<String> calculerChemin(String destination) {
        List<String> chemin = new ArrayList<>();
        String parentActuel = this.parent.get(destination);
        chemin.add(parentActuel);
        while (!parentActuel.equals("Départ")) {
            parentActuel = this.parent.get(parentActuel);
            chemin.add(parentActuel);
        }
        return chemin;
    }

}