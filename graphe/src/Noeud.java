public class Noeud{

    private String nom;
    private List<Arc> adj;


    public Noeud(String n){
        this.nom = n;
        this.adj = new List<Arc>();
    }
}