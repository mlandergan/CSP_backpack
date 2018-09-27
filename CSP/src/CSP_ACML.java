import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSP_ACML {
	
	String output_file = "";
	
	public static void main(String[] args)
	{	
		String input_file = args[0];
		String output_file = args[1];

		File file = new File(input_file);
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("Could Not Find Input File");
			e.printStackTrace();
		}
		
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Bag> bags = new ArrayList<Bag>();
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();
		
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
					items.add(new Item(lineArgs[0], lineArgs[1]));
					break;
				case 2: // Bag Assignment
					bags.add(new Bag(lineArgs[0], lineArgs[1]));
					break;
				case 3: // Fitting Limits
					constraints.add(new FittingLimit(lineArgs[0], lineArgs[1]));
					break;
				case 4: // Unary Inclusive
					ArrayList<String> inclusiveBags = new ArrayList<String>();
					for (int i = 1; i < lineArgs.length; i++) {
						inclusiveBags.add(lineArgs[i]);
					}
					constraints.add(new UnaryInclusive(lineArgs[0], inclusiveBags));
					break;
				case 5: // Unary Exclusive
					break;
				case 6: // Binary Equals
					break;
				case 7: // Binary Not Equals
					break;
				case 8: // Mutual Inclusive
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Could Not Read Input File");
			e.printStackTrace();
		}
		return;
	}
}
