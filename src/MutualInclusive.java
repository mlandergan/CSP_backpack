public class MutualInclusive extends Constraint {
    Item item1;
    Item item2;
    Bag bag1;
    Bag bag2;

    public MutualInclusive(Item item1, Item item2, Bag bag1, Bag bag2){
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
