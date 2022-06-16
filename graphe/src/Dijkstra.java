import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public Valeur resoudre(Graphe g, String depart) {
        /*
         * Entrées :
         * G un graphe orienté avec une pondération (poids) positive des arcs
         * A un sommet (départ) de G
         * Début
         * Q <- {} // utilisation d’une liste de nœuds à traiter
         * Pour chaque sommet v de G faire
         *      v.distance <- Infini
         *      v.parent <- Indéfini
         *      Q <- Q U {v} // ajouter le sommet v `a la liste Q
         * Fin Pour
         * A.distance ← 0
         * Tant que Q est un ensemble non vide faire
         *      u ← un sommet de Q tel que u.distance est minimale
         *      Q <- Q \ {u} // enlever le sommet u de la liste Q
         *      Pour chaque sommet v de Q tel que l’arc (u, v) existe faire
         *          D <- u.distance + poids(u,v)
         *          Si D < v.distance
         *              Alors v.distance ← D
         *              v.parent ← u
         *          Fin Si
         *      Fin Pour
         * Fin Tant que
         * Fin
         */

        Valeur v = new Valeur();
        List<String> listeDesNoms = new ArrayList<>();

        //On initialise toutes les valeurs à Max_Value, et sans parent
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            listeDesNoms.add(g.listeNoeuds().get(i));
            String nomI = g.listeNoeuds().get(i);

            v.setValeur(nomI, Double.MAX_VALUE);
            v.setParent(nomI, null);
        }

        //On modifie le départ avec valeur = 0, et parent =Départ
        v.setValeur(depart, 0);
        v.setParent(depart, "Départ");

        //System pour avoir le temps
        long date_debut = System.nanoTime();

        //Début de l'algorithme
        while (listeDesNoms.size() > 0) {
            //On prend le premier nœud
            String nomActuel = listeDesNoms.get(0);

            double valeurActuel = v.getValeur(nomActuel);
            for (String nom : listeDesNoms) {
                if (v.getValeur(nom) < valeurActuel) {
                    nomActuel = nom;
                }
            }

            // tous les successeurs du nœud
            List<Arc> listArc = g.suivants(nomActuel);
            for (Arc value : listArc) {

                valeurActuel = v.getValeur(nomActuel);
                String destArc = value.getDest();
                double valDest = v.getValeur(destArc);
                double coutArc = value.getCout();

                //Condition si changement de parent
                if (valDest > valeurActuel + coutArc) {
                    v.setValeur(destArc, coutArc + valeurActuel);
                    v.setParent(destArc, nomActuel);
                }
            }
            //On supprime le nœud de la list
            listeDesNoms.remove(nomActuel);
        }
        long date_fin = System.nanoTime();
        //Calcule du temps
        long duree = date_fin - date_debut;
        System.out.println(" Durée : "+duree);
        return v;
    }
}
