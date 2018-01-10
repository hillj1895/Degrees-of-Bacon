
public class Actor
{
	private String _name;
	private ConnectionMap _connections;
	private int _personNumber; // Generic Bacon Number
	
	// Actor constructor
	public Actor(String name)
	{
		_name = name;
		_connections = new ConnectionMap();
		_personNumber = -1;
	}
	
	public String getName()
	{
		return _name;
	}
	
	// Adds actor to this actor's adjacency map if it is not this actor
	public void connectWith(Actor a)
	{
		if(!_name.equals(a.getName()))
		{
			_connections.put(a.getName(), a); // Don't add a connection if it is the current actor
		}
	}

	
	// Checks if an actor is already in this actors connection list
	public boolean hasConnection(Actor a)
	{
		return _connections.hasName(a.getName());  // Return a comparison of the arguments actor's name with this actor's name
	}
	
	public ConnectionMap getConnectionsMap()
	{
		return _connections;
	}
	
	// Prints all of an actors connections
	public String getConnectionsString()
	{
		String s = "";
		for(Actor a : _connections.values())
		{
			s += a.getName() + " | ";
		}
		return s;
	}
	
	
	// Changed hash code to be based on the actors name to minimize collisions
	@Override
	public int hashCode()
	{
		int hash=0;
		for(int i=0;i<_name.length();i++)
		{
			hash = 33*hash + (int)_name.charAt(i);
		}
		return Math.abs(hash);
	}
	
	// Prints infinity if an actor's person number is less than one after all person
	// numbers have been assigned
	public String getPersonNumberString()
	{
		if(_personNumber == -1)
		{
			return "infinity";
		}
		return Integer.toString(_personNumber);
	}
	
	/**
	 * Overriding this method compares the names of two Actors to see if they are the same person
	 */
	@Override
	public boolean equals(Object o)
	{
		return ((Actor) o).getName().equals(_name);
	}

	public int getPersonNumber()
	{
		return _personNumber;
	}

	public void setPersonNumber(int personNumber)
	{
		_personNumber = personNumber;
	}
}
