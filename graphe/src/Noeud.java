import java.util.ArrayList;
import java.util.List;

public class Noeud{

    //Nom du Nœud
    private final String nom;
    //Liste des arcs du nœud
    private final List<Arc> adj = new ArrayList<>();


   // Constructeur par défaut
    public Noeud(String nom){
        this.nom = nom;
    }

    /**
     * Méthode equals()
     * Compare le nom du nœud donné à celui de la classe
     * @param o : Noeud
     * @return boolean
     */
    public boolean equals(Noeud o){
        return this.nom.equals(o.getNom());
    }

    /**
     * Méthode ajouterArc()
     * Permet d'ajouter un Arc au noeud
     * @param destination : le nœud
     * @param cout : le cout
     */
    public void ajouterArc(String destination, double cout){
        adj.add(new Arc(destination,cout));
    }

    /*
    GETTER
     */

    public String getNom() {
        return nom;
    }
    public List<Arc> getAdj() {
        return adj;
    }
    public Arc getArc(int index){return adj.get(index);}
}