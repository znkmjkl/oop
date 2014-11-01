package impl;

import interfaces.RoomInt;

public class Room implements RoomInt{
	
	private String name;
	private int size;	
	private Person person;
	private long price = 0l;
	
	public Room(int size) {
		this.size = size;
	}
	
	//Dodac throws RoomNameAlreadyExistsException
	public Room(int size, long price, String name) {
		this.size = size;
		this.price = price;
		this.name = name;
	}
	
	public Room() { }
	
	public String getName() {
		return name;
	}
	
	//Dodac throws RoomNameAlreadyExistsException
	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}		
	
    public void setPerson(Person person){
    	this.person = person;
    }
    
    public Person getPerson(){
    	return this.person;
    }
    
    public void setPrice(long price){
    	this.price = price;
    }
    
    public long getPrice(){
    	return price;
    }
    
    public long getFullPrice() {
    	return getSize() * getPrice();
    }
    
    @Override
    public boolean equals(Object o) {
    	Room r = (Room) o;
    	
    	if(r.getName().equals(this.getName())) return true;
    	
    	return false;
    }
}
