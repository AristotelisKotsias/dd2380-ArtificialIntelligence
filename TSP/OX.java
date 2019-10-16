package TSP;

import java.util.*;

public class OX {

    public ArrayList<Chromosome> orderCrossover (Chromosome p1, Chromosome p2, Random random) {
        Gene[] parent1 = p1.getArray();
        Gene[] parent2 = p2.getArray();

        HashSet<Gene> genesInChild1 = new HashSet<>();
        HashSet<Gene> genesInChild2 = new HashSet<>();

        Gene[] child1 = new Gene[parent1.length];
        Gene[] child2 = new Gene[parent2.length];

        ArrayList<Chromosome> children = new ArrayList<>();
        int totalGenes = parent1.length;

        int firstPoint = random.nextInt(totalGenes);
        int secondPoint = random.nextInt(totalGenes - firstPoint) + firstPoint;

        //Clone the chosen part from parent to the child
        for (int i = firstPoint; i <= secondPoint; i++) {
            child1[i] = parent1[i];
            child2[i] = parent2[i];
            genesInChild1.add(parent1[i]);
            genesInChild2.add(parent2[i]);
        }

        //Fill in the child with the rest genes
        int counter_child1 = secondPoint+1;
        for (int i = secondPoint+1; i < parent1.length; i++) {
            if(counter_child1 == parent1.length) counter_child1 = 0;
            if(!genesInChild1.contains(parent2[i])) {
                child1[counter_child1++] = parent2[i];
                genesInChild1.add(parent2[i]);
            }
        }

        for (int i = 0; i <= secondPoint; i++) {
            if(counter_child1 == parent1.length) counter_child1 = 0;
            if(!genesInChild1.contains(parent2[i])) {
                child1[counter_child1++] = parent2[i];
                genesInChild1.add(parent2[i]);
            }
        }

        int counter_child2 = secondPoint+1;
        for (int i = secondPoint+1; i < parent1.length; i++) {
            if(counter_child2 == parent2.length) counter_child2 = 0;
            if(!genesInChild2.contains(parent1[i])) {
                child2[counter_child2++] = parent1[i];
                genesInChild2.add(parent1[i]);
            }
        }

        for (int i = 0; i <= secondPoint; i++) {
            if(counter_child2 == parent2.length) counter_child2 = 0;
            if(!genesInChild2.contains(parent1[i])) {
                child2[counter_child2++] = parent1[i];
                genesInChild2.add(parent1[i]);
            }
        }
        Chromosome chr1 = new Chromosome(child1);
        children.add(chr1);
        Chromosome chr2 = new Chromosome(child2);
        children.add(chr2);

        return children;

    }

}
