import java.util.ArrayList;
import java.util.List;


public class App {
	
	public static void main(String[] args) {

		
		Hotel h = new Hotel();
		
		List<Room> rooms = new ArrayList<Room>();
		
		rooms.add(new Room(1, 120l, "room1"));
		rooms.add(new Room(2, 100l, "room2"));
		rooms.add(new Room(3, 80l, "room3"));
		rooms.add(new Room(4, 60l, "room4"));
		
		h.setRooms(rooms);
		
		List<QueryResult> qr = h.getResults(6);
		
		System.out.println("results: " + qr.size());
		
		for (QueryResult q : qr) {
			for(Room r : q.getRooms()) {
				System.out.print("(" + r.getSize() + " " + r.getName() + ")");
			}
			
			System.out.print(" " + q.getPrice());
			System.out.println();
		}
		

	}

}
