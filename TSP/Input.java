package TSP;

import java.io.*;

/* Class that reads the tsp files, extract the coordinates and saves them into an array
 *
 */

public class Input {


    public static Gene[] getGenes(DataSet dataSet) {

        String dataSetName;
        int startingLine;

        if (dataSet == DataSet.burma14) {
            dataSetName = "burma14.tsp";
            startingLine = 8;
        } else if (dataSet == DataSet.bays29) {
            dataSetName = "bays29.tsp";
            startingLine = 38;
        } else if (dataSet == DataSet.bier127) {
            dataSetName = "bier127.tsp";
            startingLine = 6;
        } else if (dataSet == DataSet.att48) {
            dataSetName = "att48.tsp";
            startingLine = 6;
        } else if (dataSet == DataSet.a280) {
            dataSetName = "a280.tsp";
            startingLine = 6;
        } else {
            dataSetName = "berlin52.tsp";
            startingLine = 6;
        }

        String[] lines = read(dataSetName).split("\n");
        String[] words = lines[3].split(" ");
        int numOfCities = Integer.parseInt(words[words.length - 1]);
        Gene[] cities = new Gene[numOfCities];

        for (int i = startingLine; i < startingLine + numOfCities; i++) {
            String[] line = removeWhiteSpace(lines[i]).trim().split(" ");
            int x = (int) Math.round(Double.parseDouble(line[1].trim()));
            int y = (int) Math.round(Double.parseDouble(line[2].trim()));
            Gene gene = new Gene(line[0], x, y);
            cities[i - startingLine] = gene;
        }

        return cities;
    }

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
        a280,
        bier127,
        berlin52
    }

}
