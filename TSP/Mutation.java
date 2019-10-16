package TSP;

import java.util.Random;

public class Mutation {

    public Chromosome mutate(Chromosome chromosome){
        City [] cities = chromosome.getArray();
        int len = cities.length;
        int index1 = (int) (Math.random()*len);
        int index2 = (int) (Math.random()*len);
        int index3 = (int) (Math.random()*len);
        int index4 = (int) (Math.random()*len);
        int index5 = (int) (Math.random()*len);
        int index6 = (int) (Math.random()*len);
        //System.out.println("Distance before mut => " + chromosome.getDistance());
        swap(cities, index1, index2);
        swap(cities, index3, index4);
        swap(cities, index5, index6);
        //System.out.println("Distance after mut => " + (new Chromosome(cities)).getDistance());

        return new Chromosome(cities);
    }

    private static void swap (City[] cities, int i, int j) {
        City temp = cities[i];
        cities[i] = cities[j];
        cities[j] = temp;
    }
}
