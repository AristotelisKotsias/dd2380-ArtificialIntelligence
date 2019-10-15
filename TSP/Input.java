package TSP;

import java.io.*;

public class Input {

    /**
     * Read the data set and return an array of City objects.
     *
     * @param dataSet The data set to read
     * @return The City objects contained within the data set
     */
    public static City[] getCities(DataSet dataSet) {

        String dataSetName;
        int startingLine;

        if (dataSet == DataSet.burma14) {
            dataSetName = "burma14.tsp";
            startingLine = 8;
        } else if (dataSet == DataSet.bays29) {
            dataSetName = "bays29.tsp";
            startingLine = 38;
        } else if (dataSet == DataSet.att48) {
            dataSetName = "att48.tsp";
            startingLine = 6;
        } else {
            dataSetName = "berlin52.tsp";
            startingLine = 6;
        }

        String[] lines = read(dataSetName).split("\n");
        String[] words = lines[3].split(" ");
        int numOfCities = Integer.parseInt(words[words.length - 1]);
        City[] cities = new City[numOfCities];

        for (int i = startingLine; i < startingLine + numOfCities; i++) {
            String[] line = removeWhiteSpace(lines[i]).trim().split(" ");
            int x = (int) Math.round(Double.parseDouble(line[1].trim()));
            int y = (int) Math.round(Double.parseDouble(line[2].trim()));
            City city = new City(line[0], x, y);
            cities[i - startingLine] = city;
        }

        return cities;
    }

    //Remove dublicate white spaces
    private static String removeWhiteSpace(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                if (i != s.length()) {
                    s = s.substring(0, i) + s.substring(i + 1, s.length());
                    i--;
                } else {
                    s = s.substring(0, i);
                    i--;
                }
            }
        }
        return s;
    }

    private static String read(String fileName) {
        InputStream stream = Input.class.getResourceAsStream(fileName);
        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public enum DataSet {
        burma14,
        att48,
        bays29,
        berlin52
    }

}
