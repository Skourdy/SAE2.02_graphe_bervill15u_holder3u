import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GrapheListe gl= new GrapheListe("Graphes/Graphe1.txt");
        System.out.println(gl);
        Dijkstra bf = new Dijkstra();
        Valeur valeur =  bf.resoudre(gl,"1");

        System.out.println(valeur);
    }
}