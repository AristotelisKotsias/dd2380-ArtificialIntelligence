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
