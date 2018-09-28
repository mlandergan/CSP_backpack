public class BinaryNotEquals extends Constraint {
    char item1;
    char item2;

    public BinaryNotEquals(char item1, char item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        // TODO checks to see if the two items are NOT in the same bag. True if they are NOT, False if they are
        return  isValid;
    }

}
