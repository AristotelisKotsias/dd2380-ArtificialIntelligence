package TSP;

import java.util.*;

public class Crossover {

    City[] parent1;
    City[] parent2;
    City[] child;
    int len;
    static ArrayList<City> citiesNotInChildCloned;
    static ArrayList<City> citiesNotInChild;

    public Chromosome scx(Chromosome p1, Chromosome p2) {
        citiesNotInChildCloned = (ArrayList<City>) citiesNotInChild.clone();
        parent1 = p1.getArray();
        parent2 = p2.getArray();
        len = parent1.length;
        child = new City[len];

        int legitimate_city1;
        int legitimate_city2;

        int parent1_pos = newParentPosition(parent1, 1);
        int parent2_pos = newParentPosition(parent2, 1);

        child[0] = parent1[parent1_pos];
        //System.out.println(Arrays.toString(citiesNotInChildCloned.toArray()));
        citiesNotInChildCloned.remove(0);

        //System.out.println(citiesNotInChild.toString());

        int element, indexOfElement;

        for (int i = 1; i < len; i++) {

            element = Integer.parseInt(child[i - 1].getName());

            if (isLegitimate(parent1, parent1_pos + 1)) {
                legitimate_city1 = Integer.parseInt(parent1[parent1_pos + 1].getName());

            }else{
                legitimate_city1 = Integer.parseInt(citiesNotInChildCloned.get(0).getName());
            }

            if (isLegitimate(parent2, parent2_pos +1)) {
                legitimate_city2 = Integer.parseInt(parent2[parent2_pos + 1].getName());
            } else {
                legitimate_city2 = Integer.parseInt(citiesNotInChildCloned.get(0).getName());
            }
            //System.out.println("Leg1 => " + legitimate_city1 + "\n leg2 => " + legitimate_city2 + "\n el => " + element);
            if (Matrix.distances[element][legitimate_city1] >= Matrix.distances[element][legitimate_city2]) {
                parent1_pos = newParentPosition(parent1, legitimate_city1);
                parent2_pos = newParentPosition(parent2, legitimate_city1);
                child[i] = parent1[parent1_pos];
                indexOfElement = citiesNotInChildCloned.indexOf(child[i]);
                citiesNotInChildCloned.remove(indexOfElement);
            } else {
                parent1_pos = newParentPosition(parent1, legitimate_city2);
                parent2_pos = newParentPosition(parent2, legitimate_city2);
                child[i] = parent2[parent2_pos];
                indexOfElement = citiesNotInChildCloned.indexOf(child[i]);
                citiesNotInChildCloned.remove(indexOfElement);
            }
        }
        return new Chromosome(child);
    }


    private boolean isLegitimate(City[] parent, int pos) {
        if (pos >= len) return false;
        if (!citiesNotInChildCloned.contains(parent[pos])) return false;

        return true;
    }

    private int newParentPosition(City[] parent, int legitimateCity) {
        int newPos = 0;
        String cityName = Integer.toString(legitimateCity);
        for (int i = 0; i < len; i++) {
            if (parent[i].getName().equals(cityName)) newPos = i;
        }
    return newPos;
    }

}
