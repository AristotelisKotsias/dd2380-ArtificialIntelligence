package TSP;
import java.util.*;

public class Chromosome implements Comparable<Chromosome> {

    private Gene[] cities;
    private int distance = -1;
    private Random random;

    public Chromosome (Gene[] cities) {
        this.cities = cities.clone();
    }

    public Chromosome (Gene[] cities, Random random) {
        this.cities = cities.clone();
        this.random = random;
        shuffle();
    }

    public void shuffle () {
        for (int i = 0; i < cities.length; i++) {
            swap(i, random.nextInt(cities.length));
        }
    }

    private void swap (int i, int j) {
        Gene temp = cities[i];
        cities[i] = cities[j];
        cities[j] = temp;
    }

    public Gene[] getArray () {
        return cities.clone();
    }

    public int getDistance () {

        if (distance != -1) {
            return distance;
        }

        double distanceTravelled = 0;

        for (int i = 1; i < cities.length; i++) {
            distanceTravelled += Gene.distance(cities[i-1], cities[i]);
        }

        distanceTravelled += Gene.distance(cities[cities.length-1], cities[0]);
        this.distance = (int)distanceTravelled;
        return distance;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder("[ ");
        for (Gene item : cities) {
            sb.append(item.getName());
            sb.append(" ");
        }
        sb.append("]");
        return new String(sb);
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        for (Gene gene : cities) {
            sb.append(gene);
        }
        return (new String(sb)).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chromosome)) {
            return false;
        }

        Chromosome c = (Chromosome) o;

        return Arrays.equals(c.cities, cities);
    }

    @Override
    public int compareTo(Chromosome chromosome) {
        return getDistance() - chromosome.getDistance();
    }
}
