package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static TSP.Crossover.*;

public class GeneticAlgorithm {

    int population = 100;
    int generations = 20000;
    double bestDistanceZeroGen;
    double bestDistanceLastGen;
    double averageDistanceZeroGen;
    double averageDistanceLastGen;
    Input.DataSet file = Input.DataSet.berlin52;

    public void initialization () {
        Input in = new Input();
        citiesNotInChild = new ArrayList<>(Arrays.asList(in.getCities(file)));
        Population pop = new Population(population);
        NextGen ng = new NextGen(pop);
        Matrix.populate_matrix(in.getCities(file));

        //Create generation zero with chromosomes
        pop.populate(in.getCities(file), new Random());

        for (int i = 0; i < generations; i++) {
            if (i == 0) {
                bestDistanceZeroGen = pop.getFittest();
                averageDistanceZeroGen = pop.getAverageDistances();
            }
            ng.createGen();
            if (i == generations - 1){
                bestDistanceLastGen = pop.getFittest();
                averageDistanceLastGen = pop.getAverageDistances();
            }
        }
        System.out.println("First " + bestDistanceZeroGen + "\nLast " + bestDistanceLastGen);
        System.out.println("AverageFirst " + averageDistanceZeroGen + "\nAverageLast " + averageDistanceLastGen);
    }
}