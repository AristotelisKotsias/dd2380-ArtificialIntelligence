package TSP;

import java.util.*;
import java.util.Arrays;

import static TSP.Input.DataSet.*;


public class Main {

    public static void main(String[] args) {
        // Create cities
        int numStops = 0;
        int popsize;
        int generation;
        int crossover_percentage;
        boolean is_SCX;
        int mutation_percentage;
        int mutation_limit;
        boolean isCostDistance;
        //GeneticAlgorithm ga = new GeneticAlgorithm();
        Input in = new Input();
        Chromosome chr = new Chromosome(in.getCities(burma14),new Random());
        System.out.println(Arrays.toString(in.getCities(burma14)));
        System.out.println(Arrays.toString(chr.getArray()));


        Population pop = new Population(10);
        for (int i = 0; i < 10; i++) {
            pop.add(new Chromosome(in.getCities(burma14),new Random()));
        }
        System.out.println(pop.toString());
    }
}
