import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Hotel {
	private List<Reservation> reservations;
	private List<Room> rooms = new ArrayList<Room>();
	
	 public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	void add(Room room) {
		 rooms.add(room);
	 }
	 
	 public Room room(String name) {
		 return new Room();
	 }
	 
	 //TODO wyliczanie roznych mozliwosci zakwaterowania (lista pokoi)
	 public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons) {
		 
		 List<QueryResult> result = new ArrayList<QueryResult>();
		 
		 int availableSpots = 0;
		 
		 
		 
		 long diffs = end.getTimeInMillis() - start.getTimeInMillis();
		 
		 long nights = diffs / (24 * 60 * 60 * 1000);		 
		 int spots = 0;
		 int i = 0;
		 for (Room r : getRooms()){
			 spots+=r.getSize();
			 QueryResult qr = new QueryResult();
			 if(spots >= n_persons){
				 List<Room> rooms = new ArrayList<Room>();
				 rooms.add(r);
				 
				 qr.setRooms(rooms);
				 qr.setPrice(r.getPrice());
				 result.add(qr);
			 } else {
				 List<Room> rooms = new ArrayList<Room>();
				 rooms.add(r);
				 while(spots < n_persons){
					 Room room = getRooms().get(i);
					 if(room.getSize() < n_persons){
						 spots+=room.getSize();
						 rooms.add(r);
					 }
				 }
				 if(spots >= n_persons){
					 qr.setRooms(rooms);					 
					 result.add(qr);
				 }
			 }		 
			 spots = 0;
			 i++;
		 }
		 
		 
		 /*for(Room r : getRooms()) {	  
			 
			 if (r.getSize() >= n_persons) {
			 	List<Room> rooms = new ArrayList<Room>();
				rooms.add(r);
						 
				qr.setRooms(rooms);
				qr.setPrice((int)nights * 180); 	
				result.add(qr);
			 }
		 }*/
		 
		 return result;
	 }
	 
	 public void reserve(Calendar start, Calendar end, QueryResult result, Person person){
		 
		 for(Room r : result.getRooms()){		 
			 Reservation res = new Reservation();
			 res.setStart(start);
			 res.setEnd(end);
			 res.setPerson(person);
			 res.setRoom(r);
			 reservations.add(res);
		 }
	 }
	 
	 private void addToResults(List<Room> resultRoomList, List<Room> rooms, List<QueryResult> results) {
		 QueryResult result = new QueryResult();
		 
		 List<Room> rs = new ArrayList<Room>();
		 
		 for (Room room : rooms) {
			 int it = 0;
			 
			 for (Room r : resultRoomList) {
				 if (room.getSize() == r.getSize()) {
					 it++;
				 }
			 }
			 
			 for(int x = 0; x < it; x++) {
				 rs.add(room);
			 }
		 }
		 
		 result.setRooms(rs);
		 
		 results.add(result);
	 }
	 
	 private List<QueryResult> addResult(List<Room> coins, List<Room> amounts, int highest, int sum1, int goal, List<QueryResult> results) {
		 
		 if(sum1 == goal) {
			 addToResults(coins, amounts, results);
		 }
		 
		 if (sum1 > goal) {
			 return results;
		 }
		 
		 for (Room i : amounts) {
			 if(i.getSize() >= highest) {
				 List<Room> copy = new ArrayList<Room>(coins);
				 copy.add(i);
				 
				 addResult(copy, amounts, i.getSize(), sum1 + i.getSize(), goal, results);
			 }
		 }
		 
		 return results;
			 
	 }
	 
	 //zwraca liste mozliwosci zakwaterowania danej liczby osob
	 //zmienic na private
	 public List<QueryResult> getResults(int peopleNr) {
		 
		 List<QueryResult> results = addResult(new ArrayList<Room>(), new ArrayList<Room>(getRooms()), 0, 0, peopleNr, new ArrayList<QueryResult>());
		 
		 List<QueryResult> okResults = new ArrayList<QueryResult>();
		 
		 for (QueryResult qr : results) {
			 boolean isResultOk = true;
			 
			 List<Room> availableRooms = new ArrayList<Room>(getRooms());
			 
			 for (Room r : qr.getRooms()) {
				 if (availableRooms.contains(r)) {
					 availableRooms.remove(r);
				 } else {
					 isResultOk = false;
				 }
			 }
			 
			 if(isResultOk) {
				 for (Room r1 : qr.getRooms()) {
					 qr.setPrice(qr.getPrice() + r1.getFullPrice());
				 }
				 okResults.add(qr);
			 }
		 }
		 
		 return okResults; 
	 }
	 
	 
}
     


       