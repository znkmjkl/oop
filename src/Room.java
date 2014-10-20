
public class Room {
	
	private String name;
	private int size;	
	private Person person;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	String name() {
		return null;
		
	}
	
    int n_persons() {
		return 0;
    }
    
    public void setPerson(Person person){
    	this.person = person;
    }
    
    public Person getPerson(){
    	return this.person;
    }
}
