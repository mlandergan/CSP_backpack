public class UnaryExclusive extends Constraint {
    char item;
    String bagNames;

    public UnaryExclusive(char item, String bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }

    public boolean isSatisfiable(State currentState) {
       // if(currentState.getUnassignedItems().indexOf(this.item) != -1) return true;
        if(currentState.getUnassignedItems().contains(Character.toString(this.item))) return true;

        for(char bag:this.bagNames.toCharArray()) {
        	//if(currentState.getBags().get(bag).indexOf(this.item) != -1) return false; 
        	if(currentState.getBags().get(bag).contains(Character.toString(this.item))) return false; 

        }
    	return true;
    }
    
    public boolean isValid(State currentState){
        //if(currentState.getUnassignedItems().indexOf(this.item) != -1) return true;
        if(currentState.getUnassignedItems().contains(Character.toString(this.item))) return true;
    	
        for(char bag:this.bagNames.toCharArray()) {
        	// if(currentState.getBags().get(bag).indexOf(this.item) != -1) return false; 
        	if(currentState.getBags().get(bag).contains(Character.toString(this.item))) return false; 
        }
    	
    	return true;
    }
}

