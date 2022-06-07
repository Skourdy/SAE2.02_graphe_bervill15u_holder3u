import java.util.ArrayList;
import java.util.List;

public class Noeud{

    private String nom;
    private final List<Arc> adj = new ArrayList<Arc>();


   // Constructeur
    public Noeud(String nom){
        this.nom = nom;
    }


    /**
     * Méthode equals()
     * @param o
     * @return
     */
    public boolean equals(Noeud o){
        return this.nom == o.getNom();
    }

    public void ajouterArc(String destination, double cout){
        Arc a = new Arc(destination,cout);
        adj.add(a);
    }



    public String getNom() {
        return nom;
    }

    public List<Arc> getAdj() {
        return adj;
    }
}