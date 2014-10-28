import java.util.List;


public class QueryResult {
	
	private List<Room> rooms;
	private long price = 0l;
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
    public long getPrice() {
    	return price;
    }
    
    
}
