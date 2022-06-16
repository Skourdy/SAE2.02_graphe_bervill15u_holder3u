import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {

        GrapheListe gl = new GrapheListe("Graphes/Graphe905.txt");
        //GrapheListe gl = new GrapheListe(100,"1","2");
        Dijkstra dj = new Dijkstra();
        Valeur v = dj.resoudre(gl,"1");
        System.out.println(v);
        System.out.println(v.calculerChemin("4"));

    }
}
