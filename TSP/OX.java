package TSP;

import java.util.*;

public class OX {

    public ArrayList<Chromosome> orderCrossover (Chromosome p1, Chromosome p2, Random r) {
        City[] parent1 = p1.getArray();
        City[] parent2 = p2.getArray();

        City[] child1 = new City[parent1.length];
        City[] child2 = new City[parent2.length];

        HashSet<City> citiesInChild1 = new HashSet<>();
        HashSet<City> citiesInChild2 = new HashSet<>();

        ArrayList<Chromosome> children = new ArrayList<>();
        int totalCities = parent1.length;

        int firstPoint = r.nextInt(totalCities);
        int secondPoint = r.nextInt(totalCities - firstPoint) + firstPoint;

        for (int i = firstPoint; i <= secondPoint; i++) {
            child1[i] = parent1[i];
            child2[i] = parent2[i];
            citiesInChild1.add(parent1[i]);
            citiesInChild2.add(parent2[i]);
        }


        int counter_child1 = secondPoint+1;
        for (int i = secondPoint+1; i < parent1.length; i++) {
            if(counter_child1 == parent1.length) counter_child1 = 0;
            if(!citiesInChild1.contains(parent2[i])) {
                child1[counter_child1++] = parent2[i];
                citiesInChild1.add(parent2[i]);
            }
        }

        for (int i = 0; i <= secondPoint; i++) {
            if(counter_child1 == parent1.length) counter_child1 = 0;
            if(!citiesInChild1.contains(parent2[i])) {
                child1[counter_child1++] = parent2[i];
                citiesInChild1.add(parent2[i]);
            }
        }


        int counter_child2 = secondPoint+1;
        for (int i = secondPoint+1; i < parent1.length; i++) {
            if(counter_child2 == parent2.length) counter_child2 = 0;
            if(!citiesInChild2.contains(parent1[i])) {
                child2[counter_child2++] = parent1[i];
                citiesInChild2.add(parent1[i]);
            }
        }

        for (int i = 0; i <= secondPoint; i++) {
            if(counter_child2 == parent2.length) counter_child2 = 0;
            if(!citiesInChild2.contains(parent1[i])) {
                child2[counter_child2++] = parent1[i];
                citiesInChild2.add(parent1[i]);
            }
        }




        /*System.out.println("first point " + firstPoint + "\nsecond point " + secondPoint);

        System.out.println("Child 1 " + Arrays.toString(child1));
        System.out.println("Child 2 " + Arrays.toString(child2));*/


        Chromosome chr1 = new Chromosome(child1);
        children.add(chr1);
        Chromosome chr2 = new Chromosome(child2);
        children.add(chr2);

        //System.out.println("Chromo 1 " + chr1.toString());
        //System.out.println("Chromo 2 " + chr2.toString());

        return children;


    }



}
