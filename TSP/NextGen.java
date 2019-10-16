package TSP;

import java.util.*;

public class NextGen {
    private Population pop;
    private PriorityQueue<Chromosome> nextGeneration = new PriorityQueue<>();
    HashSet<Chromosome> chromoHashSet;
    Mutation mutation = new Mutation();
    int prob_crossover;
    double prob_mutations;

    Crossover cr = new Crossover();
    OX ox = new OX();
    Chromosome [] previousGeneration;

    private int lenOfPQ;

    public NextGen(Population pop, int prob_crossover, int prob_mutations) {
        this.prob_crossover = prob_crossover;
        this.prob_mutations = prob_mutations;
        this.pop = pop;
    }

    public void createGenSCX() {
        previousGeneration = pop.getChromosomes();

        //HashSet that is used in order to maintain uniqueness of the generation (duplicates should no exist)
        chromoHashSet = new HashSet<>();
        lenOfPQ = previousGeneration.length;

        Chromosome child;

        for (int i = 0; i < lenOfPQ; i++) {
            if (!chromoHashSet.contains(previousGeneration[i])) {
                chromoHashSet.add(previousGeneration[i]);
                nextGeneration.add(previousGeneration[i]);
            }
        }

        for (int i = 0; i < lenOfPQ; i+=2) {
            //Checks if the chromosomes should be crossovered according to given crossover percentage
            if ((Math.random()*100)<prob_crossover){

                //Crossover two parents and create a child
                child = cr.scx(previousGeneration[i], previousGeneration[i+1]);
                //add chromosome if it's not already included in the current generation
                if (!chromoHashSet.contains(child)) {
                    chromoHashSet.add(child);
                    nextGeneration.add(child);
                }
            }
        }
        //Delete previous generation and store current generation in order to continue the process
        pop.clear();
        for (int i = 0; i < lenOfPQ; i++) {
            if((Math.random()*100)<prob_mutations){
                //mutate
                pop.add(mutation.mutate(nextGeneration.poll()));
            }else{
                pop.add(nextGeneration.poll());
            }
        }

        nextGeneration.clear();
    }

    public void createGenOX() {
        previousGeneration = pop.getChromosomes();
        chromoHashSet = new HashSet<>();
        lenOfPQ = previousGeneration.length;

        ArrayList<Chromosome> childs;


        //System.out.println("Previous gen: " + Arrays.toString(previousGeneration));


        for (int i = 0; i < lenOfPQ; i++) {
            if (!chromoHashSet.contains(previousGeneration[i])) {
                chromoHashSet.add(previousGeneration[i]);
                nextGeneration.add(previousGeneration[i]);
            }
        }

        for (int i = 0; i < lenOfPQ; i+=2) {
            if ((Math.random()*100)<prob_crossover){


                childs = ox.orderCrossover(previousGeneration[i], previousGeneration[i+1], new Random());
                if (!chromoHashSet.contains(childs.get(0))) {
                    chromoHashSet.add(childs.get(0));
                    nextGeneration.add(childs.get(0));
                }

                if (!chromoHashSet.contains(childs.get(1))) {
                    chromoHashSet.add(childs.get(1));
                    nextGeneration.add(childs.get(1));
                }
            }
        }

        //System.out.println("Children " + chromoHashSet.toString());
        //System.out.println("next gen " + nextGeneration.toString());


        pop.clear();
        for (int i = 0; i < lenOfPQ; i++) {
            if((Math.random()*100)<prob_mutations){
                //mutate
                pop.add(mutation.mutate(nextGeneration.poll()));
            }else{
                pop.add(nextGeneration.poll());
            }
        }

        nextGeneration.clear();
    }


}
