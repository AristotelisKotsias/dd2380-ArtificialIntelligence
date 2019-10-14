package TSP;

public class Mutation {

    public Chromosome mutate(Chromosome chromosome){
        City [] cities = chromosome.getArray();
        int len = cities.length;
        int fromIndex = (int) (Math.random()*len);
        int toIndex = (int) (Math.random()*len);

        swap(cities, fromIndex, toIndex);

        return new Chromosome(cities);
    }

    private static void swap (City[] cities, int i, int j) {
        City temp = cities[i];
        cities[i] = cities[j];
        cities[j] = temp;
    }
}
