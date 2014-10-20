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
		 
		 Room room = new Room();
		 room.setSize(2);
		 
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
		 
		 Assert.assertEquals(1, hotel.findFreeRooms(start, end, 2).size());
		 
	 }
	 
	 @Test
	 public void reserve(){		 
		 Hotel hotel = new Hotel();
		 
		 Room r1 = new Room();
		 r1.setSize(1);
		 hotel.add(r1);
		 
		 Room r2 = new Room();		 
		 r2.setSize(2);
		 hotel.add(r2);
		 
		 Room r3 = new Room();
		 r3.setSize(2);		 
		 hotel.add(r3);
		 
		 Room r4 = new Room();
		 r4.setSize(4);
		 hotel.add(r4);
		 
		 
		 
		 
	 }
}
