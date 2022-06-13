import java.util.List;

public class BellmanFord {


    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();


        List<String> listeDesNoms = g.listeNoeuds();
        int size = listeDesNoms.size();

        for (int i = 0; i < size; i++) {
            String nomI = listeDesNoms.get(i);
            v.setValeur(nomI, Double.MAX_VALUE);
            v.setParent(nomI, null);
        }

        v.setValeur(depart, 0);
        v.setParent(depart, "Départ");

        // pour tous les noeuds
        for (int k = 0; k < size; k++) {

            // tous les successeurs du noeud k
            List<Arc> lArc = g.suivants(listeDesNoms.get(k));
            for (Arc value : lArc) {


                String nomActuel = listeDesNoms.get(k);
                String parentK = v.getParent(nomActuel);
                double valeurK = v.getValeur(nomActuel);

                String destArc = value.getDest();
                double valDest = v.getValeur(destArc);
                double coutArc = value.getCout();


                if (coutArc + valeurK < valDest) {
                    System.out.println("ee");
                    System.out.println(nomActuel+"   "+ parentK+"   " + coutArc);
                    v.setValeur(destArc, coutArc + valeurK);
                    v.setParent(destArc, nomActuel);

                }
            }

        }
        return v;
    }
}
