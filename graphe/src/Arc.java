public class Arc {

    private String dest;
    private double cout;

    public Arc(String dest, double cout) {
        if (cout > 0) {
            this.dest = dest;
            this.cout = cout;
        }
    }
}