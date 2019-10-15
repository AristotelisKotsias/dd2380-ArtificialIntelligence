package TSP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static TSP.Crossover.*;

public class GeneticAlgorithm {

    private int population;
    private int generations;
    private int prob_crossover;
    private int prob_mutation;
    private double bestDistanceZeroGen;
    private double bestDistanceLastGen;
    private double averageDistanceZeroGen;
    private double averageDistanceLastGen;
    private  ArrayList<Double> averageDistanceEachGen = new ArrayList<>();
    private  ArrayList<Double> bestDistanceEachGen = new ArrayList<>();
    private Input.DataSet file;
    private boolean isOX;

    public GeneticAlgorithm(Input.DataSet file, int population, int generations, int prob_crossover, int prob_mutation, boolean isOX) {
        this.file = file;
        this.population = population;
        this.generations = generations;
        this.prob_crossover = prob_crossover;
        this.prob_mutation = prob_mutation;
        this.isOX = isOX;
    }

    public void initialization () throws IOException {
        Input in = new Input();
        citiesNotInChild = new ArrayList<>(Arrays.asList(in.getCities(file)));
        Population pop = new Population(population);
        NextGen ng = new NextGen(pop, prob_crossover, prob_mutation);
        Matrix.populate_matrix(in.getCities(file));

        /*Ox ox = new Ox();
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
            System.out.println(pop.toString());

            if (i == 0) {
                bestDistanceZeroGen = pop.getFittest();
                averageDistanceZeroGen = pop.getAverageDistances();
            }

            if (isOX)
                ng.createGenOX();
            else
                ng.createGenSCX();

            if (i == generations - 1) {
                bestDistanceLastGen = pop.getFittest();
                averageDistanceLastGen = pop.getAverageDistances();
            }

            averageDistanceEachGen.add(pop.getAverageDistances());
            bestDistanceEachGen.add(pop.getFittest());


        }

        //File name convention best_crossovertype_dataset_pop_gen_numberOfTest.csv

        FileWriter csvWriter0 = new FileWriter("best_scx_bays29_500_10000_1.csv");
        csvWriter0.append("Best of each generation,");
        csvWriter0.append("\n");
        csvWriter0.append(bestDistanceZeroGen + " ,");
        csvWriter0.append("\n");

        for (Double al : bestDistanceEachGen) {
            csvWriter0.append(al+" ");
            csvWriter0.append("\n");
        }

        csvWriter0.flush();
        csvWriter0.close();

        FileWriter csvWriter = new FileWriter("average_scx_bays29_500_10000_1.csv");
        csvWriter.append("Average distance,");
        csvWriter.append("\n");
        csvWriter.append(averageDistanceZeroGen + " ,");
        csvWriter.append("\n");

        for (Double al : averageDistanceEachGen) {
            csvWriter.append(al+" ");
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

        System.out.println("First " + bestDistanceZeroGen + "\nLast " + bestDistanceLastGen);
        System.out.println("AverageFirst " + averageDistanceZeroGen + "\nAverageLast " + averageDistanceLastGen);

    }
}
