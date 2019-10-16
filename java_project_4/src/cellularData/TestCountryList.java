package cellularData;

import java.util.Random;
import java.util.Scanner;

/**
 *  Tests the CountryList class by creating multiple objects of type CountryNode.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *  Then adds the newest country read into the list
 *
 * @author Foothill College, Fu Hui
 */
public class TestCountryList
{
	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TODO: Use this method to debug a subset of the input file data.
		// Note: The implementation of method is optional.
		//       The purpose is to help you debug
	}

	/**
	 * Builds a random list of countries.
	 * @param allCountries      An array of Country objects
	 */
	private void testRandomListOfCountries(Country [] allCountries)
	{
		// Prompts the user for the number of countries they want to add to the list.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many countries do you want to add to the list?");
		int requestedSize = Integer.parseInt( keyboard.nextLine() );

		// Build the list out of a random selection of countries.
		Random random = new Random();

		// TODO: Define the CountryNode class to hold the data for one Country object 
		//       and a reference to the next node.
		//       Define the CountryList class to be a singly list list of CountryNode objects.
		CountryList selectedCountries = new CountryList();

		for (int i = 0; i < requestedSize; i++)
		{
			// Selects a random index of the Country data array
			int selectedIndex = random.nextInt(allCountries.length);

			// TODO: Define the add() method in class such that it adds the randomly
			//       selected Country to the *end* of the list.
			Country countryToAdd = allCountries[selectedIndex];
			System.out.printf("Adding country with name %s to the end of the list.\n", countryToAdd.getName());
			selectedCountries.add(countryToAdd);
		}


		// TODO: Override the toString() method such that it traverses the list of nodes
		//       and prints every element in the list.
		// Note: To debug your list, do not comment this line out
		System.out.println("\nList of countries: " + selectedCountries);
		// Assuming the user selects to add 3 songs to the list, the output would be
		// List of countries: 
		// Brazil		46.31	53.11	63.67	78.55	87.54	100.88	119.00	125.00	135.30	138.95	
		// Germany		94.55	102.28	115.14	126.55	126.22	106.48	109.65	111.59	120.92	120.42	
		// Bangladesh	6.28	13.20	23.46	30.16	34.35	44.94	55.19	62.82	74.42	80.03

		// Note: To debug specific elements of your list, do not comment this line out
		try {
			int index = 0;
			Country first = selectedCountries.getIndex(index);
			index = selectedCountries.size() / 2;
			Country middle = selectedCountries.getIndex(index);
			index = selectedCountries.size() - 1;
			Country last = selectedCountries.getIndex(index);
			// Print out the results from above getIndex() operations
			System.out.println ("\nfirst: " + first);
			System.out.println ("middle: " + middle);
			System.out.println ("last: " + last);
		}catch (IndexOutOfBoundsException ex){
			System.out.print(ex.getMessage());
		}

		// Check if the name of a country is in the list.
		// If the country is found, print the details.
		// Otherwise output not found.
		System.out.println("\nWhat country do you want to search for?");
		String countryNameToFind = keyboard.nextLine();


		// TODO: Define a Country constructor which will create a dummy Country object
		//       that only holds only the name of the Country.
		//
		// NOTE: In order to call contains() method in our Linked List,
		//       we need to define a constructor for our Country class
		//       that takes in a String. This Country object will have
		//       no other useful information, specifically no SubscriptionYears.
		Country tmpCountry = new Country(countryNameToFind);
		Country foundCountry = selectedCountries.contains(tmpCountry);
		if (foundCountry != null)
		{
			System.out.println("Country " + countryNameToFind + " found with details:\n" + foundCountry);
		}
		else
		{
			System.out.println("Country " + countryNameToFind + " not found.");
		}   

		// Extra Credit Opportunity
		// TODO: For full credit, include test cases for the extra credit portion.
		System.out.println("\nAdding one more country in the front of the list.");
		int selectedIndexOne = random.nextInt(allCountries.length);
		Country countryToAddFront = allCountries[selectedIndexOne];
		System.out.println(countryToAddFront.toString());
		System.out.println("\nAdding one more country in the middle of the list.");
		int selectedIndexTwo = random.nextInt(allCountries.length);
		Country countryToAddMiddle = allCountries[selectedIndexTwo];
		System.out.println(countryToAddMiddle.toString());
		System.out.println("\nAdding one more country in the end of the list.");
		int selectedIndexThree = random.nextInt(allCountries.length);
		Country countryToAddLast = allCountries[selectedIndexThree];
		System.out.println(countryToAddLast.toString());
		// TODO: At minimum include a test for each case of inserting at the 
		try {
			int index = 0;
			selectedCountries.insertAtIndex(countryToAddFront,index);
			index = selectedCountries.size() - 1;
			selectedCountries.insertAtIndex(countryToAddLast,index);
			index = selectedCountries.size() / 2;
			selectedCountries.insertAtIndex(countryToAddMiddle,index);
			System.out.println("\nList of countries: " + selectedCountries);
		}catch (IndexOutOfBoundsException ex){
			System.out.print(ex.getMessage());
		}
		//
	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a CountryList object.
	 */
	public static void main(String[] args)
	{
		// NOTE: Make sure to use relative path instead of specifying the entire path
		// (avoid entire path such as /Users/alicew/myworkspace/so_on_and_so_forth).
		final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS

		// TODO: Make sure to test with the full input file as well
		//final String FILENAME = "resources/cellular.csv"; // Directory path for Mac OS X
		// final String FILENAME = "resources\\cellular.csv"; // Directory path for Windows OS (i.e. Operating System)

		// For debugging purposes
		final int NUM_COUNTRIES_TO_TEST = 4;			// Note: Include test cases in addition to 4    

		// Parses the CSV data file
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(FILENAME);

		// In class CSVReader the accessor methods only return values of instance variables.
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();


		// Holds the data for all Country object read from the input data file.
		Country [] countries;

		// Initializes the to the number of entries read by CSVReader.
		countries = new Country[countryNames.length];

		// Note: If you are debugging, use this version instead to limit the number of countries
		// countries = new Country[NUM_COUNTRIES_TO_TEST];

		// Reference to a Country object
		Country current;

		// Go through each country name parsed from the CSV file.
		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			// Create a Country object.
			current = new Country(countryNames[countryIndex], numberOfYears);

			// Go through each year of cellular data read from the CSV file.
			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}

			// Add the newly created country to the 1D array.
			countries[countryIndex] = current;
		}

		// Creates an object of our current application, for testing purposes.
		TestCountryList application = new TestCountryList();

		// Note: Initially, to test your output you may hard code the number of

		//       countries added, and the array positions selected.
		//		 However, make sure to comment this out before submitting your work.
		//application.debugListOfCountries(countries);

		// Tests the CountryLinkedList class by adding a random number of entries
		// from the array of Country objects.
		application.testRandomListOfCountries(countries);

		// Flush the error stream.
		System.err.flush();

		System.out.println("\nDone with TestCountryList.");
	}
}