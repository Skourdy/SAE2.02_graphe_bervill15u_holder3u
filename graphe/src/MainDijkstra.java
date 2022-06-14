import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {

        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");

        Dijkstra dj = new Dijkstra();
        BellmanFord bf = new BellmanFord();

        Valeur vBell = bf.resoudre(gl,"4");
        Valeur vDij = dj.resoudre(gl,"4");

        System.out.println("BellmanFord");
        System.out.println(vBell);
        System.out.println("\n Dijkstra");
        System.out.println(vDij);
    }
}
