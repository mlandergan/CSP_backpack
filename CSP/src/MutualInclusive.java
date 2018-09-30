public class MutualInclusive extends Constraint {
    char item1;
    char item2;
    char bag1;
    char bag2;

    public MutualInclusive(char item1, char item2, char bag1, char bag2){
        this.item1 = item1;
        this.item2 = item2;
        this.bag1 = bag1;
        this.bag2 = bag2;
    }
    public boolean isSatisfiable(State currentState){

       for (char bag : currentState.getBags().keySet()) {  	   
       	   if (currentState.bagContains(bag, item1) && currentState.bagContains(bag, item2)) return false;
       	   if (currentState.bagContains(bag, item1) && !(bag == bag1 && bag == bag2)) return false;
       	   if (currentState.bagContains(bag, item2) && !(bag == bag1 && bag == bag2)) return false;
       }
       return true;
    }
    
    public boolean isValid(State currentState){    	
    	return ((currentState.bagContains(bag1, item1) && currentState.bagContains(bag2, item2)) || (currentState.bagContains(bag1, item1) && currentState.bagContains(bag2, item2)));
    }
    
}
