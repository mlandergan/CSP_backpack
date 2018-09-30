public class UnaryExclusive extends Constraint {
    char item;
    String bagNames;

    public UnaryExclusive(char item, String bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public boolean isSatisfiable(State currentState) {
       // if(currentState.getUnassignedItems().indexOf(this.item) != -1) return true;
        if(currentState.itemUnassigned(this.item)) return true;

        for(char bag:this.bagNames.toCharArray()) {
        	if (currentState.bagContains(bag, this.item)) return false;
        }
    	return true;
    }
    
    public boolean isValid(State currentState){    	
        for(char bag:this.bagNames.toCharArray()) {
        	if(currentState.bagContains(bag, this.item)) return false;
        }
    	
    	return true;
    }
}

