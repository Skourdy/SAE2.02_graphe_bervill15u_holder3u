import java.util.List;

public class BellmanFord {
    /**
     * Méthode resoudre()
     * Permet de définir le plus petit chemin vers tous les nœuds du graphe g, à partir du début départ
     * @param g : Graphe ; le Graphe
     * @param depart : String ; le nom du nœud que l'on veut comme départ
     * @return v : Valeur ; la valeur du nœud ainsi que son parent.
     */
    public Valeur resoudre(Graphe g, String depart) {
        /*
         * Entrées :
         * G un graphe orienté avec une pondération (poids) positive des arcs
         * A un sommet (départ) de G
         *
         *
         * Début
         * Q <- {} // utilisation d’une liste de nœuds à traiter
         * Pour chaque sommet v de G faire
         * 	v.distance <- Infini
         * 	v.parent <- Indéfini
         * 	Q <- Q U {v} // ajouter le sommet v à la liste Q
         * Fin Pour
         * A.distance <- 0
         *
         * modification = true
         *
         * Tant que modification = true Faire
         * 	modification = false
         * 	Pour chaque nœud v de Q faire
         * 		u ← un sommet de Q telle que u.distance est minimale
         * 		Q <- Q \ {u} // enlever le sommet u de la liste Q
         * 		Pour chaque sommet v de Q tel que l’arc (u, v) existe faire
         * 			D <- u.distance + poids(u,v)
         * 			Si D < v.distance
         * 				Alors v.distance ← D
         * 				v.parent ← u
         * 			Fin Si
         * 		Fin Pour
         * 	Fin Pour
         * Fin Tant que
         * Fin
         */


        Valeur v = new Valeur();
        List<String> listeDesNoms = g.listeNoeuds();

        //On initialise toutes les valeurs à Max_Value, et sans parent
        for (String nomI : listeDesNoms) {
            v.setValeur(nomI, Double.MAX_VALUE);
            v.setParent(nomI, null);
        }
        //On modifie le départ avec valeur = 0, et parent =Départ
        v.setValeur(depart, 0);
        v.setParent(depart, "Départ");
        //Condition d'arrêt
        boolean ligne_modifier = true;
        //System pour avoir le temps
        long date_debut = System.nanoTime();

        //Début de l'algorithme
        //Tant que la ligne est modifié
        while (ligne_modifier) {
            //On remet à false
            ligne_modifier = false;

            // pour tous les nœuds
            for (String nom : listeDesNoms) {

                // tous les successeurs du nœud
                List<Arc> lArc = g.suivants(nom);
                for (Arc value : lArc) {

                    //Initialisation des variables
                    double valeurK = v.getValeur(nom);
                    String destArc = value.getDest();
                    double valDest = v.getValeur(destArc);
                    double coutArc = value.getCout();

                    //Si le cout change
                    if (coutArc + valeurK < valDest) {
                        v.setValeur(destArc, coutArc + valeurK);
                        v.setParent(destArc, nom);
                        //Passe en true
                        ligne_modifier = true;
                    }

                    //System.out.println(v);

                }
            }
        }
        long date_fin = System.nanoTime();
        //Calcule du temps
        long duree = date_fin - date_debut;
        System.out.println("Durée : "+duree);
        return v;
    }
}
