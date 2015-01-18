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

        Room r = new Room(1, 80, "1");
        Room r2 = new Room(1, 80, "2");
        Room hr = new Room(2, 160, "5");

        r.setPrice(getSeason("s1", 2014, 11, 24, 3), 100);
        r.setPrice(getSeason("s2", 2014, 11, 28, 3), 90);
        r.setPrice(getSeason("s3", 2014, 0, 1, 5), 100);

        r2.setPrice(getSeason("s1", 2014, 11, 24, 3), 100);
        r2.setPrice(getSeason("s2", 2014, 11, 28, 3), 90);
        r2.setPrice(getSeason("s3", 2014, 0, 1, 5), 100);

        hr.setPrice(getSeason("s1", 2014, 11, 20, 1), 300);
        hr.setPrice(getSeason("s2", 2014, 11, 27, 1), 300);
        hr.setPrice(getSeason("s3", 2015, 0, 3, 1), 260);
        hr.setPrice(getSeason("s4", 2015, 0, 10, 1), 260);
        hr.setPrice(getSeason("s5", 2014, 11, 24, 3), 220);
        hr.setPrice(getSeason("s6", 2014, 11, 28, 3), 200);
        hr.setPrice(getSeason("s7", 2014, 11, 31, 6), 220);
        hr.setPrice(getSeason("s8", 2014, 0, 17, 14), 200);

        hotel.add(r);
        hotel.add(r2);
        hotel.add(hr);

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
