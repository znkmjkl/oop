

import impl.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class HotelTester {
	
	@Test
	public void searchEmptyHotel() {

	   Hotel hotel = new Hotel();
	   
	   Calendar start = Calendar.getInstance();
	   Calendar end = Calendar.getInstance();
	   
	   Assert.assertEquals(0, hotel.findFreeRooms(start, end, 5).size());
	   
	 }
	
	 @Test
	 public void searchRoom() {
		 
		 Hotel hotel = new Hotel();
		 Room room = new Room(2, 200L, "room1");
		 
		 hotel.add(room);		 
		 
		 Calendar start = Calendar.getInstance();
		 Calendar end = Calendar.getInstance();
		 
		 QueryResult qr = new QueryResult();
		 qr.setPrice(200);
		 
		 List<Room> rs = new ArrayList<Room>();
		 rs.add(room);
		 
		 qr.setRooms(rs);
		 start.set(2014, 6, 18);
		 end.set(2014, 6, 22);
		 List<QueryResult> list = new ArrayList<QueryResult>();
		 list.add(qr);
		 
		 List<QueryResult> result = hotel.findFreeRooms(start, end, 2);
		 
		 Assert.assertEquals(1, result.size());
		 
		 if(!result.isEmpty()) {
			 Assert.assertEquals(1, result.get(0).getRooms().size());
			 //Assert.assertEquals(4*180, result.get(0).getPrice());
		 }

	 }
	 
	 @Test
	 public void reserve(){		 
		 Hotel hotel = new Hotel();
		 
		 Person p = new Person();
		 p.setfirstName("Jan");
		 p.setSecondName("Nowak");
		 p.setEmail("jan_nowak@gmail.com");
		 p.setAdress("Krakow, ul. Nowakowska 31a");
		 
		 Room r1 = new Room(1, 120L, "room1");		 
		 hotel.add(r1);
		 
		 Room r2 = new Room(2, 180L, "room2");		 
		 hotel.add(r2);
		 
		 Room r3 = new Room(2, 180L, "room3");		 
		 hotel.add(r3);
		 
		 Room r4 = new Room(4, 300L, "room4");		 
		 hotel.add(r4);
		 
		 Calendar start = Calendar.getInstance();
		 Calendar end = Calendar.getInstance();
		 
		 start.set(2014, 6, 18);
		 end.set(2014, 6, 22);
		 
		 List<QueryResult> result = hotel.findFreeRooms(start, end, 3);	
		 
		 hotel.reserve(start, end, result.get(0), p);
		 
		 Assert.assertEquals(2, hotel.getReservations().size());
		 
		 List<QueryResult> result2 = hotel.findFreeRooms(start, end, 1);
		 
		 hotel.reserve(start, end, result2.get(0), p);
		 
		 Assert.assertEquals(3, hotel.getReservations().size());
		 
	 }
}
