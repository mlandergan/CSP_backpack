import java.util.HashMap;

public class WeightLimit extends Constraint {
	HashMap<Character, Integer> itemWeights;
	HashMap<Character, Integer> bagCapacities;
	
	public WeightLimit(HashMap<Character, Integer> itemWeights, HashMap<Character, Integer> bagCapacities) {
		this.itemWeights = itemWeights;
		this.bagCapacities = bagCapacities;
	}
    
    public boolean isSatisfiable(State currentState){    	
    	HashMap<Character, String> bags = currentState.getBags();
    	
    	for (Character bag : bags.keySet()) {
    		int maxCapacity = bagCapacities.get(bag);
    		int currentWeight = getCurrentWeight(itemWeights, bags.get(bag));	
    		if (currentWeight > maxCapacity) return false;
    	}
        return  true;
    }
    
    public boolean isValid(State currentState){
    	    	
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
