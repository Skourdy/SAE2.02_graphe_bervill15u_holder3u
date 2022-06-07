import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<String> nom = new ArrayList<String>();
        nom.add("A");
        nom.add("B");
        nom.add("C");
        nom.add("D");
        nom.add("E");

        List<Noeud> noeuds = new ArrayList<>();
        Noeud nA = new Noeud("A");
        nA.ajouterArc("B",12);
        nA.ajouterArc("D",87);
        noeuds.add(nA);

        Noeud nB = new Noeud("B");
        nB.ajouterArc("E",11);
        noeuds.add(nB);

        Noeud nC = new Noeud("C");
        nC.ajouterArc("A",);


        GrapheListe lg = new GrapheListe(nom,noeuds);
    }
}