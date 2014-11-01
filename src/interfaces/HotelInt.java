package interfaces;

import impl.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public interface HotelInt {
	
	public List<Room> getRooms(); 

	public void setRooms(List<Room> rooms);

	public void add(Room room);
	 
	public Room room(String name);	 
	
	public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons); 
	
	public void reserve(Calendar start, Calendar end, QueryResult result, Person person);	
	 
}
