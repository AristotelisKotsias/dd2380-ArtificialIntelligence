package TSP;

public class Matrix {

    static double[][] distances;

    public static void populate_matrix(City[] cities) {
        int len = cities.length + 1;
        distances = new double[len][len];
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < i; j++) {
                distances[i][j] = City.distance(cities[i - 1], cities[j - 1]);
                distances[j][i] = distances[i][j];
            }
        }
    }
}
