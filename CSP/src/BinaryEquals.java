public class BinaryEquals extends Constraint {
    char item1;
    char item2;

    public BinaryEquals(char item1, char item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    
    public boolean isSatisfiable(State currentState){  
        if(currentState.itemUnassigned(this.item1) || currentState.itemUnassigned(this.item2)) return true;

        for(String items: currentState.getBags().values()) {
        	if((items.contains(Character.toString(item1))  && !items.contains(Character.toString(item2)) ||
        		(items.contains(Character.toString(item2))  && !items.contains(Character.toString(item1))))) return false;
        }
        return true;
    }
    
    
    public boolean isValid(State currentState){    	    	
        for(String items: currentState.getBags().values()) {
        	if((items.contains(Character.toString(item1))  && items.contains(Character.toString(item2)))) return true;
        }
    
        return  false;
    }

}
