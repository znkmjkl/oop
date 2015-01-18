package com.hotel.impl;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoomTest {

	private Hotel hotel;
	private Room room;

	private Calendar start1;
	private Calendar end1;

	private Calendar start2;
	private Calendar end2;

	private Season season1;
	private Season season2;

	@Before
	public void setUp() {
		hotel = new Hotel();
		room = new Room(2, 130l, "room1");

		start1 = Calendar.getInstance();
		end1 = Calendar.getInstance();

		start2 = Calendar.getInstance();
		end2 = Calendar.getInstance();

		season1 = new Season();
		season2 = new Season();
	}

	@Test
	public void seasons() {

		start1.set(2014, 5, 30);
		end1.set(2014, 7, 31);

		start2.set(2014, 8, 3);
		end2.set(2014, 8, 10);

		season1.setName("spring");
		season1.setStart(start1);
		season1.setEnd(end1);

		hotel.addSeason(season1);

		season2.setName("winter");
		season2.setStart(start2);
		season2.setEnd(end2);

		room.setPrice(season1, 180L);
		room.setPrice(season2, 150l);

		hotel.add(room);

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.set(2014, 7, 29);
		end.set(2014, 8, 5);

		Assert.assertEquals(1050L, room.getRoomPrice(start, end));

	}
}
