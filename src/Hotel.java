import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Hotel {
	
	private List<Room> rooms = new ArrayList<Room>();
	
	 public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	void add(Room room) {
		 rooms.add(room);
	 }
	 
	 public Room room(String name) {
		 return new Room();
	 }
	 
	 public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons) {
		 
		 List<QueryResult> result = new ArrayList<QueryResult>();
		 
		 int availableSpots = 0;
		 
		 QueryResult qr = new QueryResult();
		 
		 long diffs = end.getTimeInMillis() - start.getTimeInMillis();
		 
		 long nights = diffs / (24 * 60 * 60 * 1000);		 
		 
		 for(Room r : getRooms()) {
			  
			 
			 if (r.getSize() >= n_persons) {
			 	List<Room> rooms = new ArrayList<Room>();
				rooms.add(r);
						 
				qr.setRooms(rooms);
				qr.setPrice((int)nights * 180); 	
				result.add(qr);
			 }
		 }
		 
		 return result;
	 }
	 
	 public void reserve(Calendar start, Calendar end, QueryResult result, Person person){
		 for(Room r : result.getRooms()){
			 r.setPerson(person);
		 }
	 }
}
     


       