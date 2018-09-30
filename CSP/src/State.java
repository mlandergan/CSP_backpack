import java.util.HashMap;
import java.util.Map;

public class State {
    private HashMap<Character, String> bags;
	private String unassignedItems;

    public State(HashMap<Character, String> bags, String unassignedItems){
        this.bags = bags;
        this.unassignedItems = unassignedItems;
    }
    
    public State(State state) {
    	this.bags = copy(state.getBags());
    	this.unassignedItems = new String(state.unassignedItems);
	}
    
    public boolean addItem(char bag, char item) {
    	if (this.unassignedItems.indexOf(item) == -1) return false;
    	String newVal = this.bags.get(bag) + Character.toString(item);
		this.bags.put(bag, newVal);
		int index = this.unassignedItems.indexOf(item);
		this.unassignedItems = this.unassignedItems.substring(0, index) + this.unassignedItems.substring(index+1);
    	return true;
    }

	public boolean removeItem(char bag, char item) {
    	if (this.bags.get(bag).indexOf(item) == -1) return false;
    	this.bags.replace(bag, this.bags.get(bag).replace(Character.toString(item), ""));
    	return true;
    }
  
    public HashMap<Character, String> getBags() { return this.bags; }
    
    public String getUnassignedItems() { return this.unassignedItems; }
    
    public HashMap<Character, String> copy(HashMap<Character, String> original)
    	{
    	    HashMap<Character, String> copy = new HashMap<Character, String>();
    	    for (Map.Entry<Character, String> entry : original.entrySet())
    	    {
    	        copy.put(entry.getKey(),entry.getValue());
    	    }
    	    return copy;
    	}
}
