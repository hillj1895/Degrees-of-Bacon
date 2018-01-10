import java.io.*;
import java.util.*;

/**
 * Joseph Hill
 * CSE 3500: Algorithms and Complexity
 * Programming Assignment #1: Degrees of Bacon
 * 
 * 
 * @author Joe
 */

public class Main
{
	public static void main(String[] args)
	{
		// Construct the graph
		MasterMap allActors1 = initializeAll();
		
		// Set Bacon Numbers, stopping at layer 50
		allActors1.setBaconNumbers(50);
		
		// Prints the different bacon number percentages
		allActors1.printInfo();
		
		// Prints the number of edges
		allActors1.printNumEdges();
		
		// Makes all connected components and prints the size of them
		allActors1.makeConnectedComponents();
	}
	
	
	/**
	 * 
	 * This method reads the input text file and makes new movie and actor instances
	 * using the names that it reads from the file
	 * 
	 * @return MasterMap with all actors added with connections
	 */
	public static MasterMap initializeAll()
	{
		MasterMap allActors = new MasterMap();
		
		Scanner input1 = null;
		try {
			input1 = new Scanner(new File("src/bacon.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input1.hasNextLine())
		{
			String line = input1.nextLine();
			String[] splitNameLine = line.split("/");
			
			// Make a new movie with the first string in the parsed line
			Movie m = new Movie(splitNameLine[0]);
			
			// Make a new actor for each name in the line after the movie title and add that new actor to the current movie's cast
			for(int i=1; i<splitNameLine.length; i++)
			{
				Actor a = allActors.get(splitNameLine[i]);
				if(a == null)
				{
					a = new Actor(splitNameLine[i]);
					allActors.put(splitNameLine[i], a);
				}
				
				m.add(a);
			}
			
			// Form connections between all actors
			m.connectCast();
			
		}
		
		Scanner input2 = null;
		try {
			input2 = new Scanner(new File("src/top-grossing.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input2.hasNextLine())
		{
			String line = input2.nextLine();
			String[] splitNameLine = line.split("/");
			
			// Make a new movie with the first string in the parsed line
			Movie m = new Movie(splitNameLine[0]);
			
			// Make a new actor for each name in the line after the movie title and add that new actor to the current movie's cast
			for(int i=1; i<splitNameLine.length; i++)
			{
				Actor a = allActors.get(splitNameLine[i]);
				if(a == null)
				{
					a = new Actor(splitNameLine[i]);
					allActors.put(splitNameLine[i], a);
				}
				m.add(a);
			}
			// Form connections between all actors
			m.connectCast();
		}
		
		Scanner input3 = null;
		try {
			input3 = new Scanner(new File("src/all.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input3.hasNextLine())
		{
			String line = input3.nextLine();
			String[] splitNameLine = line.split("/");
			
			// Make a new movie with the first string in the parsed line
			Movie m = new Movie(splitNameLine[0]);
			
			// Make a new actor for each name in the line after the movie title and add that new actor to the current movie's cast
			for(int i=1; i<splitNameLine.length; i++)
			{
				Actor a = allActors.get(splitNameLine[i]);
				if(a == null)
				{
					a = new Actor(splitNameLine[i]);
					allActors.put(splitNameLine[i], a);
				}
				
				m.add(a);
			}
			
			// Form connections between all actors
			m.connectCast();
			
		}
		return allActors;
	}
	
	
	/**
	 * This method was used to test the different aspects of the program on a smaller scale
	 */
	public static void troubleShoot()
	{
		MasterMap allActors = new MasterMap();
		
		Movie m1 = new Movie("");
		Movie m2 = new Movie("");
		Movie m3 = new Movie("");
		Movie m4 = new Movie("");
		Movie m5 = new Movie("");
		
		m1.add(new Actor("Joe1"));
		m1.add(new Actor("Joe2"));
		m1.add(new Actor("Joe3"));		//Repeat
		m1.connectCast();
		
		for(Actor a : m1.getCast())
		{
			allActors.put(a.getName(), a);
		}
		
		m2.add(new Actor("Joe3"));		//Repeat
		m2.add(new Actor("Joe4"));
		m2.add(new Actor("Joe5"));		//Repeat
		m2.connectCast();
		
		for(Actor a : m2.getCast())
		{
			allActors.put(a.getName(), a);
		}
		
		m3.add(new Actor("Joe5"));		//Repeat
		m3.add(new Actor("Joe6"));
		m3.add(new Actor("Joe7"));
		m3.connectCast();
		
		for(Actor a : m3.getCast())
		{
			allActors.put(a.getName(), a);
		}
		
		m4.add(new Actor("Joe10"));		//Repeat
		m4.add(new Actor("Joe12"));
		m4.add(new Actor("Joe13"));
		m4.connectCast();
		
		for(Actor a : m4.getCast())
		{
			allActors.put(a.getName(), a);
		}
		
		
		m5.add(new Actor("Joe20"));		//Repeat
		m5.add(new Actor("Joe22"));
		m5.add(new Actor("Joe23"));
		m5.connectCast();
		
		for(Actor a : m5.getCast())
		{
			allActors.put(a.getName(), a);
		}
		
		
		allActors.setPersonNumbers("Joe5", 10);
		
		for(Actor a : allActors.values())
		{
			System.out.println(a.getName() + ": " + a.getPersonNumberString() + ": " + a.getConnectionsString());
		}
	}
	
}






