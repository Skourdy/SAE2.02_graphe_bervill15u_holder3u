import java.util.List;

public class BellmanFord {


    public Valeur resoudre(Graphe g, String depart){
        Valeur[] v = new Valeur[g.listeNoeuds().size()];
        for (int i = 0; i<g.listeNoeuds().size();i++){
            if (depart == g.listeNoeuds().get(i)){
                v[i].setValeur(Integer.toString(i),0);
                v[i].setParent(Integer.toString(i),);
            }else {
                v[i].setValeur(Integer.toString(i), Double.MAX_VALUE);
                v[i].setParent(Integer.toString(i),null);
            }

        }
        for (int k = 0;k<g.listeNoeuds().size();k++){
            List<Arc> lArc = g.suivants(g.listeNoeuds().get(k));
            for (int l =0 ;l<lArc.size()  ; l++ ){
                if (lArc.get(l).getCout()+ >){

                }

            }
        }

        return v[0];
    }
}
