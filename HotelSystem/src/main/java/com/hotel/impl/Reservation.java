package com.hotel.impl;

import java.util.Calendar;

import com.hotel.interfaces.ReservationInt;

public class Reservation implements ReservationInt {

	Person person;
	Calendar start;
	Calendar end;
	Room room;

	public Reservation(Person person, Calendar start, Calendar end, Room room) {
		this.person = person;
		this.start = start;
		this.end = end;
		this.room = room;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
