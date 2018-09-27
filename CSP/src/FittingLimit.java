public class FittingLimit extends Constraint {
    int minItems;
    int maxItems;

    public FittingLimit(int minItems, int maxItems){
        this.minItems = minItems;
        this.maxItems = maxItems;
    }
    
    public FittingLimit(String minItems, String maxItems){
        this.minItems = Integer.parseInt(minItems);
        this.maxItems = Integer.parseInt(maxItems);
    }

    public boolean isValid(State currentState){
        boolean isValid = false;
        //TODO make sure that each bag has more than *minItems and less than Max items
        // TODO check if its more than min or if it can be equal
        return  isValid;
    }
}
