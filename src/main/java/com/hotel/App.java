package main.java.com.hotel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import main.java.com.hotel.impl.*;


public class App {

	public static void main(String[] args) {

		Hotel h = new Hotel();

		List<Room> rooms = new ArrayList<Room>();

		rooms.add(new Room(1, 130l, "room1"));
		rooms.add(new Room(2, 180l, "room2"));
		rooms.add(new Room(2, 180l, "room22"));
		rooms.add(new Room(3, 190l, "room3"));
		rooms.add(new Room(3, 185l, "room33"));
		rooms.add(new Room(4, 100l, "room4"));

		h.setRooms(rooms);

		for (Room r : h.getRooms()) {
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
			for (Room r : q.getRooms()) {
				System.out.print("(" + r.getSize() + " " + r.getName() + ")");
			}

			System.out.print(" " + q.getPrice());
			System.out.println();
		}

		Person p = new Person();
		p.setFirstName("Jan");
		p.setSecondName("Nowak");
		p.setEmail("jan_nowak@gmail.com");
		p.setAddress("Krakow, ul. Nowakowska 31a");
		h.reserve(start, end, qr.get(0), p);

		System.out.println("Cheapest: " + qr.size());

		for (QueryResult f : qr) {
			System.out.println(f.getPrice());
		}
		
		
		/*  */
		Hotel hotel = new Hotel();
		Room r1 = new Room(1, 120L, "room1");
		hotel.add(r1);

		Room r2 = new Room(2, 180L, "room2");
		hotel.add(r2);

		Room r3 = new Room(2, 180L, "room3");
		hotel.add(r3);

		Room r4 = new Room(4, 300L, "room4");
		hotel.add(r4);

		Calendar start1 = Calendar.getInstance();
		Calendar end2 = Calendar.getInstance();

		start1.set(2014, 6, 18);
		end2.set(2014, 6, 22);

		List<QueryResult> result = hotel.findFreeRooms(start1, end2, 3);

		//hotel.reserve(start, end, result.get(0), p);

		

		List<QueryResult> qr2 = hotel.findFreeRooms(start, end, 1);
		for (QueryResult q : qr2) {
			for (Room r : q.getRooms()) {
				System.out.print("(" + r.getSize() + " " + r.getName() + ")");
			}

			System.out.print(" " + q.getPrice());
			System.out.println();
		}
		//hotel.reserve(start, end, result2.get(0), p);

	}

}
