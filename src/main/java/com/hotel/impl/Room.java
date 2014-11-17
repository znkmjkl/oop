package com.hotel.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Room implements Comparable<Room> {
	
	private static final long divider = 24 * 60 * 60 * 1000;
	private String name;
	private int size;
	private Person person;
	
	// private long price = 0l;
	private Map<Season, Long> seasonPrices = new HashMap<Season, Long>();

	public Room(int size) {
		this.size = size;
	}

	public Room(String name) {
		this.name = name;
	}

	public Room(int size, long normalPrice, String name) {
		this.size = size;
		Season season = new Season();
		season.setName("normal");
		this.seasonPrices.put(season, normalPrice);
		this.name = name;
	}

	public Room() {
	}

	/**/
	public String name() {
		return name;
	}

	public int n_persons() {
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

	public void setPrice(Season season, long price) {
		this.seasonPrices.put(season, price);
	}

	public long getPrice() {
		//return seasonPrices.get());
		for(Season season : seasonPrices.keySet()){
			if (season.getName().equals("normal"))
				return seasonPrices.get(season);
		}
		return 0L;	
		
	}

	public long getPrice(Season season) {
		return seasonPrices.get(season);
	}
	
	public long getRoomPrice(Calendar start, Calendar end) {
		
		long totalPrice = 0;
		long nights = 0;		
		long diff = end.getTimeInMillis() - start.getTimeInMillis();
		diff = (diff % 10 == 9) ? diff+1 : diff;
		long remainingNights = diff / divider;
		
		for(Season s : seasonPrices.keySet()){		
			if(s.getName().equals("normal"))
				continue;
				/* kiedy czesc rezerwacji jest na poczatku sezonu */
			if(end.getTimeInMillis() >= s.getStart().getTimeInMillis() && start.getTimeInMillis() < s.getStart().getTimeInMillis()
				&& end.getTimeInMillis() < s.getEnd().getTimeInMillis()){
				
				diff = end.getTimeInMillis() - s.getStart().getTimeInMillis();
				diff = (diff % 10 == 9) ? diff+1 : diff;
				nights = diff / divider;
			
				/* kiedy rezerwacja jest w sezonie lub pokrywa caly sezon */
			} else if (start.getTimeInMillis() >= s.getStart().getTimeInMillis() && end.getTimeInMillis() <= s.getEnd().getTimeInMillis()){					
				
				diff = end.getTimeInMillis() - start.getTimeInMillis();
				diff = (diff % 10 == 9) ? diff+1 : diff;
				nights = diff / divider;
		
				/* kiedy rezerwacja rozpoczyna sie pod koniec sezonu a potem jest poza  */
			} else if (start.getTimeInMillis() >= s.getStart().getTimeInMillis() && end.getTimeInMillis() > s.getEnd().getTimeInMillis() 
				&& start.getTimeInMillis() < s.getEnd().getTimeInMillis()){
					
				diff = s.getEnd().getTimeInMillis() - start.getTimeInMillis();
				diff = (diff % 10 == 9) ? diff+1 : diff;
				nights = diff / divider;
			
				/* kiedy rezerwacja jest wieksza i pokrywa caly sezon */	
			} else if (start.getTimeInMillis() < s.getStart().getTimeInMillis() && end.getTimeInMillis() > s.getEnd().getTimeInMillis()){
					
				diff = s.getEnd().getTimeInMillis() - s.getStart().getTimeInMillis();
				diff = (diff % 10 == 9) ? diff+1 : diff;
				nights = diff / divider;
			
			}
			
			totalPrice += nights * getPrice(s);				
			remainingNights -= nights;
			nights = 0;				
					
		}
		totalPrice += remainingNights * getPrice();
		
		//System.out.println("CENA CALKOWITA: " + totalPrice + " dla pokoju " + room.getName());
		return totalPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Room) {
			Room r = (Room) o;

			if (r.getName().equals(this.getName()))
				return true;
		}

		return false;
	}


	@Override
	public int hashCode() {
		return this.name != null ? this.name.hashCode() : 0;
	}

	
	public int compareTo(Room o) {
		if (this.getSize() > o.getSize()) {
			return -1;
		} else if (this.getSize() > o.getSize()) {
			return 1;
		} else {
			return 0;
		}
	}
}
