import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import impl.*;

public class App {
	
	public static void main(String[] args) {

		
		Hotel h = new Hotel();
		
		List<Room> rooms = new ArrayList<Room>();
		
		rooms.add(new Room(1, 130l, "room1"));
		rooms.add(new Room(2, 180l, "room2"));
		rooms.add(new Room(2, 180l, "room3"));
		rooms.add(new Room(4, 300l, "room4"));		
		
		h.setRooms(rooms);	
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(2014, 6, 18);
		end.set(2014, 6, 22);
		
		List<QueryResult> qr = h.findFreeRooms(start, end, 3);
		
		System.out.println("results: " + qr.size());
		
		for (QueryResult q : qr) {
			for(Room r : q.getRooms()) {
				System.out.print("(" + r.getSize() + " " + r.getName() + ")");
			}
			
			System.out.print(" " + q.getPrice());
			System.out.println();
		}
		Person p = new Person();
		 p.setfirstName("Jan");
		 p.setSecondName("Nowak");
		 p.setEmail("jan_nowak@gmail.com");
		 p.setAdress("Krakow, ul. Nowakowska 31a");
		h.reserve(start, end, qr.get(0), p);

	}

}
