public class UnaryInclusive extends Constraint {
    char item;
    String bagNames;

    public UnaryInclusive(char item, String bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }
    public boolean isSatisfiable(State currentState) {
        if (currentState.itemUnassigned(this.item)) return true;

        for(char bag:this.bagNames.toCharArray()) {
        	if (currentState.bagContains(bag, this.item));
        }
   	
    	return false;
    }
    
    public boolean isValid(State currentState){
        for(char bag:this.bagNames.toCharArray()) {
        	if (currentState.bagContains(bag, this.item));
        }
    	
    	return false;
    }
}

