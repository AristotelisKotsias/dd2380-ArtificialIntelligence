package TSP;

import java.util.*;

public class Crossover {

    Gene[] parent1;
    Gene[] parent2;
    Gene[] child;
    int len;
    static ArrayList<Gene> geneNotInChildCloned;
    static ArrayList<Gene> geneNotInChild;

    public Chromosome scx(Chromosome p1, Chromosome p2) {
        geneNotInChildCloned = (ArrayList<Gene>) geneNotInChild.clone();
        parent1 = p1.getArray();
        parent2 = p2.getArray();
        len = parent1.length;
        child = new Gene[len];

        int legitimate_gene1;
        int legitimate_gene2;

        int parent1_pos = newParentPosition(parent1, 1);
        int parent2_pos = newParentPosition(parent2, 1);

        child[0] = parent1[parent1_pos];
        geneNotInChildCloned.remove(0);

        int element, indexOfElement;

        for (int i = 1; i < len; i++) {

            element = Integer.parseInt(child[i - 1].getName());

            if (isLegitimate(parent1, parent1_pos + 1)) {
                legitimate_gene1 = Integer.parseInt(parent1[parent1_pos + 1].getName());

            }else{
                legitimate_gene1 = Integer.parseInt(geneNotInChildCloned.get(0).getName());
            }

            if (isLegitimate(parent2, parent2_pos +1)) {
                legitimate_gene2 = Integer.parseInt(parent2[parent2_pos + 1].getName());
            } else {
                legitimate_gene2 = Integer.parseInt(geneNotInChildCloned.get(0).getName());
            }
            //System.out.println("Leg1 => " + legitimate_city1 + "\n leg2 => " + legitimate_city2 + "\n el => " + element);
            if (Matrix.distances[element][legitimate_gene1] <= Matrix.distances[element][legitimate_gene2]) {
                parent1_pos = newParentPosition(parent1, legitimate_gene1);
                parent2_pos = newParentPosition(parent2, legitimate_gene1);
                child[i] = parent1[parent1_pos];
                indexOfElement = geneNotInChildCloned.indexOf(child[i]);
                geneNotInChildCloned.remove(indexOfElement);
            } else {
                parent1_pos = newParentPosition(parent1, legitimate_gene2);
                parent2_pos = newParentPosition(parent2, legitimate_gene2);
                child[i] = parent2[parent2_pos];
                indexOfElement = geneNotInChildCloned.indexOf(child[i]);
                geneNotInChildCloned.remove(indexOfElement);
            }
        }
        return new Chromosome(child);
    }


    private boolean isLegitimate(Gene[] parent, int pos) {
        if (pos >= len) return false;
        if (!geneNotInChildCloned.contains(parent[pos])) return false;

        return true;
    }

    private int newParentPosition(Gene[] parent, int legitimateCity) {
        int newPos = 0;
        String cityName = Integer.toString(legitimateCity);
        for (int i = 0; i < len; i++) {
            if (parent[i].getName().equals(cityName)) newPos = i;
        }
    return newPos;
    }

}
