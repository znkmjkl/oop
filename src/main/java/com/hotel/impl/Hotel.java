package com.hotel.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import com.hotel.exceptions.RoomNameAlreadyExistsException;
import com.hotel.interfaces.HotelInt;
import com.hotel.utils.Accommodator;

public class Hotel implements HotelInt {
	
	public static final long divider = 24 * 60 * 60 * 1000;

	private List<Reservation> reservations = new ArrayList<Reservation>();

	private List<Room> rooms = new ArrayList<Room>();

	private List<Season> seasons = new ArrayList<Season>();
	
	public Hotel(Room... rooms) {
		for (Room room : rooms) {
			add(room);
		}
	}

	public void add(Room room) {

		if (rooms.contains(room)) {
			throw new RoomNameAlreadyExistsException("Room name is already taken [" + room.getName() + "]");
		}

		rooms.add(room);
	}

	public Room room(String name) {
		for (Room r : rooms) {
			if (r.getName().equals(name))
				return r;
		}
		return null;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {

		if (new HashSet<Room>(rooms).size() != rooms.size()) {
			throw new IllegalArgumentException("Provided list contains duplicates.");
		}

		this.rooms = rooms;
	}

	public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons) {

		long diffs = end.getTimeInMillis() - start.getTimeInMillis();
		long nights = diffs / (24 * 60 * 60 * 1000);
		
		return Accommodator.getCheapestQueryResults(n_persons, nights, 3, start, end, getRooms(), getAvailableRooms(start, end));
	}

	public List<Room> getAvailableRooms(Calendar start, Calendar end) {

		List<Room> allRooms = getRooms();
		long startMs = start.getTimeInMillis();
		long endMs = end.getTimeInMillis();

		for (Reservation res : getReservations()) {
			if ((startMs <= res.getStart().getTimeInMillis() && endMs >= res.getStart().getTimeInMillis())
				|| (startMs <= res.getEnd().getTimeInMillis() && endMs >= res.getEnd().getTimeInMillis())) {
				if (allRooms.contains(res.getRoom())) {
					allRooms.remove(res.getRoom());
				}
			}
		}

		return allRooms;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	//TODO throw IAE if start > end
	public void reserve(Calendar start, Calendar end, QueryResult toReserve, Person person) {
		for (Room room : toReserve.getRooms()) {
			if (checkRoomAvailable(start, end, room)) {
				reservations.add(new Reservation(person, start, end, room));
			}
		}
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void addSeason(Season s) {
		seasons.add(s);
	}


	private boolean checkRoomAvailable(Calendar start, Calendar end, Room room) {
		for (Room r : getAvailableRooms(start, end)) {
			if (r.equals(room)) {
				return true;
			}
		}
		return false;
	}

}
