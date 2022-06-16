import java.util.ArrayList;
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
        boolean ligne_modifier = true;
        long date_debut = System.nanoTime();
        //Tant que la ligne est modifer
        while (ligne_modifier) {
            //On remet à false
            ligne_modifier = false;

            // pour tous les noeuds
            for (int k = 0; k < size; k++) {

                // tous les successeurs du noeud k
                List<Arc> lArc = g.suivants(listeDesNoms.get(k));
                for (Arc value : lArc) {

                    //On prend toutes les variables
                    String nomActuel = listeDesNoms.get(k);
                    double valeurK = v.getValeur(nomActuel);

                    String destArc = value.getDest();
                    double valDest = v.getValeur(destArc);
                    double coutArc = value.getCout();

                    //Si le cout change
                    if (coutArc + valeurK < valDest) {
                        v.setValeur(destArc, coutArc + valeurK);
                        v.setParent(destArc, nomActuel);
                        //Pass en true
                        ligne_modifier = true;
                    }
                    System.out.println(v);

                }
            }
        }
        long date_fin = System.nanoTime();
        long duree = date_fin - date_debut;
        System.out.println(duree);
        return v;
    }
}
