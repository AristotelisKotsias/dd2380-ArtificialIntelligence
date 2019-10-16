package TSP;

public class Gene {

    private String name;
    private int x, y;

    public Gene(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName () {
        return name;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }


    public static double distance (Gene gene1, Gene gene2) {

        int x1 = gene1.getX();
        int y1 = gene1.getY();

        int x2 = gene2.getX();
        int y2 = gene2.getY();

        int xDiff = x2 - x1;
        int yDiff = y2 - y1;

        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gene gene = (Gene) o;

        if (x != gene.x) return false;
        if (y != gene.y) return false;
        return name.equals(gene.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + x + ", " + y + ")";
    }
}