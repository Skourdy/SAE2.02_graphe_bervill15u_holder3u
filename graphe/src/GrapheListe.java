import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe GrapheListe
 */
public class GrapheListe implements Graphe {
    //Attributs
    //Liste des noms des nœuds
    List<String> ensNom;
    //Liste des nœuds
    List<Noeud> ensNoeud;



    public GrapheListe(List<String> ensNom, List<Noeud> ensNoeud) {
        this.ensNom = ensNom;
        this.ensNoeud = ensNoeud;
    }

    //Constructeur prenant un fichier txt en paramètre créant le graphe
    public GrapheListe(String nomFichier) throws IOException {
        this.ensNom = new ArrayList<>();
        this.ensNoeud = new ArrayList<>();
        FileReader lf = new FileReader(nomFichier);
        BufferedReader br = new BufferedReader(lf);
        for (String ligne = br.readLine(); ligne != null; ligne = br.readLine()) {
            String[] recup = ligne.split("\t");
            this.ajouterArc(recup[0], recup[1], Integer.parseInt(recup[2]));
        }
    }

    /**
     * Constructeur GrapheListe()
     * Construit aléatoirement un graphe selon une taille donnée
     *
     * Si le graphe n'a pas de chemin entre le début et la fin, il en reconstruit un autre
     * Plus le graphe a de nœuds, plus les nœuds auront de potentiels arcs
     * Le nombre d'arcs de chaque nœud est aléatoire, mais limité selon le nombre de nœuds
     * @param nbNoeuds : int ; le nombre de nœuds du graphe
     * @param debut : String ; le nom du nœud de départ
     * @param fin : String ; le nom du nœud de fin
     */
    public GrapheListe(int nbNoeuds, String debut, String fin){
        /*
        Début
            Pour chaque nœud sauf fin
                // Solution pour avoir des graphes connecte.
                // Aucun nœud est isolé du fait que chaque nœud a un arc
                // Pour permettre une plus grande complexité, il faut augmenter le random (par exemple 20)
                random entre 1 et 5, pour le nombre d'arcs de ce nœud
                Pour chaque arc de ce nœud
                    Choisir une destination
                    Si la destination est le début, on en prend une nouvelle
                        random double pour la valeur de l'arc entre 0 et 100
                    Fin Si
                    Création de l'arc
                Fin pour
            Fin pour
        Fin*/
        //Initialisation des variables
        Random r = new Random();
        double coutArc;
        int nbArc;
        String dest;
        int randomArc;

        //Pour les petits graphes
        if (nbNoeuds <5){
            randomArc = 2;
        }else {//Pour les plus grands graphes
            //On fait une relation par rapport au nombre de nœuds
            randomArc = (int) Math.round(Math.sqrt(nbNoeuds));
        }

        //Test si le graphe possède bien un chemin entre le début et la fin
        boolean chemin = false;
        while (!chemin) {
            this.ensNom = new ArrayList<>();
            this.ensNoeud = new ArrayList<>();

            //On parcourt tous les nœuds
            for (int i = 0; i < nbNoeuds; i++) {

                //Si c'est le nœud de fin
                if (i == Integer.parseInt(fin)) {
                    //On l'ajoute aux listes
                    this.ensNom.add(Integer.toString(i));
                    this.ensNoeud.add(new Noeud(Integer.toString(i)));
                } else {
                    //Sinon on prend un nombre aléatoire entre 1 et 3 pour les petits graphes, sinon entre 1 et la racine du nombre de nœuds
                    nbArc = r.nextInt(randomArc)+1;
                    //On fait une boucle pour tous les futurs arcs du nœud
                    for (int j = 0; j < nbArc; j++) {
                        //Cout aléatoire entre 0 et 100
                        coutArc = r.nextDouble(100);
                        //Destination aléatoire entre tous les nœuds sauf le début
                        dest = Integer.toString(r.nextInt(nbNoeuds));

                        //Si c'est vers le début on en prend un autre
                        while (dest.equals(debut)) {
                            dest = Integer.toString(r.nextInt(nbNoeuds));
                        }
                        //Puis on ajoute l'arc au nœud
                        ajouterArc(Integer.toString(i), dest, coutArc);
                    }
                }
            }
            //On teste si le graphe possède bien un chemin d'une taille minimale de 2 entre le début et la fin
            Dijkstra dj = new Dijkstra();
            List<String> cheminL;

            try {
                cheminL = dj.resoudre(this, debut).calculerChemin(fin);
                if (cheminL.size() >2){
                    //Condition remplie, donc fin du constructeur
                    chemin = true;
                }
                //Possible d'avoir une Exception, on ne sent préoccupe pas, car on fait un nouveau graphe si cela arrive
            }catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<String> listeNoeuds() {return ensNom;}

    /**
     * Méthode suivants(String n)
     *
     * @param n : String
     * @return List<Arc>
     * en prenant en compte le fait que chaque nœud et chaque nom sont ajoutés simultanément dans les listes
     * et sont donc positionnés aux mêmes indices dans les deux listes
     */
    @Override
    public List<Arc> suivants(String n) {
        return ensNoeud.get(ensNom.indexOf(n)).getAdj();
    }

    /**
     * Méthode ajouterArc
     *
     * @param n : String ; premier noeud
     * @param n2 : String ; deuxième noeud
     * @param poids Permet d'ajouter un arc entre deux nœuds
     *              en vérifiant que les nœuds existent bien et que l'arc n'existe pas déjà
     *              en prenant en compte le fait que chaque nœud et chaque nom sont ajoutés simultanément dans les listes
     *              et sont donc positionnés aux mêmes indices dans les deux listes
     *              Si les nœuds n'existent pas, ils sont créés.
     */
    public void ajouterArc(String n, String n2, double poids){
        if (!ensNom.contains(n)) {
            ensNoeud.add(new Noeud(n));
            ensNom.add(n);
        } else if (!ensNom.contains(n2)) {
            ensNoeud.add(new Noeud(n2));
            ensNom.add(n2);
        }


        int index = ensNom.indexOf(n);
        Noeud noeud = ensNoeud.get(index);
        noeud.ajouterArc(n2, poids);

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ensNom.size(); i++) {
            s.append(ensNom.get(i)).append(" -> ");
            for (int j = 0; j < ensNoeud.get(i).getAdj().size(); j++) {
                s.append(ensNoeud.get(i).getAdj().get(j).getDest());
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
