import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValeurTest {


    @Test
    void calculerCheminTest() throws IOException {
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gl,"1");
        List<String> chemin = v.calculerChemin("10");
        assertEquals("[5, 2, 1, Départ]",chemin.toString());
    }
}