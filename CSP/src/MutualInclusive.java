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
    	   String items = currentState.getBags().get(bag);
       	   // if((items.indexOf(item1) != -1) && (items.indexOf(item2) != -1)) return false;
    	   // if (items.indexOf(item1) != -1 && (bag != bag1 && bag != bag2)) return false;
    	   // if (items.indexOf(item2) != -1 && (bag != bag1 && bag != bag2)) return false;

       	   if((items.contains(Character.toString(item1)) && (items.contains(Character.toString(item2))))) return false;
       	   if(items.contains(Character.toString(item1)) && (bag != bag1 && bag != bag2)) return false;
       	   if(items.contains(Character.toString(item2)) && (bag != bag1 && bag != bag2)) return false;
       }
       return true;
    }
    
    public boolean isValid(State currentState){
    	//     	return (((currentState.getBags().get(bag1).indexOf(item1) != -1) && (currentState.getBags().get(bag2).indexOf(item2) != -1)) || 
		//   ((currentState.getBags().get(bag1).indexOf(item2) != -1) && (currentState.getBags().get(bag2).indexOf(item1) != -1)));
    	return (((currentState.getBags().get(bag1).contains(Character.toString(item1)) && (currentState.getBags().get(bag2).contains(Character.toString(item2))) || 
    			((currentState.getBags().get(bag1).contains(Character.toString(item2))) && (currentState.getBags().get(bag2).contains(Character.toString(item1)))))));
    }
}
