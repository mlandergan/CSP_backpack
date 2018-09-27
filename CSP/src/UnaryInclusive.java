import java.util.ArrayList;

public class UnaryInclusive extends Constraint {
    String item;
    ArrayList<String> bagNames;

    public UnaryInclusive(String item, ArrayList<String> bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public boolean isValid(State currentState){
        // checks if the item from this class and it has to be in one of the bags (bagNames) in the current state
    	return false;
    }
}

