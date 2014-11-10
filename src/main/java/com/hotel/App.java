package com.hotel;

import java.util.ArrayList;
import java.util.List;

import com.hotel.impl.*;

public class App {

	public static void main(String[] args) {

		Hotel h = new Hotel();

		List<Room> rooms = new ArrayList<Room>();

		rooms.add(new Room(1, 130l, "room1"));
		rooms.add(new Room(2, 180l, "room2"));
		rooms.add(new Room(2, 180l, "room22"));
		rooms.add(new Room(3, 190l, "room33"));
		rooms.add(new Room(3, 185l, "room3"));
		rooms.add(new Room(4, 100l, "room4"));

		System.out.println("room1".hashCode());
		System.out.println("room2".hashCode());
		System.out.println("room22".hashCode());
		System.out.println("room33".hashCode());
		System.out.println("room3".hashCode());
		System.out.println("room4".hashCode());

		h.setRooms(rooms);
		h.add(new Room("room1"));

	}

}
