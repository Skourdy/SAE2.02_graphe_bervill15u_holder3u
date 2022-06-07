import java.util.List;

/**
 * Classe GrapheListe
 */
public class GrapheListe implements Graphe {
    //Attributs
    //Liste des noms des noeuds
    List<String> ensNom;
    //Liste des noeuds
    List<Noeud> ensNoeud;

    //Méthode listeNoeuds()
    //Retourne la liste des noms de noeuds
    @Override
    public List<String> listeNoeuds() {
        return ensNom;
    }


    /**
     * Méthode suivants(String n)
     * Retourne la liste des arcs partant du noeud n
     */
    @Override
    public List<Arc> suivants(String n) {
        return ensNoeud.get(ensNom.indexOf(n)).getAdj();
    }

    public void ajouterArc(String n1, String n2, double poids) {

    }
}
