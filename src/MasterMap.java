import java.util.*;

public class MasterMap extends HashMap<String, Actor>
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> _ccSizes;	// Keeps track of the different connected component sizes
	
	public MasterMap()
	{ 
		super();
		_ccSizes = new ArrayList<Integer>();
	}
	
	public String getAllActors()
	{
		String s = " ";
		for(Actor a : this.values())
		{
			s += a.getName() + " | ";
		}
		return s;
	}
	
	
	public void setBaconNumbers(int depth)
	{
		this.BFS(this.get("Bacon, Kevin"), depth);
	}
	
	public void setPersonNumbers(String name, int depth)
	{
		this.BFS(this.get(name), depth);
	}
	
	
	// Sets person Numbers
	public void BFS(Actor start, int maxDepth)
	{
		ConnectedComponent cc = new ConnectedComponent();
		cc.increaseSize();
		
		HashMap<Actor, Boolean> discovered = new HashMap<Actor, Boolean>();
		ArrayList<ArrayList<Actor>> lists = new ArrayList<ArrayList<Actor>>();
		int layerCounter = 0;
		
		ArrayList<Actor> firstLayer = new ArrayList<Actor>();
		lists.add(layerCounter, firstLayer);
		
		start.setPersonNumber(layerCounter);
		discovered.put(start, true);
		lists.get(layerCounter).add(start);
		
		while((lists.get(layerCounter).size() > 0) && layerCounter < maxDepth)
		{
			int nextLayerCounter = layerCounter + 1;
			ArrayList<Actor> nextList = new ArrayList<Actor>();
			lists.add(nextLayerCounter, nextList);
			
			for(Actor a : lists.get(layerCounter))
			{
				cc.increaseSize();
				
				for(Actor aj : a.getConnectionsMap().values())
				{
					if(!discovered.containsKey(aj))
					{
						discovered.put(aj, true);
						nextList.add(aj);
						aj.setPersonNumber(nextLayerCounter);
					}
				}
			}
			layerCounter++;
		}
		_ccSizes.add(cc.getSize());
		//System.out.println("This connected component has " + cc.getSize() + " nodes.");
	}
	
	public boolean hasName(String name)
	{
		return this.containsKey(name);
	}
	
	/**
	 * This method continues to call the BFS algorithm on actors that still have an infinity bacon number and
	 * helps us find the total number of connected components with their sizes. 
	 * 
	 * It also sorts the ArrayList holding these different sizes.
	 */
	public void makeConnectedComponents()
	{
		int numComps = 1;
		
		// Call BFS on values that still have an infinite person number
		for(Actor a : this.values())
		{
			if(a.getPersonNumber()==-1)
			{
				numComps++;
				BFS(a, 100);
			}
		}
		
		// Sort the list with all of the different sizes of the individual connected components
		_ccSizes.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int i : _ccSizes)
		{
			System.out.print(i + ", ");
		}
		
		System.out.println("There are " + numComps + " connected compnents in the graph.");
	}
	
	@Override
	public Actor put(String name, Actor a)
	{
		if(this.containsKey(name))
		{
			// Combine past connections with connections from this movie
			Actor a1 = this.remove(name);
			a.getConnectionsMap().addFullMap(a1.getConnectionsMap());
			a1 = a;
			return super.put(a.getName(), a);
		}
		else
		{
			return super.put(name, a);
		}
	}
	
	public void printInfo()
	{
		double zeroCounter = 0;
		for(Actor a : this.values()){
			if(a.getPersonNumber() == 0)
				zeroCounter++;
		}
		double zeroFraction = zeroCounter / this.size();
		System.out.println("0: " + zeroCounter + " person. " + "(" + zeroFraction*100 + "%)");
		

		double oneCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 1)
				oneCounter++;
		}
		double oneFraction = oneCounter / this.size();
		System.out.println("1: " + oneCounter + " people. " + "(" + oneFraction*100 + "%)");		
		
		
		double twoCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 2)
				twoCounter++;
		}
		double twoFraction = twoCounter / this.size();
		System.out.println("2: " + twoCounter + " people. " + "(" + twoFraction*100 + "%)");
		
		
		double threeCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 3)
				threeCounter++;
		}
		double threeFraction = threeCounter / this.size();
		System.out.println("3: " + threeCounter + " people. " + "(" + threeFraction*100 + "%)");
		
		
		double fourCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 4)
				fourCounter++;
		}
		double fourFraction = fourCounter / this.size();
		System.out.println("4: " + fourCounter + " people. " + "(" + fourFraction*100 + "%)");
		
		
		double fiveCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 5)
				fiveCounter++;
		}
		double fiveFraction = fiveCounter / this.size();
		System.out.println("5: " + fiveCounter + " people. " + "(" + fiveFraction*100 + "%)");
		
		
		double sixCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 6)
				sixCounter++;
		}
		double sixFraction = sixCounter / this.size();
		System.out.println("6: " + sixCounter + " people. " + "(" + sixFraction*100 + "%)");
		
		
		double sevenCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 7)
				sevenCounter++;
		}
		double sevenFraction = sevenCounter / this.size();
		System.out.println("7: " + sevenCounter + " people. " + "(" + sevenFraction*100 + "%)");
		
		
		double eightCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 8)
				eightCounter++;
		}
		double eightFraction = eightCounter / this.size();
		System.out.println("8: " + eightCounter + " people. " + "(" + eightFraction*100 + "%)");
		
		
		double nineCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 9)
				nineCounter++;
		}
		double nineFraction = nineCounter / this.size();
		System.out.println("9: " + nineCounter + " people. " + "(" + nineFraction*100 + "%)");
		
		
		double tenCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 10)
				tenCounter++;
		}
		double tenFraction = tenCounter / this.size();
		System.out.println("10: " + tenCounter + " people. " +  "(" + tenFraction*100 + "%)");
		
		
		double elevenCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == 11)
				elevenCounter++;
		}
		double elevenFraction = elevenCounter / this.size();
		System.out.println("11: " + elevenCounter + " people. " + "(" + elevenFraction*100 + "%)");
		
		double infinityCounter = 0;
		for(Actor a : this.values()) {
			if(a.getPersonNumber() == -1)
				infinityCounter++;
		}
		double infinityFraction = infinityCounter / this.size();
		System.out.println("infinity: " + infinityCounter + " people. " +  "(" + infinityFraction*100 + "%)");
	}

	public void printNumEdges()
	{
		int numEdgesTimesTwo = 0;
		for(Actor a : this.values())
		{
			numEdgesTimesTwo += a.getConnectionsMap().size();
		}
		
		int numEdges = numEdgesTimesTwo / 2;
		
		System.out.println("There are " + numEdges + " edges in the graph.");
	}
}
