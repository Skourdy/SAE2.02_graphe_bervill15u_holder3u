import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe GrapheListe
 */
public class GrapheListe implements Graphe {
    //Attributs
    //Liste des noms des noeuds
    List<String> ensNom;
    //Liste des noeuds
    List<Noeud> ensNoeud;


    //Constructeur de GrapheListe
    public GrapheListe(){
        this.ensNom = new ArrayList<String>();
        this.ensNoeud = new ArrayList<Noeud>();
    }


    public GrapheListe(List<String> ensNom, List<Noeud> ensNoeud) {
        this.ensNom = ensNom;
        this.ensNoeud = ensNoeud;
    }

    public GrapheListe(String n) {
    }


    @Override
    public List<String> listeNoeuds() {
        return ensNom;
    }


    /**
     * Méthode suivants(String n)
     *
     * @param n
     * @return List<StrinArc>
     * en prenant en compte le fait que chaque noeud et chaque nom sont ajoutés simultanément dans les listes
     * et sont donc positionnés aux mêmes indices dans les deux listes
     */
    @Override
    public List<Arc> suivants(String n) {
        return ensNoeud.get(ensNom.indexOf(n)).getAdj();
    }

    /**
     * Méthode ajouterArc
     *
     * @param n
     * @param n2
     * @param poids Permet d'ajouter un arc entre deux noeuds
     *              en vérifiant que les noeuds existent bien et que l'arc n'existe pas déjà
     *              en prenant en compte le fait que chaque noeud et chaque nom sont ajoutés simultanément dans les listes
     *              et sont donc positionnés aux mêmes indices dans les deux listes
     *              Si les noeuds n'existent pas, ils sont créés.
     * @throws IOException
     */
    public void ajouterArc(String n, String n2, int poids) throws IOException {
        if (!ensNom.contains(n)) {
            ensNoeud.add(new Noeud(n));
            ensNom.add(n);
        } else if (!ensNom.contains(n2)) {
            ensNoeud.add(new Noeud(n2));
            ensNom.add(n2);
        }
        if (!ensNoeud.get(ensNom.indexOf(n)).getAdj().contains(new Arc(n2, poids))) {
            ensNoeud.get(ensNom.indexOf(n)).ajouterArc(n2, poids);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ensNom.size(); i++) {
            s.append(ensNom.get(i)).append(" -> ");
            for (int j = 0; j < ensNoeud.get(i).getAdj().size(); j++) {
                s.append(ensNoeud.get(i).getAdj().get(j));
                s.append("(");
                s.append(ensNoeud.get(i).getAdj().get(j).getCout());
                s.append(") ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public String toGraphViz() {
        StringBuilder msg = new StringBuilder();
        msg.append("digraph {" + "\n");
        for (int i = 0; i < ensNom.size(); i++) {
            for (int j = 0; j < ensNoeud.get(i).getAdj().size(); j++) {
                msg.append(ensNom.get(i));
                msg.append(" -> ");
                msg.append(ensNoeud.get(i).getAdj().get(j).getDest());
                msg.append(" [label = ");
                msg.append((int) ensNoeud.get(i).getAdj().get(j).getCout());
                msg.append("] ");
                msg.append("\n");
            }
        }
        msg.append("}");
        return msg.toString();
    }

    public List<Noeud> getEnsNoeud() {
        return ensNoeud;
    }
}
