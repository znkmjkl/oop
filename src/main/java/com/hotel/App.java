package com.hotel;

import java.util.ArrayList;
import java.util.List;

import com.hotel.impl.*;

public class App {

	public static void main(String[] args) {

		Hotel h = new Hotel(new Room(1, 130l, "room1"), new Room(2, 180l, "room2"), new Room(2, 180l, "room22"));

	}

}
