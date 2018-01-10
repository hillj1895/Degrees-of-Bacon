import java.util.HashMap;

public class ConnectedComponent extends HashMap<String, Actor>
{
	private static final long serialVersionUID = 1L;
	private int _size;
	
	public ConnectedComponent()
	{
		_size = 0;
	}
	
	public void increaseSize()
	{
		_size++;
	}
	
	public int getSize()
	{
		return _size;
	}
}
