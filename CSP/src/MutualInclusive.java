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
        boolean isValid = false;
        // TODO Items have to be in different bags. But they have to be in the bags (XOR)
        return isValid;
    }
}
