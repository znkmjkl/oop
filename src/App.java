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
		rooms.add(new Room(2, 182l, "room22"));
		rooms.add(new Room(3, 180l, "room3"));
		rooms.add(new Room(3, 185l, "room33"));
		rooms.add(new Room(4, 300l, "room4"));
		
		h.setRooms(rooms);	
		
		for(Room r : h.getRooms()) {
			System.out.println(r.getSize());
		}
		
		System.out.println();
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(2014, 6, 18);
		end.set(2014, 6, 22);
		
		int lOsob = 2;
		
		System.out.println("Ilosc osob: " + lOsob);
		
		List<QueryResult> qr = h.findFreeRooms(start, end, lOsob);
		
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
		
//		qr = h.getCheapest(qr, 1);
		System.out.println("Cheapest: " + qr.size());
		
		for (QueryResult f : qr) {
			System.out.println(f.getPrice());
		}
		
		
	}

}
