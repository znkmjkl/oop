package com.hotel.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mati on 2015-01-18.
 */
public class BiggerHotelTest {

	private Hotel hotel;

	@Before
	public void setUp() {
		hotel = new Hotel();

		Room r1 = new Room(1, 80, "1");
		Room r2 = new Room(1, 80, "2");
		Room r3 = new Room(2, 140, "3");
		Room r4 = new Room(2, 140, "4");
		Room r5 = new Room(2, 160, "5");
		Room r6 = new Room(3, 200, "6");
		Room r7 = new Room(4, 240, "7");
		Room r8 = new Room(4, 300, "8");

		r1.setPrice(getSeason("s1", 2014, 11, 24, 3), 100);
		r1.setPrice(getSeason("s2", 2014, 11, 28, 3), 90);
		r1.setPrice(getSeason("s3", 2014, 0, 1, 5), 100);

		r2.setPrice(getSeason("s1", 2014, 11, 24, 3), 100);
		r2.setPrice(getSeason("s2", 2014, 11, 28, 3), 90);
		r2.setPrice(getSeason("s3", 2014, 0, 1, 5), 100);

		r3.setPrice(getSeason("s1", 2014, 11, 24, 3), 220);
		r3.setPrice(getSeason("s2", 2014, 11, 28, 3), 200);
		r3.setPrice(getSeason("s3", 2014, 11, 31, 6), 220);
		r3.setPrice(getSeason("s4", 2015, 0, 17, 15), 200);

		r4.setPrice(getSeason("s1", 2014, 11, 24, 3), 220);
		r4.setPrice(getSeason("s2", 2014, 11, 28, 3), 200);
		r4.setPrice(getSeason("s3", 2014, 11, 31, 6), 220);
		r4.setPrice(getSeason("s4", 2015, 0, 17, 15), 200);

		r5.setPrice(getSeason("s1", 2014, 11, 20, 1), 300);
		r5.setPrice(getSeason("s2", 2014, 11, 27, 1), 300);
		r5.setPrice(getSeason("s3", 2015, 0, 3, 1), 260);
		r5.setPrice(getSeason("s4", 2015, 0, 10, 1), 260);
		r5.setPrice(getSeason("s5", 2014, 11, 24, 3), 220);
		r5.setPrice(getSeason("s6", 2014, 11, 28, 3), 200);
		r5.setPrice(getSeason("s7", 2014, 11, 31, 6), 220);
		r5.setPrice(getSeason("s8", 2015, 0, 17, 15), 200);

		r6.setPrice(getSeason("s1", 2014, 11, 24, 3), 320);
		r6.setPrice(getSeason("s2", 2014, 11, 28, 3), 300);
		r6.setPrice(getSeason("s3", 2014, 11, 31, 6), 320);
		r6.setPrice(getSeason("s4", 2015, 0, 17, 15), 300);

		r7.setPrice(getSeason("s1", 2014, 11, 24, 3), 360);
		r7.setPrice(getSeason("s2", 2014, 11, 28, 3), 340);
		r7.setPrice(getSeason("s3", 2014, 11, 31, 6), 360);
		r7.setPrice(getSeason("s4", 2015, 0, 17, 15), 350);

		r8.setPrice(getSeason("s1", 2014, 11, 24, 3), 450);
		r8.setPrice(getSeason("s2", 2014, 11, 28, 3), 430);
		r8.setPrice(getSeason("s3", 2014, 11, 31, 6), 450);
		r8.setPrice(getSeason("s4", 2015, 0, 17, 15), 450);

		hotel.add(r1);
		hotel.add(r2);
		hotel.add(r3);
		hotel.add(r4);
		hotel.add(r5);
		hotel.add(r6);
		hotel.add(r7);
		hotel.add(r8);

	}

	private Season getSeason(String name, int year, int month, int day, int roll) {
		Season s = new Season();
		s.setName(name);

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.set(year, month, day);
		end.set(year, month, day);
		end.add(Calendar.DAY_OF_MONTH, roll);
		s.setStart(start);
		s.setEnd(end);

		return s;
	}

	@Test
	public void testRoom2() {

		Room room = hotel.room("2");

		assertNotNull(room);
		assertEquals(80,
				room.price(
						new GregorianCalendar(2015, Calendar.JANUARY, 15)
				)
		);
		assertEquals(100,
				room.price(
						new GregorianCalendar(2014, Calendar.DECEMBER, 26)
				)
		);
		assertEquals(90,
				room.price(
						new GregorianCalendar(2014, Calendar.DECEMBER, 28)
				)
		);

	}


	@Test
	public void testRoom5() {

		Room room = hotel.room("5");


		assertEquals(220,
				room.price(
						new GregorianCalendar(2014, Calendar.DECEMBER, 26)
				)
		);

		assertEquals(300,
				room.price(
						new GregorianCalendar(2014, Calendar.DECEMBER, 27)
				)
		);

		assertEquals(200,
				room.price(
						new GregorianCalendar(2014, Calendar.DECEMBER, 28)
				)
		);

		assertEquals(160,
				room.price(
						new GregorianCalendar(2015, Calendar.JANUARY, 7)
				)
		);

	}
}
