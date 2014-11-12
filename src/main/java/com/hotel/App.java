package com.hotel;

import java.util.ArrayList;
import java.util.List;

import com.hotel.impl.Hotel;
import com.hotel.impl.Room;

public class App {

	public static void main(String[] args) {

		Hotel hotel = new Hotel(new Room(1, 130l, "room1"), new Room(2, 180l, "room2"), new Room(2, 200l, "room22"), new Room(3, 240l, "room3"), new Room(4, 320l, "room4"));
		
	}

}
