package TSP;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Input.DataSet file = Input.DataSet.berlin52;
        int population = 10000;
        int generations = 200;
        int prob_crossover = 100;
        int prob_mutation = 20;
        boolean isOX = true;

        GeneticAlgorithm ga = new GeneticAlgorithm(file, population, generations, prob_crossover, prob_mutation, isOX);
        ga.initialization();
    }
}


 /*

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Random;

    import TSP.Input.DataSet;

        static int population = 10000;
        static int generations = 200;
        static DataSet file = DataSet.berlin52;

        Input in = new Input();
        Crossover.citiesNotInChild = new ArrayList<>(Arrays.asList(in.getCities(file)));
        Population pop = new Population(population);
        NextGen ng = new NextGen(pop);

        Matrix.populate_matrix(in.getCities(file));

        //Create generation zero with chromosomes
        pop.populate(in.getCities(file), new Random());

        for (int i = 0; i < generations; i++) {
//            if(i == 0 || i == generations-1){
        //System.out.println("Gen " + i + " => \n" );
        ng.createGen();
     *//*          System.out.println(pop.toString());
                System.out.println("-----------------------------------------");*//*
//                continue;
//            }
//            ng.createGen();

        }*/
