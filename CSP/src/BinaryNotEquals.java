public class BinaryNotEquals extends Constraint {
    char item1;
    char item2;

    public BinaryNotEquals(char item1, char item2){
        this.item1 = item1;
        this.item2 = item2;
    }
    
    public boolean isSatisfiable(State currentState){        
        for(String items: currentState.getBags().values()) {
        	if((items.indexOf(item1) != -1) && (items.indexOf(item2) != -1)) return false;
        } 
       return  true;
    }

    public boolean isValid(State currentState){
        if(currentState.getUnassignedItems().indexOf(item1) != -1 || currentState.getUnassignedItems().indexOf(item2) != -1 ) return true;
        
        for(String items: currentState.getBags().values()) {
        	if((items.indexOf(item1) != -1) && (items.indexOf(item2) != -1)) return false;
        }
        
        return  true;
    }

}
