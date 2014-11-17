package com.hotel.impl;

import static junitparams.JUnitParamsRunner.$;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hotel.exceptions.RoomNameAlreadyExistsException;
import com.hotel.impl.Hotel;
import com.hotel.impl.QueryResult;
import com.hotel.impl.Room;

@RunWith(JUnitParamsRunner.class)
public class HotelTest {
	
	private Hotel hotel;
	private Hotel hotel2;
	private Hotel emptyHotel;
	
	private Calendar start;
	private Calendar end;
	
	private Person person;
	
	private static final Object[] getQueryResults() {

		List<QueryResult> queryResults1 = new ArrayList<QueryResult>();
		queryResults1.add(new QueryResult(120l*4, new Room("room1")));

		List<QueryResult> queryResults2 = new ArrayList<QueryResult>();
		queryResults2.add(new QueryResult(180l*4, new Room("room2")));
		queryResults2.add(new QueryResult(180l*4, new Room("room22")));

		List<QueryResult> queryResults3 = new ArrayList<QueryResult>();
		queryResults3.add(new QueryResult(300l*4, new Room("room4")));
		queryResults3.add(new QueryResult(300l*4, new Room("room1"), new Room("room2")));
		queryResults3.add(new QueryResult(300l*4, new Room("room1"), new Room("room22")));

		List<QueryResult> queryResults4 = new ArrayList<QueryResult>();
		queryResults4.add(new QueryResult(300l*4, new Room("room4")));

		return $(
			$(1, queryResults1),
			$(2, queryResults2),
			$(3, queryResults3),
			$(4, queryResults4)
		);
	}
	
	private static final Object[] getQueryResultsFromHotelWithReservations() {

		List<QueryResult> queryResults1 = new ArrayList<QueryResult>();
		queryResults1.add(new QueryResult(180l*2, new Room("room2")));
		
		List<QueryResult> queryResults2 = new ArrayList<QueryResult>();
		queryResults2.add(new QueryResult(180l*2, new Room("room2")));
		
		List<QueryResult> queryResults3 = new ArrayList<QueryResult>();
		queryResults3.add(new QueryResult(240l*2, new Room("room3")));
		
		List<QueryResult> queryResults4 = new ArrayList<QueryResult>();
		queryResults4.add(new QueryResult(560l*2, new Room("room4"), new Room("room3")));

		return $(
			$(1, queryResults1),
			$(2, queryResults2),
			$(3, queryResults3),
			$(7, queryResults4)
		);
	}

	@Before
	public void setUp() {
		hotel = new Hotel(new Room(1, 130l, "room1"), new Room(2, 180l, "room2"), new Room(2, 200l, "room22"), new Room(3, 240l, "room3"), new Room(4, 320l, "room4"));
		hotel2 = new Hotel(new Room(1, 120l, "room1"), new Room(2, 180l, "room2"), new Room(2, 180l, "room22"), new Room(4, 300l, "room4"));
		emptyHotel = new Hotel();
		
		start = Calendar.getInstance();
		end = Calendar.getInstance();
		start.set(2014, 6, 18);
		end.set(2014, 6, 22);
		
		person = new Person("Mateusz", "Jancarz", "mati@mati.pl", "Krakow 15");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void roomsSetterShouldThrowIAE() {
		
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room("room1"));
		rooms.add(new Room("room1"));
		
		emptyHotel.setRooms(rooms);
	}
	
	@Test(expected = RoomNameAlreadyExistsException.class)
	public void addShouldThrowRNAE() {
		emptyHotel.add(new Room("room1"));
		emptyHotel.add(new Room("room1"));
	}
	
	@Test(expected = RoomNameAlreadyExistsException.class)
	public void constructorShouldThrowRNAE() {
		new Hotel(new Room(1, 130l, "room1"), new Room(2, 180l, "room2"), new Room(2, 180l, "room2"));
	}
	

	@Test
	public void searchEmptyHotel() {
		Assert.assertEquals(0, emptyHotel.findFreeRooms(start, end, 5).size());
	}
	
	//Simple check - without any reservations
	@Test
	@Parameters(method = "getQueryResults")
	public void searchForCheapestQueryResults(int peopleNr, List<QueryResult> queryResults) {
		
		List<QueryResult> qrs = hotel2.findFreeRooms(start, end, peopleNr);
		
		Assert.assertEquals(true, qrs.equals(queryResults));
	}
	
