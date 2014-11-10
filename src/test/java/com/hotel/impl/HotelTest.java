package com.hotel.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hotel.impl.Hotel;

public class HotelTest {

	@Test
	public void searchEmptyHotel() {

		Hotel hotel = new Hotel();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(2014, 6, 18);
		end.set(2014, 6, 22);

		Assert.assertEquals(0, hotel.findFreeRooms(start, end, 5).size());

	}

	@Test
	public void getCheapestQueryResults() {
		Hotel hotel = new Hotel();

		List<Room> rooms = new ArrayList<Room>();

		rooms.add(new Room(1, 130l, "room1"));
		rooms.add(new Room(2, 170l, "room2"));
		rooms.add(new Room(2, 180l, "room22"));
		rooms.add(new Room(3, 210l, "room3"));
		rooms.add(new Room(3, 220l, "room33"));
		rooms.add(new Room(4, 300l, "room4"));

		hotel.setRooms(rooms);

		int[] personNrs = { 1, 2, 4, 7 };

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.set(2014, 6, 18);
		end.set(2014, 6, 22);

		List<QueryResult> qr1 = hotel.findFreeRooms(start, end, personNrs[0]);
		List<QueryResult> qr2 = hotel.findFreeRooms(start, end, personNrs[1]);
		List<QueryResult> qr3 = hotel.findFreeRooms(start, end, personNrs[2]);
		List<QueryResult> qr4 = hotel.findFreeRooms(start, end, personNrs[3]);

		Assert.assertEquals(3, qr1.size());
		Assert.assertEquals(520, qr1.get(0).getPrice());

		Assert.assertEquals(3, qr2.size());
		Assert.assertEquals(680, qr2.get(0).getPrice());

		Assert.assertEquals(5, qr3.size());
		Assert.assertEquals(1200, qr3.get(0).getPrice());

		Assert.assertEquals(true, qr1.get(0).getRooms().contains(new Room("room1")));
		Assert.assertEquals(true, qr4.get(0).getRooms().contains(new Room("room4")));

		QueryResult sampleQueryResult = new QueryResult();
		List<Room> sampleRooms = new ArrayList<Room>();
		sampleRooms.add(rooms.get(1));
		sampleQueryResult.setRooms(sampleRooms);
		sampleQueryResult.setPrice(4 * sampleQueryResult.getRooms().get(0).getPrice());

		Assert.assertEquals(true, qr2.get(0).equals(sampleQueryResult));

		sampleRooms = new ArrayList<Room>();
		sampleRooms.add(rooms.get(2));
		sampleQueryResult.setRooms(sampleRooms);
		sampleQueryResult.setPrice(4 * sampleQueryResult.getRooms().get(0).getPrice());

		Assert.assertEquals(true, qr2.get(1).equals(sampleQueryResult));

	}

	@Test
	public void searchRoom() {

		Hotel hotel = new Hotel();
		Room room = new Room(2, 200L, "room1");

		hotel.add(room);

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		QueryResult qr = new QueryResult();
		qr.setPrice(200);

		List<Room> rs = new ArrayList<Room>();
		rs.add(room);

		qr.setRooms(rs);
		start.set(2014, 6, 18);
		end.set(2014, 6, 22);
		List<QueryResult> list = new ArrayList<QueryResult>();
		list.add(qr);

		List<QueryResult> result = hotel.findFreeRooms(start, end, 2);

		Assert.assertEquals(1, result.size());

		Assert.assertEquals(1, result.get(0).getRooms().size());

	}

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
