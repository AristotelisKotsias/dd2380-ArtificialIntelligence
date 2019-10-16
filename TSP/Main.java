package TSP;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Input.DataSet file = Input.DataSet.bier127;
        int population = 10;
        int generations = 10;
        int prob_crossover = 90;
        int prob_mutation = 1;
        boolean isOX = false;

        GeneticAlgorithm ga = new GeneticAlgorithm(file, population, generations, prob_crossover, prob_mutation, isOX);
        ga.initialization();
    }
}
