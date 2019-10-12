package TSP;
import java.util.*;

public class Crossover {

   public Chromosome scx (Chromosome p1, Chromosome p2, City[] city) {
      City[] parent1 = p1.getArray();
      City[] parent2 = p2.getArray();
      City[] child1 = new City[parent1.length];
      ArrayList<City> citiesNotInChild1 = new ArrayList<>();
      City ct = new City();

      int p1_temp = 0;
      int p2_temp = 0;
      int next_p1;
      int next_p2;

      for (int i = 0; i < parent1.length; i++) {
         citiesNotInChild1.add(city[i]);
      }


      for (int i = 0; i < parent1.length; i++) {
         if(parent1[i].getName().equals("1")) p1_temp = i;
         if(parent2[i].getName().equals("1")) p2_temp = i;
      }

      child1[0] = parent1[p1_temp];
      citiesNotInChild1.remove(p1_temp);
      System.out.println(citiesNotInChild1.toString());


      for (int i = 1; i < parent1.length; i++) {
         if (p1_temp == parent1.length - 1) {

         }


         if (ct.distance())

      }






      return new Chromosome(child1);
   }

}



/*    HashSet<City> citiesInChild = new HashSet<>();

      ArrayList<City> citiesNotInChild = new ArrayList<>();

      ArrayList<Chromosome> child = new ArrayList<>();
      int totalCities = parent1.length;*/