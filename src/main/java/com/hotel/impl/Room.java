package main.java.com.hotel.impl;

public class Room {

	private String name;
	private int size;
	private Person person;
	private long price = 0l;
	
	public Room(int size) {
		this.size = size;
	}

	public Room(String name) {
		this.name = name;
	}
	
	public Room(int size, long price, String name) {
		this.size = size;
		this.price = price;
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

	public void setPrice(long price) {
		this.price = price;
	}

	public long getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		Room r = (Room) o;

		if (r.getName().equals(this.getName()))
			return true;

		return false;
	}
}
