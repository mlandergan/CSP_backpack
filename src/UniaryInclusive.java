import java.util.ArrayList;

public class UniaryInclusive extends Constraint {
    Item item;
    ArrayList<String> bagNames;

    public UniaryInclusive(Item item, ArrayList<String> bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public void isValid(State currentState){
        // checks if the item from this class and it has to be in one of the bags (bagNames) in the current state
    }
}

