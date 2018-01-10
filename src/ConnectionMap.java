import java.util.HashMap;

public class ConnectionMap extends HashMap<String, Actor>
{
	private static final long serialVersionUID = 1L;

	public ConnectionMap()
	{
		super();
	}
	
	// Prints a string with all of the actors in this connection map
	public String getAllActors()
	{
		String s = " ";
		for(Actor a : this.values())
		{
			s += a.getName() + " | ";
		}
		return s;
	}
	
	public ConnectionMap getConnectionMap()
	{
		return this;
	}
	
	@Override
	public Actor put(String key, Actor a)
	{
		if(this.containsKey(key))
		{
			return null;		// Don't add actor to connection list if it is already there
		}
		else
		{
			return super.put(key, a);
		}
	}

	public boolean hasName(String name)
	{
		return this.containsKey(name);
	}

	// Add all connections from incoming connections map to this one
	public void addFullMap(ConnectionMap incomingMap)
	{
		for(Actor a : incomingMap.values())
		{
			this.put(a.getName(), a);
		}
	}
}