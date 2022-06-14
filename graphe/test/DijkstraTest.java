import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void resoudreTest() throws IOException {
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        Dijkstra dj = new Dijkstra();
        Valeur val = dj.resoudre(gl,"1");
        assertEquals("1 ->  V:0.0 p:Départ\n" +
                "10 ->  V:21.0 p:5\n" +
                "2 ->  V:4.0 p:1\n" +
                "3 ->  V:13.0 p:2\n" +
                "4 ->  V:15.0 p:1\n" +
                "5 ->  V:12.0 p:2\n" +
                "6 ->  V:24.0 p:9\n" +
                "7 ->  V:20.0 p:4\n" +
                "8 ->  V:18.0 p:9\n" +
                "9 ->  V:16.0 p:3\n",val.toString());
    }

    @Test
    void calculerCheminTest() throws IOException {
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        Dijkstra dj = new Dijkstra();
        dj.resoudre(gl,"1");
        List<String> chemin = dj.calculerChemin("4");
        assertEquals("[1, Départ]",chemin.toString());
    }

}