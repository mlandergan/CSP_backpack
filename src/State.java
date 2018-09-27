import java.util.ArrayList;

public class State {
    ArrayList<Bag> bags;
    ArrayList<Item> unAssignedItems;

    public State(ArrayList<Bag> bags, ArrayList<Item> unAssignedItems){
        this.bags = bags;
        this.unAssignedItems = unAssignedItems;
    }
}
