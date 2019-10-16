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
    private ArrayList<Double> averageDistanceEachGen = new ArrayList<>();
    private ArrayList<Double> bestDistanceEachGen = new ArrayList<>();
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

    /**
     * Initializes generation 0 and runs until generation limit
     * @throws IOException
     */
    public void initialization () throws IOException {
        Input in = new Input();

        //Fill the arraylist with all the genes
        geneNotInChild = new ArrayList<>(Arrays.asList(in.getGenes(file)));
        Population pop = new Population(population);
        NextGen ng = new NextGen(pop, prob_crossover, prob_mutation);
        Matrix.populate_matrix(in.getGenes(file));


        //Create generation zero with chromosomes
        pop.populate(in.getGenes(file), new Random());

        for (int i = 0; i < generations; i++) {
            System.out.println(pop.toString()+" "+ i);

            if (i == 0) {
                bestDistanceZeroGen = pop.getFittest();
                averageDistanceZeroGen = pop.getAverageDistances();
            }

            //Choose between OX and SCX crossover operator
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
        FileWriter csvWriter0 = new FileWriter("best_ox_a280_10000_500_1.csv");
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

        FileWriter csvWriter = new FileWriter("average_ox_a280_10000_500_1.csv");
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


        //Printing for testing purposes
        System.out.println("First " + bestDistanceZeroGen + "\nLast " + bestDistanceLastGen);
        System.out.println("AverageFirst " + averageDistanceZeroGen + "\nAverageLast " + averageDistanceLastGen);

    }
}
