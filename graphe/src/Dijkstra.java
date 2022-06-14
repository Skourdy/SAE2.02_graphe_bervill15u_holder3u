import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    private Valeur valeur;

    public Valeur resoudre(Graphe g, String depart) {

        Valeur v = new Valeur();
        List<String> listeDesNoms = new ArrayList<>();

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            listeDesNoms.add(g.listeNoeuds().get(i));
            String nomI = g.listeNoeuds().get(i);

            v.setValeur(nomI, Double.MAX_VALUE);
            v.setParent(nomI, null);
        }

        v.setValeur(depart, 0);
        v.setParent(depart, "Départ");



            while (listeDesNoms.size() > 0) {
                String nomActuel = listeDesNoms.get(0);

                double valeurActuel = v.getValeur(nomActuel);
                for (String nom : listeDesNoms) {
                    if (v.getValeur(nom) < valeurActuel) {
                        nomActuel = nom;
                    }
                }
                List<Arc> listArc = g.suivants(nomActuel);
                for (Arc value : listArc) {

                    valeurActuel = v.getValeur(nomActuel);
                    String destArc = value.getDest();
                    double valDest = v.getValeur(destArc);
                    double coutArc = value.getCout();

                    if (valDest > valeurActuel + coutArc) {
                        v.setValeur(destArc, coutArc + valeurActuel);
                        v.setParent(destArc, nomActuel);
                    }
                }
                listeDesNoms.remove(nomActuel);

        }
        this.valeur = v;
        return valeur;
    }

    public List<String> calculerChemin(String destination) {
        List<String> chemin = new ArrayList<>();
        String parentActuel = valeur.getParent(destination);
        chemin.add(parentActuel);
        while (!parentActuel.equals("Départ")) {
            parentActuel = valeur.getParent(parentActuel);
            chemin.add(parentActuel);
        }
        return chemin;
    }
}
