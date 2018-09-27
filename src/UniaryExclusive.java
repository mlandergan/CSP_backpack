import java.util.ArrayList;

public class UniaryExclusive extends Constraint {
    Item item;
    ArrayList<String> bagNames;

    public UniaryExclusive(Item item, ArrayList<String> bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        // TODO checks that the item from this class, is not in one of the bags (bagNames) in the current state
        return  isValid;
    }
}

