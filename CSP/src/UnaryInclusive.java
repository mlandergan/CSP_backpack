import java.util.HashMap;

public class UnaryInclusive extends Constraint {
    char item;
    String bagNames;

    public UnaryInclusive(char item, String bagNames){
        this.item = item;
        this.bagNames = bagNames;
    }
    public boolean isSatisfiable(State currentState) {
        if(currentState.getUnassignedItems().indexOf(this.item) != -1) return true;

        for(char bag:this.bagNames.toCharArray()) {
        	if(currentState.getBags().get(bag).indexOf(this.item) != -1) return true; 
        }
   	
    	return false;
    }
    
    public boolean isValid(State currentState){
        if(currentState.getUnassignedItems().indexOf(this.item) != -1) return false;
        
        for(char bag:this.bagNames.toCharArray()) {
        	if(currentState.getBags().get(bag).indexOf(this.item) != -1) return true; 
        }
    	
    	return false;
    }
}

