package cellularData;
/**
 *  Tests the CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to fill the CellularData class.
 *
 * @author Foothill College, Fu Hui
 */
public class TestCSVReader
{
	/**
	 * Uses a CSVReader to parse a CSV file.
	 * Adds each parsed line to an instance of the CellularData class.
	 */
	public static void main(String[] args) 
	{
		// NOTE: Make sure to use relative path instead of specifying the entire
		// path
		// (such as /Users/alicew/myworkspace/so_on_and_so_forth).
		final String FILENAME = "resources\\cellular_short_oneDecade.csv";	// Directory path for Mac OS X

		// TODO: Make sure to test with the full input file as well
		// final String FILENAME = "resources/cellular.csv"; // Directory path for Mac OS X
		// final String FILENAME = "resources\\cellular.csv"; // Directory path for Windows OS (i.e. Operating System)

		// TODO: Create the class CSVReader to parse the CSV data file
		//       The class constructor should only take a string as argument
		//       for the name of the input file.
		//       The constructor should fill the array of country names, year labels, etc.
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(FILENAME);
		// TODO: In class CSVReader the accessor methods should only return values
		//       at instance variables.
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		

		// Stores the 2D array of cellular data for all countries.
		CellularData datatable;
		int numRows = parsedTable.length;
		int numColumns = parser.getNumberOfYears();
		int startingYear = yearLabels[0];

		datatable = new CellularData(numRows, numColumns, startingYear);

		// From the array that stores parsed information,
		// add one country at a time to an object of type CellularData.
		for (int countryIndex = 0; countryIndex < countryNames.length; countryIndex++)
		{
			double [] countryData = parsedTable[countryIndex];
			datatable.addCountry(countryNames[countryIndex], countryData);					
		}

		// Display the string representation of the data table.
		System.out.println(datatable);
		// Given the cellular_short_oneDecade.csv file, the output is:
		// Country Name 	2005	2006	2007	2008	2009	2010	2011	2012	2013	2014	
		//   Bangladesh	    6.29	13.21	23.47	30.17	34.35	44.95	55.19	62.82	74.43	80.04	
		// Bahamas, The	   69.21	75.38	109.34	102.79	101.22	118.83	81.56	80.65	76.05	82.30	
		//       Brazil	   46.31	53.11	63.67	78.55	87.54	100.88	119.00	125.00	135.31	138.95	

		double totalSubscriptions;
		String countryName;

		countryName = countryNames[1];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,2005,2014);
		System.out.printf("\n" + countryName + " (2005 to 2014): %.2f \n", totalSubscriptions);
		// the output is: 
		// Bahamas, The (2005 to 2014): 897.33 

		countryName = countryNames[2];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,1950,2000);
		System.out.printf("\n" + countryName + " (1950 to 2000): %.2f \n", totalSubscriptions);
		// the output is: 
		// Illegal Argument Request of start year 1950. Valid period for Brazil is 2005 to 2014.
		// Brazil (1950 to 2000): 948.34  

		countryName = countryNames[0];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,2020,2030);
		System.out.printf("\n" + countryName + " (2020 to 2030): %.2f \n", totalSubscriptions);
		// the output is: 
		// Illegal Argument Request of start year 2020 end year 2030. Valid period for Bangladesh is 2005 to 2014.
		// Bangladesh (2005 to 2014): 424.91 

		// TODO: For full credit, include test cases in addition to those provided.
		//       Use the full cellular.csv for the input file of your additional test cases.
		//
		// TODO: Also, test for additional cases where the requested range of years is invalid.

		final String FILENAME_TWO = "resources\\cellular.csv";
		parser = new CSVReader(FILENAME_TWO);
		countryNames = parser.getCountryNames();
		yearLabels = parser.getYearLabels();
		parsedTable = parser.getParsedTable();
		numRows = parsedTable.length;
		numColumns = parser.getNumberOfYears();
		startingYear = yearLabels[0];
		datatable = new CellularData(numRows, numColumns, startingYear);
		for (int countryIndex = 0; countryIndex < countryNames.length; countryIndex++)
		{
			double [] countryData = parsedTable[countryIndex];
			datatable.addCountry(countryNames[countryIndex], countryData);
		}
		System.out.println(datatable);
		countryName = countryNames[200];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,1999,2013);
		System.out.printf("\n" + countryName + " (1999 to 2013): %.2f \n", totalSubscriptions);
		countryName = countryNames[100];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,1960,2014);
		System.out.printf("\n" + countryName + " (1960 to 2014): %.2f \n", totalSubscriptions);
		countryName = countryNames[99];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,1002,3030);
		System.out.printf("\n" + countryName + " (1002 to 3030): %.2f \n", totalSubscriptions);
		countryName = countryNames[237];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,1985,2010);
		System.out.printf("\n" + countryName + " (1985 to 2010): %.2f \n", totalSubscriptions);
		countryName = countryNames[21];
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryName,1959,2033);
		System.out.printf("\n" + countryName + " (1959 to 2033): %.2f \n", totalSubscriptions);


		System.out.println("\nDone with TestCSVReader.\n");
	}
}
