public class FittingLimits extends Constraint {
    int minItems;
    int maxItems;

    public FittingLimits(int minItems, int maxItems){
        this.minItems = minItems;
        this.maxItems = maxItems;
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        //TODO make sure that each bag has more than *minItems and less than Max items
        // TODO check if its more than min or if it can be equal
        return  isValid;
    }
}
