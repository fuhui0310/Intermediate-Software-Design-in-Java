package Int_tourismData;

import Int_tourismData.CSVReader;
import Int_tourismData.Country;

/**
 * Provides access to CSV data.
 * @author Foothill College, Bita M. [YOUR NAME HERE]
 */
public class TourismDataModel
{
    private Country[] tourismModel;
    private final String YVaule = "Tourism Rate";
    private final String title = "International Tourism Data";

    public String getYVaule(){
        return YVaule;
    }

    public String getTitle() {
        return title;
    }


    public TourismDataModel()
    {
        tourismModel = parseCSVFile("resources\\International_tourism.csv");
    }

    private Country[] parseCSVFile(final String filename)
    {
        // Parses the CSV data file
        // NOTE: Handle all exceptions in the constructor.
        //       For full credit, do *not* throw exceptions to main.
        CSVReader parser = new CSVReader(filename);

        // In class CSVReader the accessor methods only return values of instance variables.
        String [] countryNames = parser.getCountryNames();
        int [] yearLabels = parser.getYearLabels();
        double [][] parsedTable = parser.getParsedTable();


        // Holds the data for all Country object read from the input data file.
        Country [] countries;

        // Initializes the to the number of entries read by CSVReader.
        countries = new Country[countryNames.length];

        // Reference to a Country object
        Country current;

        // Go through each country name parsed from the CSV file.
        for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
        {
            int numberOfYears = yearLabels.length;

            // TODO: Initially convert your CountryList to a generic LinkedList and make sure that list builds
            // 		 correctly using the original Country constructor which takes the numberOfYears to setup
            // 		 the array of number of tourists.
            // NOTE: Once you've verified that your generic LinkedList builds correctly,
            //       make sure to comment the line below before submitting.
            //current = new Country(countryNames[countryIndex], numberOfYears);		// version 1

            // TODO: Once you are successful in creating a generic LinkedList of countries, create a
            // 		 LinkedList of TourismYear in the Country class.
            // 	     So, your Country class should no longer have an array of TourismYear objects.
            current = new Country(countryNames[countryIndex]);	// version 2 and final version of Country constructor

            // Go through each year of tourism data read from the CSV file.
            for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
            {
                double [] allTourists = parsedTable[countryIndex];
                double countryData = allTourists[yearIndex];
                current.addTourismYear(yearLabels[yearIndex], countryData);
            }

            // Add the newly created country to the 1D array.
            countries[countryIndex] = current;
        }

        return countries;
    }

    public Country[] getTourismData()
    {
        return this.tourismModel;
    }
}
