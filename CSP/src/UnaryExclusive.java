import java.util.ArrayList;

public class UnaryExclusive extends Constraint {
    char item;
    String bagNames;

    public UnaryExclusive(char item, String bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        // TODO checks that the item from this class, is not in one of the bags (bagNames) in the current state
        return  isValid;
    }
}

