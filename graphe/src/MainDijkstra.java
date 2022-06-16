import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {

        //GrapheListe gl = new GrapheListe("Graphes/Graphe905.txt");
        GrapheListe gl = new GrapheListe(100,"1","2");
        BellmanFord bf = new BellmanFord();
        Dijkstra dj = new Dijkstra();
        bf.resoudre(gl,"1");
        dj.resoudre(gl,"1");

    }
}
