import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {

        //GrapheListe gl = new GrapheListe("Graphes/Graphe905.txt");
        GrapheListe gl = new GrapheListe(10,"1","2");
        BellmanFord bf = new BellmanFord();
        System.out.println(gl.toGraphViz());
        System.out.println(bf.resoudre(gl,"1"));

    }

    public static void maina(String[] args) throws IOException {

        GrapheListe gl = new GrapheListe("Graphes/Graphe905.txt");
        Dijkstra dj = new Dijkstra();
        System.out.println(dj.resoudre(gl,"1"));

    }
}
