public class BinaryEquals extends Constraint {
    Item item1;
    Item item2;

    public BinaryEquals(Item item1, Item item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        // TODO checks to see if the two items are in the same bag. True if they are, False if they aren't
        return  isValid;
    }

}
