package interfaces;

import impl.*;

import java.util.Calendar;

public interface ReservationInt {
	public Person getPerson();
	
	public void setPerson(Person person);
	
	public Calendar getStart();
	
	public void setStart(Calendar start);
	
	public Calendar getEnd();
	
	public void setEnd(Calendar end);
	
	public Room getRoom();
	
	public void setRoom(Room room);
}
