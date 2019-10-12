package TSP;


import java.nio.BufferOverflowException;
import java.util.*;


public class Population implements Iterable<Chromosome> {

    private PriorityQueue<Chromosome> chromosomes;
    private int maxSize;

    /**
     * Constructs an empty population with a maximum size.
     * @param maxSize  the maximum size of the Population
     */
    public Population (int maxSize) {
        this.maxSize = maxSize;
        chromosomes = new PriorityQueue<>();
    }

    /**
     * Adds a Chromosome to the Population.
     * @param chromosome        the chromosome to add
     */
    public void add (Chromosome chromosome) {
        if (chromosomes.size() == maxSize) {
            throw new BufferOverflowException();
        }
        chromosomes.add(chromosome);
    }

    public void populate (City[] cities, Random random) {

        if (chromosomes.size() == maxSize) {
            throw new BufferOverflowException();
        }

        // If the popSize is greater than the factorial of cities, uniqueness not possible.
        // Example: if there are 2 cities but the population size is 100, it is impossible
        // to have all unique values since there are at most 2! = 2 unique possibilities.
        if ((cities.length == 1 && maxSize > 1) ||
                (cities.length == 2 && maxSize > 2) ||
                (cities.length == 3 && maxSize > 6) ||
                (cities.length == 4 && maxSize > 24) ||
                (cities.length == 5 && maxSize > 120) ||
                (cities.length == 6 && maxSize > 720) ||
                (cities.length == 7 && maxSize > 5_040) ||
                (cities.length == 8 && maxSize > 40_320) ||
                (cities.length == 9 && maxSize > 362_880)) {
            throw new IllegalStateException("Cannot force uniqueness when" +
                    " the population size is greater than the factorial" +
                    " of the total number of cities.");
        }

        HashSet<Chromosome> hashSet = new HashSet<>();

        while (chromosomes.size() < maxSize) {
            Chromosome chromo = new Chromosome(cities, random);
            if (!hashSet.contains(chromo)) {
                hashSet.add(chromo);
                add(chromo);
            }
        }
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder("Population:");

        for (Chromosome chromosome : chromosomes) {
            sb.append("\n");
            sb.append(Arrays.toString(chromosome.getArray()));
            sb.append(" Value: ");
            sb.append(chromosome.getDistance());
        }

        return new String(sb);
    }

    @Override
    public Iterator<Chromosome> iterator() {
        return chromosomes.iterator();
    }
}
