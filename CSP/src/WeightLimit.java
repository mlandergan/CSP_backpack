import java.util.HashMap;

public class WeightLimit extends Constraint {

    public boolean isValid(State currentState){
        boolean isValid = false;
        //TODO Make sure each bag is holding a weight >=90% limit but < 100% (integer, rounded down)
        return  isValid;
    }
    
    public boolean isValid(State currentState, HashMap<Character, Integer> itemWeights, HashMap<Character, Integer> bagCapacities){
    	
    	HashMap<Character, String> bags = currentState.getBags();
    	
    	for (Character bag : bags.keySet()) {
    		int maxCapacity = bagCapacities.get(bag);
    		int minCapacity = (int)(maxCapacity * .9);
    		int currentWeight = getCurrentWeight(itemWeights, bags.get(bag));
    		
    		if (currentWeight < minCapacity || currentWeight > maxCapacity) return false;
    	}
        return  true;
    }
    
    public int getCurrentWeight(HashMap<Character, Integer> itemWeights, String items) {
    	int currentWeight = 0;
    	
    	for (char item : items.toCharArray()) {
    		currentWeight += itemWeights.get(item);
    	}
    	return currentWeight;
    }
}
