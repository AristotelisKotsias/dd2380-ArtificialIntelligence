package TSP;

import java.util.*;

public class NextGen {
    private Population pop;
    private PriorityQueue<Chromosome> nextGeneration = new PriorityQueue<>();
    HashSet<Chromosome> chromoHashSet;
    Mutation mutation = new Mutation();
    int prob_crossover = 90;
    double prob_mutations = 1;

    Crossover cr = new Crossover();
    Chromosome [] previousGeneration;

    private int lenOfPQ;

    public NextGen(Population pop) {
        this.pop = pop;
    }

    public void createGen() {
        previousGeneration = pop.getChromosomes();
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
            if ((Math.random()*100)<prob_crossover){

                child = cr.scx(previousGeneration[i], previousGeneration[i+1]);
                // (int)(Math.random()*lenOfPQ)
                if (!chromoHashSet.contains(child)) {
                    chromoHashSet.add(child);
                    nextGeneration.add(child);
                }
            }
        }

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
