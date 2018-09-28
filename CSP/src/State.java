import java.util.HashMap;

public class State {
    private HashMap<Character, String> bags;
	private String unassignedItems;

    public State(HashMap<Character, String> bags, String unassignedItems){
        this.bags = bags;
        this.unassignedItems = unassignedItems;
    }
    
    public boolean removeItem(char bag, char item) {
    	if (this.bags.get(bag).indexOf(item) == -1) return false;
    	this.bags.replace(bag, this.bags.get(bag).replace(Character.toString(item), ""));
    	return true;
    }
        
    public HashMap<Character, String> getBags() { return this.bags; }
    
    public String getUnassignedItems() { return this.unassignedItems; }
}
