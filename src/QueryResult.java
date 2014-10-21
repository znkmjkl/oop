import java.util.List;


public class QueryResult {
	
	private List<Room> rooms;
	private int price;
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
    public int getPrice() {
    	return price;
    }
    
    
}
