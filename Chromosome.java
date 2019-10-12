package TSP;
import java.util.*;

public class Chromosome implements Comparable<Chromosome> {

    private City[] cities;
    private int distance = -1; // Calculated once then cached.
    private Random random;

    public Chromosome(Chromosome chr) {
        City [] temp = chr.cities;
        City last = temp[temp.length -1];
        this.cities = new City[temp.length];
        this.cities[0] = last;
        int j = 1;
        for (int i = 0; i < cities.length -1; i++) {
            this.cities[j] = temp[i];
            j++;
        }
    }
    public Chromosome (City[] cities) {
        this.cities = cities.clone();
    }

    /**
     * Construct the Chromosome from an array of City objects and shuffle them.
     * @param cities    the array of City objects for construction
     * @param random    the Random object for shuffling the Chromosome
     */




    public Chromosome (City[] cities, Random random) {
        this.cities = cities.clone();
        this.random = random;
        shuffle1();
    }


    /**
     * Shuffles the cities in the Chromosome.
     */
    private void shuffle1 () {
        for (int i = 1; i < cities.length; i++) {
            swap(i, random.nextInt(cities.length-1)+1);
        }
    }

    /**
     * Shuffles the cities in the Chromosome.
     */
    private void shuffle () {
        for (int i = 0; i < cities.length; i++) {
            swap(i, random.nextInt(cities.length));
        }
    }

    /**
     * Helper method for shuffling the cities. Swaps two cities.
     * @param i     the index of the first city
     * @param j     the index of the second city
     */
    private void swap (int i, int j) {
        City temp = cities[i];
        cities[i] = cities[j];
        cities[j] = temp;
    }

    public City[] getArray () {
        return cities.clone();
    }

    public int getDistance () {

        // If this was already calculated, don't calculate it again.
        if (distance != -1) {
            return distance;
        }

        double distanceTravelled = 0;

        for (int i = 1; i < cities.length; i++) {
            distanceTravelled += City.distance(cities[i-1], cities[i]);
        }

        distanceTravelled += City.distance(cities[cities.length-1], cities[0]);
        this.distance = (int)distanceTravelled;
        return distance;
    }

    @Override
    public int compareTo(Chromosome chromosome) {
        return getDistance() - chromosome.getDistance();
    }
}
