import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void resoudreTest() throws IOException {
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        Dijkstra dj = new Dijkstra();
        Valeur val = dj.resoudre(gl,"1");
        assertEquals("""
                1 ->  V:0.0 p:Départ
                10 ->  V:21.0 p:5
                2 ->  V:4.0 p:1
                3 ->  V:13.0 p:2
                4 ->  V:15.0 p:1
                5 ->  V:12.0 p:2
                6 ->  V:24.0 p:9
                7 ->  V:20.0 p:4
                8 ->  V:18.0 p:9
                9 ->  V:16.0 p:3
                """,val.toString());
    }
}