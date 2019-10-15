package TSP;


public class Main {

    public static void main(String[] args) {
        Input.DataSet file = Input.DataSet.att48;
        int population = 100;
        int generations = 500;
        int prob_crossover = 90;
        int prob_mutation = 10;
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
