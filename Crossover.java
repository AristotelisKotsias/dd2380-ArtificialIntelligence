package TSP;
import java.util.*;
public class Crossover {

    /**
     * Performs a crossover on all the cities between two points.
     * @param p1    the first parent chromosome
     * @param p2    the second parent chromosome
     * @param r     the Random object for selecting a point
     * @return      the children
     */
    static ArrayList<Chromosome> orderCrossover (Chromosome p1, Chromosome p2, Random r) {
        City[] parent1 = p1.getArray();
        City[] parent2 = p2.getArray();

        City[] child1 = new City[parent1.length];
        City[] child2 = new City[parent2.length];

        HashSet<City> citiesInChild1 = new HashSet<>();
        HashSet<City> citiesInChild2 = new HashSet<>();

        ArrayList<City> citiesNotInChild1 = new ArrayList<>();
        ArrayList<City> citiesNotInChild2 = new ArrayList<>();

        ArrayList<Chromosome> children = new ArrayList<>();
        int totalCities = parent1.length;

        int firstPoint = r.nextInt(totalCities);
        int secondPoint = r.nextInt(totalCities - firstPoint) + firstPoint;

        // Inherit the cities before and after the points selected.
        for (int i = 0; i < firstPoint; i++) {
            child1[i] = parent1[i];
            child2[i] = parent2[i];
            citiesInChild1.add(parent1[i]);
            citiesInChild2.add(parent2[i]);
        }
        for (int i = secondPoint; i < totalCities; i++) {
            child1[i] = parent1[i];
            child2[i] = parent2[i];
            citiesInChild1.add(parent1[i]);
            citiesInChild2.add(parent2[i]);
        }

        // Get the cities of the opposite parent if the child does not already contain them.
        for (int i = firstPoint; i < secondPoint; i++) {
            if (!citiesInChild1.contains(parent2[i])) {
                citiesInChild1.add(parent2[i]);
                child1[i] = parent2[i];
            }
            if (!citiesInChild2.contains(parent1[i])) {
                citiesInChild2.add(parent1[i]);
                child2[i] = parent1[i];
            }
        }

        // Find all the cities that are still missing from each child.
        for (int i = 0; i < totalCities; i++) {
            if (!citiesInChild1.contains(parent2[i])) {
                citiesNotInChild1.add(parent2[i]);
            }
            if (!citiesInChild2.contains(parent1[i])) {
                citiesNotInChild2.add(parent1[i]);
            }
        }

        // Find which spots are still empty in each child.
        ArrayList<Integer> emptySpotsC1 = new ArrayList<>();
        ArrayList<Integer> emptySpotsC2 = new ArrayList<>();
        for (int i = 0; i < totalCities; i++) {
            if (child1[i] == null) {
                emptySpotsC1.add(i);
            }
            if (child2[i] == null) {
                emptySpotsC2.add(i);
            }
        }

        // Fill in the empty spots.
        for (City city : citiesNotInChild1) {
            child1[emptySpotsC1.remove(0)] = city;
        }
        for (City city : citiesNotInChild2) {
            child2[emptySpotsC2.remove(0)] = city;
        }

        Chromosome childOne = new Chromosome(child1);
        Chromosome childTwo = new Chromosome(child2);
        children.add(childOne);
        children.add(childTwo);

        return children;
    }

}
