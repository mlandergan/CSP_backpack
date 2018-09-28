import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSP_ACML {
		
	HashMap<Character, Integer> items;
	HashMap<Character, Integer> bags;

	ArrayList<Constraint> constraints;
	
	
	private boolean findSolution() {
		return false;
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

		
		items = new HashMap<Character, Integer>();
		bags = new HashMap<Character, Integer>();

		constraints = new ArrayList<Constraint>();
		constraints.add(new WeightLimit());
				
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
					items.put(lineArgs[0].charAt(0), Integer.parseInt(lineArgs[1]));
					break;
				case 2: // Bag Assignment
					bags.put(lineArgs[0].charAt(0), Integer.parseInt(lineArgs[1]));
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
		} catch (IOException e) {
			System.out.println("Could Not Read Input File");
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}
	
	public static void main(String[] args)
	{	
		String output_file = args[1];
		
		CSP_ACML csp = new CSP_ACML();
		int res = csp.loadFile(args[0]);
		if (res == 0) return;
		
		csp.findSolution();
		
		return;
	}
}