	@Test
	@Parameters(method = "getQueryResultsFromHotelWithReservations")
	public void searchForCheapestQueryResultsInHotelWithReservations(int peopleNr, List<QueryResult> queryResults) {
		
		end.set(2014, 6, 20);
		hotel.reserve(start, end, new QueryResult(0l, new Room("room1")), person);

		Assert.assertEquals(true, hotel.findFreeRooms(start, end, peopleNr).equals(queryResults));
	}

	//TODO nadpisaæ equals() dla Person i przerobiæ test (uzyc assertEquals na obiektach Person i dodac parametryzacje)
	@Test
	public void reserve() {
		Hotel hotel = new Hotel();

		Person p = new Person();
		p.setFirstName("Jan");
		p.setSecondName("Nowak");
		p.setEmail("jan_nowak@gmail.com");
		p.setAddress("Krakow, ul. Nowakowska 31a");

		Person p2 = new Person();
		p2.setFirstName("Tomasz");
		p2.setSecondName("Poznanski");
		p2.setEmail("tomasz_poznanski@gmail.com");
		p2.setAddress("Wroclaw, ul. Prokocimska 28n");

		Person p3 = new Person();
		p3.setFirstName("Adam");
		p3.setSecondName("Nawalka");
		p3.setEmail("adam_nawalka@pzpn.pl");
		p3.setAddress("Warszawa, ul. Powstancow 40c");

		Room r1 = new Room(1, 120L, "room1");
		hotel.add(r1);

		Room r2 = new Room(2, 180L, "room2");
		hotel.add(r2);

		Room r3 = new Room(2, 175L, "room3");
		hotel.add(r3);

		Room r4 = new Room(4, 300L, "room4");
		hotel.add(r4);

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.set(2014, 6, 18);
		end.set(2014, 6, 22);
		long diff = (end.getTimeInMillis() - start.getTimeInMillis()) / (24 * 60 * 60 * 1000);
		long price = (r1.getPrice() + r3.getPrice()) * diff;

		List<QueryResult> result = hotel.findFreeRooms(start, end, 3);
		Assert.assertEquals(price, result.get(0).getPrice());
		hotel.reserve(start, end, result.get(0), p);
		Assert.assertEquals(2, hotel.getReservations().size());
		Assert.assertEquals("Jan", hotel.getReservations().get(0).getPerson().getFirstName());
		Assert.assertEquals("Nowak", hotel.getReservations().get(0).getPerson().getSecondName());
		Assert.assertEquals("jan_nowak@gmail.com", hotel.getReservations().get(0).getPerson()
				.getEmail());
		Assert.assertEquals("Krakow, ul. Nowakowska 31a", hotel.getReservations().get(0)
				.getPerson().getAddress());

		long price2 = r2.getPrice() * diff;
		List<QueryResult> result2 = hotel.findFreeRooms(start, end, 2);
		Assert.assertEquals(price2, result2.get(0).getPrice());
		hotel.reserve(start, end, result2.get(0), p2);
		Assert.assertEquals(3, hotel.getReservations().size());
		Assert.assertEquals("Tomasz", hotel.getReservations().get(2).getPerson().getFirstName());
		Assert.assertEquals("Poznanski", hotel.getReservations().get(2).getPerson().getSecondName());
		Assert.assertEquals("tomasz_poznanski@gmail.com", hotel.getReservations().get(2)
				.getPerson().getEmail());
		Assert.assertEquals("Wroclaw, ul. Prokocimska 28n", hotel.getReservations().get(2)
				.getPerson().getAddress());

		long price3 = r4.getPrice() * diff;
		List<QueryResult> result3 = hotel.findFreeRooms(start, end, 3);
		Assert.assertEquals(price3, result3.get(0).getPrice());
		hotel.reserve(start, end, result3.get(0), p3);
		Assert.assertEquals(4, hotel.getReservations().size());
		Assert.assertEquals("Adam", hotel.getReservations().get(3).getPerson().getFirstName());
		Assert.assertEquals("Nawalka", hotel.getReservations().get(3).getPerson().getSecondName());
		Assert.assertEquals("adam_nawalka@pzpn.pl", hotel.getReservations().get(3).getPerson()
				.getEmail());
		Assert.assertEquals("Warszawa, ul. Powstancow 40c", hotel.getReservations().get(3)
				.getPerson().getAddress());

		Assert.assertEquals("room1", hotel.getReservations().get(0).getRoom().name());
		Assert.assertEquals("room3", hotel.getReservations().get(1).getRoom().name());
		Assert.assertEquals("room2", hotel.getReservations().get(2).getRoom().name());
		Assert.assertEquals("room4", hotel.getReservations().get(3).getRoom().name());

	}

}
