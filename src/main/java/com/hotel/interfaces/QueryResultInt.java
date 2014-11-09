package main.java.com.hotel.interfaces;


import java.util.List;

import main.java.com.hotel.impl.*;

public interface QueryResultInt {

	public void setRooms(List<Room> rooms);

	public void setPrice(long price);

	public List<Room> getRooms();

	public long getPrice();
}
