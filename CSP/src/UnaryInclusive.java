public class UnaryInclusive extends Constraint {
    char item;
    String bagNames;

    public UnaryInclusive(char item, String bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public boolean isValid(State currentState){
        // checks if the item from this class and it has to be in one of the bags (bagNames) in the current state
    	return false;
    }
}

