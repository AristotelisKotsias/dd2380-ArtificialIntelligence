package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static TSP.Crossover.*;

public class GeneticAlgorithm {

    int population = 10000;
    int generations = 200;
    double bestDistanceZeroGen;
    double bestDistanceLastGen;
    double averageDistanceZeroGen;
    double averageDistanceLastGen;
    Input.DataSet file = Input.DataSet.burma14;

    public void initialization () {
        Input in = new Input();
        citiesNotInChild = new ArrayList<>(Arrays.asList(in.getCities(file)));
        Population pop = new Population(population);
        NextGen ng = new NextGen(pop);
        Matrix.populate_matrix(in.getCities(file));

        /*OX ox = new OX();
        Chromosome chr1 = new Chromosome(in.getCities(file), new Random());
        Chromosome chr2 = new Chromosome(in.getCities(file), new Random());


        System.out.println("parent 1 " + chr1.toString() + "\nparent 2 " + chr2.toString());
        ArrayList<Chromosome> arr = new ArrayList<>();
        arr = ox.orderCrossover(chr1,chr2,new Random());
        System.out.println("children");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("child " + i + " " + arr.get(i));

        }*/


        //Create generation zero with chromosomes
        pop.populate(in.getCities(file), new Random());

        for (int i = 0; i < generations; i++) {
            if (i == 0) {
                bestDistanceZeroGen = pop.getFittest();
                averageDistanceZeroGen = pop.getAverageDistances();
            }
            ng.createGenOX();
            if (i == generations - 1){
                bestDistanceLastGen = pop.getFittest();
                averageDistanceLastGen = pop.getAverageDistances();
            }


                System.out.println("Gen " + i + " => \n" );
               System.out.println(pop.toString());
               System.out.println("-----------------------------------------");
        }
        System.out.println("First " + bestDistanceZeroGen + "\nLast " + bestDistanceLastGen);
        System.out.println("AverageFirst " + averageDistanceZeroGen + "\nAverageLast " + averageDistanceLastGen);
    }
}