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

    public boolean isValid(State currentState){
    	return (((currentState.getBags().get(bag1).indexOf(item1) != -1) && (currentState.getBags().get(bag2).indexOf(item2) != -1)) || 
    			((currentState.getBags().get(bag1).indexOf(item2) != -1) && (currentState.getBags().get(bag2).indexOf(item1) != -1)));
    }
}
