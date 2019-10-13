package TSP;

import java.util.*;
import java.util.Arrays;

import static TSP.Input.DataSet.*;


public class Main {

    public static void main(String[] args) {

        Input in = new Input();
        Crossover.citiesNotInChild = new ArrayList<>(Arrays.asList(in.getCities(burma14)));
        Matrix.populate_matrix(in.getCities(burma14));

        Chromosome chr = new Chromosome(in.getCities(burma14),new Random());
        Chromosome twoChr = new Chromosome(in.getCities(burma14),new Random());
        /*Chromosome threeChr = new Chromosome(twoChr);
        Chromosome fourChr = new Chromosome(threeChr);
        Chromosome fifthChr = new Chromosome(fourChr);
        System.out.println(Arrays.toString(chr.getArray()));
        System.out.println(Arrays.toString(twoChr.getArray()));
        System.out.println(Arrays.toString(threeChr.getArray()));
        System.out.println(Arrays.toString(fourChr.getArray()));
        System.out.println(Arrays.toString(fifthChr.getArray()));


        pop.add(chr);
        pop.add(twoChr);
        pop.add(threeChr);
        pop.add(fourChr);
        pop.add(fifthChr);*/
        Population pop = new Population(10);
        Crossover cr = new Crossover();
        System.out.println("--------- Matrix ---------");
        for (int i = 0; i < Matrix.distances.length; i++) {
            System.out.println(Arrays.toString(Matrix.distances[i]));
        }

        System.out.println("-------------------------");

        Chromosome newChr = cr.scx(chr,twoChr);

        for (int i = 0; i < 10; i++) {
            pop.add(new Chromosome(in.getCities(burma14),new Random()));
        }
//       System.out.println(pop.toString());
        System.out.println(Arrays.toString(chr.getArray()));
        System.out.println(Arrays.toString(twoChr.getArray()));
        System.out.println(Arrays.toString(newChr.getArray()));
    }
}
