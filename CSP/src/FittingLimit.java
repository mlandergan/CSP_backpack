import java.util.HashMap;

public class FittingLimit extends Constraint {
    int minItems;
    int maxItems;
    
    public FittingLimit(String minItems, String maxItems){

        this.minItems = Integer.parseInt(minItems);
        this.maxItems = Integer.parseInt(maxItems);
    }
    
    public boolean isSatisfiable(State currentState){          	
        HashMap<Character, String> bags = currentState.getBags();
        
        for (String items : bags.values()) {
        	if (items.length() > this.maxItems) return false;
        }   
        return true;
    }

    public boolean isValid(State currentState){          	
        HashMap<Character, String> bags = currentState.getBags();
        
        for (String items : bags.values()) {
        	if (items.length() < this.minItems || items.length() > this.maxItems) return false;
        }     
        return true;
    }
}
