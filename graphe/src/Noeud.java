import java.util.List;

public class Noeud{

    private String nom;
    private List adj;


   // Constructeur
    public Noeud(String nom){
        this.nom = nom;
        this.adj = new List<Arc>();
    }

    public boolean equals(Noeud o){
        if (this.nom == o.getNom()){
            return true;
        }
        else return false;
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