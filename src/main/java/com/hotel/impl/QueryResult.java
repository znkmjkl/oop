package com.hotel.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueryResult {

	private List<Room> rooms;
	private long price = 0l;
	
	public QueryResult(Room... rooms) {		
		for (Room room : rooms) {
			this.rooms.add(room);
		}
	}
	
	public QueryResult() { }

	/**/
	public List<Room> rooms(){
		return rooms;
	}
	
	public long price(){
		return price;
	}
	/**/
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	
	public long getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		QueryResult r = (QueryResult) o;

		if (r.getPrice() != this.getPrice())
			return false;

		if (r.getRooms().size() != this.getRooms().size())
			return false;

		Collections.sort(r.getRooms(), new RoomComparator());
		Collections.sort(this.getRooms(), new RoomComparator());

		for (int i = 0; i < r.getRooms().size(); i++) {
			if (!r.getRooms().get(i).getName()
					.equals(this.getRooms().get(i).getName()))
				return false;
		}

		return true;
	}
	
	class RoomComparator implements Comparator<Room> {
		public int compare(Room o1, Room o2) {
			if (o1.getSize() > o2.getSize()) {
				return -1;
			} else if (o1.getSize() > o2.getSize()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
