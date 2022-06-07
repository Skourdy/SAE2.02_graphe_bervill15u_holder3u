import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoeudTest {

    @Test
    void testEquals_True() {
        Noeud n1 = new Noeud("Test");
        Noeud n2 = new Noeud("Test");
        assertTrue(n1.equals(n2));

    }


    @Test
    void testEquals_False() {
        Noeud n1 = new Noeud("Test");
        Noeud n2 = new Noeud("PasUnTest");
        assertFalse(n1.equals(n2));

    }


    @Test
    void ajouterArc_True() {
        Noeud n1 = new Noeud("Test");
        String dest = "Destination";
        double cout = 2.1;

        n1.ajouterArc(dest,cout);
        Arc arc = new Arc(dest,cout);
        assertEquals(arc.getDest(),n1.getArc(0).getDest());
        assertEquals(arc.getCout(),n1.getArc(0).getCout());
    }

    @Test
    void ajouterArc_False() {
        Noeud n1 = new Noeud("Test");
        n1.ajouterArc("Destination",2.1);
        Arc arc = new Arc("PasLaBonne",1);

        assertNotEquals(arc.getDest(),n1.getArc(0).getDest());
        assertNotEquals(arc.getCout(),n1.getArc(0).getCout());
    }
}