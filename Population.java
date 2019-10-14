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
        chromosomes = new PriorityQueue<>(maxSize);
    }

    /**
     * Adds a Chromosome to the Population.
     * @param chromosome        the chromosome to add
     */
    public void add (Chromosome chromosome) {
      /* if (chromosomes.size() == maxSize) {
            throw new BufferOverflowException();
       }*/
        chromosomes.add(chromosome);
    }

//    public Chromosome[] getChromosomes () {
//        Chromosome[] array = new Chromosome[maxSize];
//
//        int i = 0;
//        //for (Chromosome chromo : chromosomes) {
//        for (int j = 0; j < maxSize; j++) {
//            array[i++] = chromosomes.peek();
//        }
//
//        return array;
//    }

    public Chromosome[] getChromosomes () {
        Chromosome[] array = new Chromosome[chromosomes.size()];

        int i = 0;
        for (Chromosome chromo : chromosomes) {
            array[i++] = chromo;
        }

        return array;
    }

    public void populate (City[] cities, Random random) {

        HashSet<Chromosome> hashSet = new HashSet<>();

        while (chromosomes.size() < maxSize) {
            Chromosome chromosome = new Chromosome(cities, random);
            if (!hashSet.contains(chromosome)) {
                hashSet.add(chromosome);
                add(chromosome);
            }
        }
    }

    public void clear () {
        chromosomes.clear();
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
