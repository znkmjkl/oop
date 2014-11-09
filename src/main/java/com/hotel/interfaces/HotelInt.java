package com.hotel.interfaces;


import java.util.Calendar;
import java.util.List;

import com.hotel.impl.*;

public interface HotelInt {

	public List<Room> getRooms();

	public void add(Room room);

	public Room room(String name);

	public List<QueryResult> findFreeRooms(Calendar start, Calendar end,
			int n_persons);

	public void reserve(Calendar start, Calendar end, QueryResult result,
			Person person);

}
