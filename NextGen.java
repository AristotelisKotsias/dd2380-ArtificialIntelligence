package TSP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class NextGen {
    private Population pop;
    private PriorityQueue<Chromosome> chromsWithChildren = new PriorityQueue<>();
    HashSet<Chromosome> chromoHashSet;

    Crossover cr = new Crossover();
    Chromosome [] previousGeneration;

    public NextGen(Population pop) {
        this.pop = pop;
    }

    public void createGen() {
        previousGeneration = pop.getChromosomes();
        chromoHashSet = new HashSet<>();
        Chromosome child;

        for (int i = 0; i < previousGeneration.length; i++) {
            if (!chromoHashSet.contains(previousGeneration[i])) {
                System.out.println("Chrom " + i + ": " + Arrays.toString(previousGeneration[i].getArray()));
                chromoHashSet.add(previousGeneration[i]);
                chromsWithChildren.add(previousGeneration[i]);
            }
        }

        System.out.println("-----");
        for (int i = 0; i < previousGeneration.length; i+=2) {
            child = cr.scx(previousGeneration[i], previousGeneration[i+1]);
            System.out.println("Child " + i + ": " + Arrays.toString(child.getArray()));
            if (!chromoHashSet.contains(child)) {
                chromoHashSet.add(child);
                chromsWithChildren.add(child);
            }
        }

        pop.clear();
        for (int i = 0; i < previousGeneration.length; i++) {
            pop.add(chromsWithChildren.poll());
        }
        chromsWithChildren.clear();
    }
}
