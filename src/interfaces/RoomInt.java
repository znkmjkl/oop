package interfaces;

import impl.*;

public interface RoomInt {
	
	public String getName();

	public void setName(String name);

	public int getSize();

	public void setSize(int size);
    
	public void setPerson(Person person);
    
    public Person getPerson();
    
    public void setPrice(long price);
    
    public long getPrice();

    public long getFullPrice();
    
    public boolean equals(Object o);
}
