package com.hotel.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.hotel.interfaces.HotelInt;

public class Hotel implements HotelInt {

	private List<Reservation> reservations = new ArrayList<Reservation>();

	private List<Room> rooms = new ArrayList<Room>();

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void add(Room room) {
		rooms.add(room);
	}

	public Room room(String name) {
		return new Room();
	}

	public List<Room> getAvailableRooms(Calendar start, Calendar end) {

		List<Room> allRooms = getRooms();

		for (Reservation res : getReservations()) {
			if ((start.getTimeInMillis() <= res.getStart().getTimeInMillis() && end
					.getTimeInMillis() >= res.getStart().getTimeInMillis())
					|| (end.getTimeInMillis() <= res.getEnd().getTimeInMillis() && start
							.getTimeInMillis() >= res.getEnd()
							.getTimeInMillis())

			) {

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

	public List<QueryResult> findFreeRooms(Calendar start, Calendar end,
			int n_persons) {

		List<QueryResult> result = new ArrayList<QueryResult>();
		long diffs = end.getTimeInMillis() - start.getTimeInMillis();
		long nights = diffs / (24 * 60 * 60 * 1000);

		result = getResults(n_persons, nights);

		return getCheapest(result, 3);
	}

	private List<QueryResult> getCheapest(List<QueryResult> results,
			long resultNr) {
		Collections.sort(results, new Hotel.QueryComparator());

		Deque<QueryResult> all = new LinkedList<QueryResult>(results);
		List<QueryResult> cheapest = new ArrayList<QueryResult>();

		while (cheapest.size() < resultNr && !all.isEmpty()) {
			cheapest.add(all.pollFirst());

			while (all.isEmpty() ? false : cheapest.get(cheapest.size() - 1)
					.getPrice() == all.getFirst().getPrice()) {
				cheapest.add(all.pollFirst());
			}
		}

		return cheapest;
	}

	public void reserve(Calendar start, Calendar end, QueryResult toReserve,
			Person person) {

		Reservation res = null;

		for (Room r : toReserve.getRooms()) {
			res = new Reservation();
			res.setStart(start);
			res.setEnd(end);
			res.setPerson(person);
			res.setRoom(r);
			reservations.add(res);
		}
	}

	private void addToResults(List<Room> resultRoomList, List<Room> rooms,
			List<QueryResult> results) {

		QueryResult result = new QueryResult();

		List<Room> rs = new ArrayList<Room>();

		for (Room room : rooms) {
			int it = 0;

			for (Room r : resultRoomList) {
				if (room.getName().equals(r.getName())) {
					it++;
				}
			}

			for (int x = 0; x < it; x++) {
				rs.add(room);
			}
		}

		result.setRooms(rs);

		results.add(result);
	}

	private List<QueryResult> addResult(List<Room> coins, List<Room> amounts,
			int highest, int sum1, int goal, List<QueryResult> results) {

		if (sum1 >= goal) {
			addToResults(coins, amounts, results);
			return results;
		}

		if (sum1 == goal) {
			return results;
		}

		for (Room i : amounts) {
			if (i.getSize() >= highest) {
				List<Room> copy = new ArrayList<Room>(coins);

				copy.add(i);

				addResult(copy, amounts, i.getSize(), sum1 + i.getSize(), goal,
						results);

			}
		}

		return results;
	}

	private List<QueryResult> getResults(int peopleNr, long nights) {

		List<QueryResult> rawResults = addResult(new ArrayList<Room>(),
				new ArrayList<Room>(getRooms()), 0, 0, peopleNr,
				new ArrayList<QueryResult>());

		List<QueryResult> okResults = new ArrayList<QueryResult>();

		for (QueryResult qr : rawResults) {
			boolean isResultOk = true;

			List<Room> availableRooms = new ArrayList<Room>(getRooms());

			for (Room r : qr.getRooms()) {
				if (availableRooms.contains(r)) {
					availableRooms.remove(r);
				} else {
					isResultOk = false;
				}
			}

			if (isResultOk) {
				for (Room r1 : qr.getRooms()) {
					qr.setPrice(qr.getPrice() + r1.getPrice() * nights);
				}

				okResults.add(qr);
			}
		}

		return okResults;
	}

	class QueryComparator implements Comparator<QueryResult> {
		public int compare(QueryResult qr1, QueryResult qr2) {
			return Long.compare(qr1.getPrice(), qr2.getPrice());
		}
	}

	class RoomComparator implements Comparator<Room> {
		@Override
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
