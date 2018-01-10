import java.util.*;

public class Movie
{
	private String _name;
	private ArrayList<Actor> _movieCast;
	
	public Movie(String name)
	{
		_name = name;
		_movieCast = new ArrayList<Actor>();
	}
	
	public void add(Actor a)
	{
		_movieCast.add(a);
	}
	
	public String getName()
	{
		return _name;
	}
	
	public ArrayList<Actor> getCast()
	{
		return _movieCast;
	}
	
	public void connectCast()
	{
		for(Actor current : _movieCast)
		{
			for(Actor other : _movieCast)
			{
				current.connectWith(other);
			}
		}
	}


	
}
