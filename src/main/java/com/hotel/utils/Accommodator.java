package com.hotel.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.hotel.impl.QueryResult;
import com.hotel.impl.Room;

public class Accommodator {

	private static void addToResults(List<Room> resultRoomList, List<Room> rooms, List<QueryResult> results) {

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

	private static List<QueryResult> addResult(List<Room> coins, List<Room> amounts, int highest,
			int sum1, int goal, List<QueryResult> results) {

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

				addResult(copy, amounts, i.getSize(), sum1 + i.getSize(), goal, results);

			}
		}

		return results;
	}

	public static List<QueryResult> getCheapestQueryResults(int peopleNr, long nights, int resultsNr, Calendar start, Calendar end, List<Room> allRooms, List<Room> availableRooms) {

		List<QueryResult> rawResults = addResult(new ArrayList<Room>(), new ArrayList<Room>(
				allRooms), 0, 0, peopleNr, new ArrayList<QueryResult>());

		List<QueryResult> okResults = new ArrayList<QueryResult>();

		for (QueryResult qr : rawResults) {
			boolean isResultOk = true;

			List<Room> availableRoomsCopy = new ArrayList<Room>(availableRooms);

			for (Room r : qr.getRooms()) {
				if (availableRoomsCopy.contains(r)) {
					availableRoomsCopy.remove(r);
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
		
		return getCheapest(new ArrayList<QueryResult>(new HashSet<QueryResult>(okResults)), resultsNr);
	}
	
	private static List<QueryResult> getCheapest(List<QueryResult> results, int resultNr) {
		Collections.sort(results, new QueryComparator());

		Deque<QueryResult> all = new LinkedList<QueryResult>(results);
		List<QueryResult> cheapest = new ArrayList<QueryResult>();

		while (cheapest.size() < resultNr && !all.isEmpty()) {
			cheapest.add(all.pollFirst());

			while (all.isEmpty() ? false : cheapest.get(cheapest.size() - 1).getPrice() == all
					.getFirst().getPrice()) {
				cheapest.add(all.pollFirst());
			}
		}
		
		return cheapest;
	}
	
	static class QueryComparator implements Comparator<QueryResult> {
		public int compare(QueryResult qr1, QueryResult qr2) {
			return Long.compare(qr1.getPrice(), qr2.getPrice());
		}
	}

}
