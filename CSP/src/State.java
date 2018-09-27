import java.util.ArrayList;

public class State {
    ArrayList<Bag> bags;
    ArrayList<Item> unassignedItems;

    public State(ArrayList<Bag> bags, ArrayList<Item> unassignedItems){
        this.bags = bags;
        this.unassignedItems = unassignedItems;
    }
}
