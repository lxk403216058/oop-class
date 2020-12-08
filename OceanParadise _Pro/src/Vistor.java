
public abstract class Vistor {
	protected String name;
	protected int tickets;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setTickets(int tickets){
		this.tickets = tickets;
	}
	
	public int getTickets(){
		return tickets;
	}
}
