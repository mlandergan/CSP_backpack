import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSP_ACML {
		
	HashMap<Character, Integer> itemWeights;
	HashMap<Character, Integer> bagCapacities;

	ArrayList<Constraint> constraints;
	
	
	private State backTracking(State currentState) {
		// check valid solution 
		if(currentState.getUnassignedItems().length() == 0 && constraintsValid(currentState)) {
			return currentState;
		}
		
		for (State state : nextStates(currentState)) {
			State solution =  backTracking(state);
			if (solution != null) return solution;
		}
		// nextStates from member function
		// call backTracking return solution or NULL
		return null;
	}
	
    public ArrayList<State> nextStates(State currentState){
    	// assign an item to the bag if constraints are valid
		// forward checking (keep track of assigned variables
    	ArrayList<State> nextStates = new ArrayList<State>();
    	for(Character b: currentState.getBags().keySet()) {    		
    		for(Character c: currentState.getUnassignedItems().toCharArray()) {
    			State currCopy = new State(currentState);
    			currCopy.addItem(b, c);
    			
    			if (constraintsSatisfiable(currCopy)) {
    				nextStates.add(currCopy);
    			}
    		}
    	}
    	return nextStates;
    }
    
    public boolean constraintsValid(State currentState) {
    	for(Constraint c: this.constraints) {
    		if(!c.isValid(currentState)) return false;
    	}
    	return true;
    }
     
    public boolean constraintsSatisfiable(State currentState) {
    	for(Constraint c: this.constraints) {
    		if(!c.isSatisfiable(currentState)) return false;
    	}    	
    	return true;
    }
	
	private State findSolution() {
		
	    String allItems = getItemString();
		HashMap<Character, String> emptyBags = getEmptyBags();
		State initialState = new State(emptyBags, allItems);
				
		return backTracking(initialState);
		//State solution = null;
		
		//for (State s : nextStates(initialState)) {
			//State sol = backTracking(s);
			
		//	if (sol != null) return sol;
		//}
		//return null;
		
	}
	
	private int loadFile(String input_file) {

		File file = new File(input_file);
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("Could Not Find Input File");
			e.printStackTrace();
		}
		
		//ArrayList<Item> items = new ArrayList<Item>();
		//ArrayList<Bag> bags = new ArrayList<Bag>();

		
		itemWeights = new HashMap<Character, Integer>();
		bagCapacities = new HashMap<Character, Integer>();

		constraints = new ArrayList<Constraint>();
				
		String line;
		String separator = "#####"; 
		int section_number = 0;
		try {
			while ((line = br.readLine()) != null) {
				if (line.contains(separator)) {
					section_number++;
					continue;
				}
				String[] lineArgs = line.split(" ");
				
				switch(section_number) {
				case 1: // Item Assignment
					itemWeights.put(lineArgs[0].charAt(0), Integer.parseInt(lineArgs[1]));
					break;
				case 2: // Bag Assignment
					bagCapacities.put(lineArgs[0].charAt(0), Integer.parseInt(lineArgs[1]));
					break;
				case 3: // Fitting Limits
					constraints.add(new FittingLimit(lineArgs[0], lineArgs[1]));
					break;
				case 4: // Unary Inclusive
					String inclusiveBags = "";
					for (int i = 1; i < lineArgs.length; i++) {
						inclusiveBags += lineArgs[i];
					}
					constraints.add(new UnaryInclusive(lineArgs[0].charAt(0), inclusiveBags));
					break;
				case 5: // Unary Exclusive
					String exclusiveBags = "";
					for (int i = 1; i < lineArgs.length; i++) {
						exclusiveBags += lineArgs[i];
					}
					constraints.add(new UnaryExclusive(lineArgs[0].charAt(0), exclusiveBags));
					break;
				case 6: // Binary Equals
					constraints.add(new BinaryEquals(lineArgs[0].charAt(0), lineArgs[1].charAt(0)));
					break;
				case 7: // Binary Not Equals
					constraints.add(new BinaryNotEquals(lineArgs[0].charAt(0), lineArgs[1].charAt(0)));
					break;
				case 8: // Mutual Inclusive
					constraints.add(new MutualInclusive(lineArgs[0].charAt(0), lineArgs[1].charAt(0), lineArgs[2].charAt(0), lineArgs[3].charAt(0)));
					break;
				default:
					break;
				}
			}
			constraints.add(new WeightLimit(this.itemWeights, this.bagCapacities));

		} catch (IOException e) {
			System.out.println("Could Not Read Input File");
			e.printStackTrace();
			return 0;
		}
		
		if (br != null)
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return 1;
	}
	
	private HashMap<Character, String> getEmptyBags() {
		HashMap<Character, String> emptyBags = new HashMap<Character, String>();
		for (char c : this.bagCapacities.keySet()) {
			emptyBags.put(c, "");
		}
		return emptyBags;
	}
	
	private String getItemString() {
		String items = "";
		for (char c : this.itemWeights.keySet()) {
			items += c;
		}
		return items;
	}
	
	private void saveOutput(State solution, String filename) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		WeightLimit wl = new WeightLimit(this.itemWeights, this.bagCapacities);
		try {
			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			
			if (solution == null) {
				bw.write("no solution");
				return;
			}
			
			for (char bag : solution.getBags().keySet()) {
				String contents = Character.toString(bag);
				for (char item : solution.getBags().get(bag).toCharArray()) {
					contents += " " + item;
				}
				bw.write(contents);
				bw.newLine();
				bw.write(String.format("number of items: %d", solution.getBags().get(bag).length()));
				bw.newLine();
				int weight = wl.getCurrentWeight(solution.getBags().get(bag));
				int capacity = this.bagCapacities.get(bag);
				bw.write(String.format("total weight: %d/%d", weight, capacity));
				bw.newLine();
				bw.write(String.format("wasted capacity: %d", capacity - weight));
				bw.newLine();
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{	
		String output_file = args[1];
		
		CSP_ACML csp = new CSP_ACML();
		int res = csp.loadFile(args[0]);
		if (res == 0) return;
		
		long start_time = System.nanoTime();
		State solution = csp.findSolution();
		long time_taken = System.nanoTime() - start_time;
		
		System.out.println(String.format("Time Taken: %dns", time_taken));
		csp.saveOutput(solution, output_file);
		return;
	}
}

/*
 *
 Testing
 
 		HashMap<Character, String> testBags = new HashMap<Character, String>();		
		HashMap<Character, Integer> testWeights = new HashMap<Character, Integer>();
		HashMap<Character, Integer> testCapacities = new HashMap<Character, Integer>();
 
testWeights.put('A', 95);
testWeights.put('B', 6);
testWeights.put('C', 1);

testCapacities.put('x', 3);
testCapacities.put('y', 7);
testCapacities.put('z', 100);


testBags.put('z', "C");
testBags.put('y', "B");
//testBags.put('z', "C");
testBags.put('x', "");

State testState = new State(testBags, "");
//FittingLimit fl = new FittingLimit("1", "3");
//WeightLimit wl = new WeightLimit();
// char item, String bagNames
//  UnaryInclusive ui = new UnaryInclusive('A', "zy");
// UnaryInclusive ui = new UnaryInclusive('A', "x"); // false
// UnaryExclusive ue = new UnaryExclusive('A', "xz");
//BinaryNotEquals be = new BinaryNotEquals('A', 'B');
MutualInclusive mi = new MutualInclusive('A', 'B','y','x');
boolean valid = mi.isValid(testState);

//boolean valid = wl.isValid(testState, testWeights, testCapacities);
System.out.println(valid);
*/

