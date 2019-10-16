How to run:
	-Go to Main class and change the desired parameters.
	-The code file contains the bytecodes (it is compiled) so you only need to run the following command in the terminal:
		$ java TSP/Main
	-In order to change which crossover to run, in the Main class, you need to change the boolean variable isOx to true for OX or false for SCX.
	-The various Data Sets are in the TSP file, but in the code if you need to change it, you need to go to the class Main and change the file 
	DataSet to either berlin52, bier127 or a280. 

Brief description
-Main class: The runnable class
-Input class: Reads the .tsp files and extracts the euclidean coordinates of the sites which are used to calculate the distances between cities (genes)
-Gene class: Creates a gene with name and x,y coordinates
-GeneticAlgorithm class: Contains the GA steps and writes the results to csv files
-Crossover clas: Contains the SCX crossover operator
-Chromosome class: Creates a chromosome by combining genes
-Matrix class: Contains the symmetric matrix with the distances between the genes
-Mutation class: Mutates a chromosome by randomly swapping 6 of its genes
-NextGen class: Creates the next generation
-OX class: Contains the OX crossover operator
-Population class: Creates a population of chromosomes
