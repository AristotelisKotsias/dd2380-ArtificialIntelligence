package TSP;

import java.util.*;

public class Population implements Iterable<Chromosome> {

    private PriorityQueue<Chromosome> chromosomes;
    private int maxSize;

    public Population (int maxSize) {
        this.maxSize = maxSize;
        chromosomes = new PriorityQueue<>(maxSize);
    }

    public void add (Chromosome chromosome) {
        chromosomes.add(chromosome);
    }

    public double getFittest() {
        return chromosomes.peek().getDistance();
    }

    public double getAverageDistances(){
        double sum = 0;
        for(Chromosome chromo : chromosomes){
            sum += chromo.getDistance();
        }

        return sum/chromosomes.size();
    }

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
