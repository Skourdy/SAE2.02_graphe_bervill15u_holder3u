import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {


    @Test
    void test_suivants() {
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
        List<Arc> arcs = n1.getAdj();

        GrapheListe lg = new GrapheListe(noms,noeudsL);
        List<Arc> suivants = lg.suivants("A");

        assertEquals(arcs.get(0).getDest(),suivants.get(0).getDest());
        assertEquals(arcs.get(1).getDest(),suivants.get(1).getDest());
        assertEquals(arcs.get(2).getDest(),suivants.get(2).getDest());
    }


    @Test
    void ajouterArc() throws IOException {
        List<String> noms = new ArrayList<>();

        noms.add("B");
        noms.add("C");
        noms.add("E");

        List<Noeud> noeudsL = new ArrayList<Noeud>();
        Noeud n1 = new Noeud("B");
        n1.ajouterArc("C",1);
        noeudsL.add(n1);

        GrapheListe lg = new GrapheListe(noms,noeudsL);
        lg.ajouterArc("B","E",2);

        assertEquals("E",lg.getEnsNoeud().get(0).getArc(1).getDest());
        assertEquals(2,lg.getEnsNoeud().get(0).getArc(1).getCout());
    }


    @Test
    void ajouterArc_creationArc() throws IOException {
        List<String> noms = new ArrayList<>();

        noms.add("B");
        noms.add("C");
        noms.add("E");

        List<Noeud> noeudsL = new ArrayList<Noeud>();
        Noeud n1 = new Noeud("B");
        n1.ajouterArc("C",1);
        noeudsL.add(n1);

        GrapheListe lg = new GrapheListe(noms,noeudsL);
        lg.ajouterArc("B","A",2);

        assertEquals("A",lg.listeNoeuds().get(3));
    }
}