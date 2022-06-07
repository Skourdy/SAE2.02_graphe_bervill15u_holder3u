import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {


    @Test
    void suivants() {
        List<String> noms = new ArrayList<>();
        noms.add("A");
        noms.add("B");
        noms.add("C");
        noms.add("E");

        List<Noeud> noeudsL = new ArrayList<Noeud>();
        Noeud n1 = new Noeud("A");
        n1.ajouterArc("B",1);
        n1.ajouterArc("C",2);
        n1.ajouterArc("E",3);
        noeudsL.add(n1);
    }

    @Test
    void ajouterArc() {
    }
}