public class Noeud{

    private String nom;
    private List<Arc> adj;


    public Noeud(String n){
        this.nom = n;
        this.adj = new List<Arc>();
    }

    public boolean equals(Object o){
        if (this.nom == (Noeud)o.getNom()){
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