package com.hotel.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class QueryResult implements Comparable<QueryResult> {

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
	
	

	//Sortowanie QueryResult:
	//1. Cena
	//2. Ilosc pokoi
	//3. Nazwa pokoi (alfabetycznie w przypadku pierwszego wystapienia roznych nazw w liscie pokoi)
	public int compareTo(QueryResult o) {
		
		if(this.getPrice() != o.getPrice()) return Long.compare(this.getPrice(), o.getPrice());
		
		if(this.getRooms().size() != o.getRooms().size()) return Long.compare(this.getRooms().size(), o.getRooms().size());
		
		if (o.getRooms() != null && !o.getRooms().isEmpty()) {
				return this.getRooms().get(this.getRooms().size()-1).getName().compareTo(o.getRooms().get(o.getRooms().size()-1).getName());
		}
		
		for(int i = 0; i < this.getRooms().size(); i++) {
			if(!this.getRooms().get(i).getName().equals(o.getRooms().get(i).getName())) {
				return this.getRooms().get(i).getName().compareTo(o.getRooms().get(i).getName());
			}
		}
		
		return Long.compare(this.getPrice(), o.getPrice());
	}

}
