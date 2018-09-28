public class BinaryEquals extends Constraint {
    char item1;
    char item2;

    public BinaryEquals(char item1, char item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        // TODO checks to see if the two items are in the same bag. True if they are, False if they aren't
        return  isValid;
    }

}
