package com.hotel.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class QueryResult {

	private List<Room> rooms;
	private long price = 0l;
	
	public QueryResult(long price, Room... rooms) {
		
		this.price = price;
		
		if (this.rooms == null) {
			this.rooms = new ArrayList<Room>();
		}
		
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
		if (o instanceof QueryResult) {
		
			QueryResult r = (QueryResult) o;
	
			if (r.getPrice() != this.getPrice()) return false;
			if (r.getRooms().size() != this.getRooms().size()) return false;
			
			return new HashSet<Room>(r.getRooms()).equals(new HashSet<Room>(this.getRooms()));
		}
		
		return false;
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
	
	@Override
	public int hashCode() {
		
		int hash = 0;
		
		if(getRooms() != null) {
			for(Room room : getRooms()) {
				hash += room.hashCode();
			}
		}
		
		return hash;
	}

}
