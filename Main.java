package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import TSP.Input.DataSet;

public class Main {

    static int population = 10;
    static int generations = 3;
    static DataSet file = DataSet.burma14;

    public static void main(String[] args) {
        Input in = new Input();
        Crossover.citiesNotInChild = new ArrayList<>(Arrays.asList(in.getCities(file)));
        Population pop = new Population(population);
        NextGen ng = new NextGen(pop);

        Matrix.populate_matrix(in.getCities(file));

        //Create generation zero with chromosomes
        pop.populate(in.getCities(file), new Random());

        for (int i = 0; i < generations; i++) {
//            if(i == 0 || i == generations-1){
                System.out.println("Gen " + i + " => \n" );
                ng.createGen();
                System.out.println(pop.toString());
                System.out.println("-----------------------------------------");
//                continue;
//            }
//            ng.createGen();

        }

    }
}
