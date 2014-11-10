package com.hotel.impl;

import java.util.HashMap;
import java.util.Map;

public class Room {

	private String name;
	private int size;
	private Person person;
	//private long price = 0l;
	private Map<String, Long> seasonPrices = new HashMap<String, Long>();
	
	public Room(int size) {
		this.size = size;		
	}

	public Room(String name) {
		this.name = name;
	}
	
	public Room(int size, long price, String name) {
		this.size = size;
		this.seasonPrices.put("normal", price);
		this.name = name;
	}

	public Room() {
	}
	
	/**/
	public String name(){
		return name;
	}
	
	public int n_persons(){
		return size;
	}
	/**/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPrice(String seasonName, long price) {
		this.seasonPrices.put(seasonName, price);
	}

	public long getPrice() {
		return seasonPrices.get("normal");
	}
	public long getPrice(String seasonName){
		return seasonPrices.get(seasonName);
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Room) {
			Room r = (Room) o;

			if (r.getName().equals(this.getName()))
				return true;
		}

		return false;
	}
	
	@Override
	public int hashCode(){
		return this.name != null ? this.name.hashCode() : 0;
	}
}
