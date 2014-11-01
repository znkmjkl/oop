package interfaces;

import impl.*;

import java.util.List;

public interface QueryResultInt {	
	
	public void setRooms(List<Room> rooms);

	public void setPrice(long price);
	
	public List<Room> getRooms();
	
    public long getPrice();
}
