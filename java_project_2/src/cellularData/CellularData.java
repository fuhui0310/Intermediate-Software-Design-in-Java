package cellularData;

import java.io.PrintStream;

/**
 * One object represents a table containing all cellular data for different countries.
 * @author  Fu Hui
 */
public class CellularData {
    private int numRows;
    private int numColumns;
    private int startingYear;
    private int endingYear;
    private String[] country;
    private double[][] partial;
    private int counter = 0;
    /**
     *  Constructs a CellularData object with the specified number of rows, number of columns,  starting year, and ending year,
     *  and determine the size of the array of country and partial based on parameter.
     * @param setNumRows                    The number of rows
     * @param setNumColumns                     The number of columns
     * @param setStartingYear                   The starting year
     */
    public CellularData(int setNumRows, int setNumColumns, int setStartingYear) {
        numRows = setNumRows;
        numColumns = setNumColumns;
        startingYear = setStartingYear;
        endingYear = startingYear + numColumns -1;
        country = new String[numRows];
        partial = new double[numRows][numColumns];

    }

    /**
     * Adds a country and its associated data to the array.
     * @param setCountry                The name of the country
     * @param setPartial                    A one-dimensional array of data
     */
    public void addCountry(String setCountry, double[] setPartial) {
        if(counter < country.length) {
            country[counter] = setCountry;
            for (int i = 0; i < setPartial.length; i++) {
                partial[counter][i]  = setPartial[i];
            }
            counter ++;
        }
    }

    /**
     * Returns the total number of cellular subscriptions for a given country and time period,
     * and displays a message and returns -1 if the user's request for invalid data.
     * @param targetConuntry                    The name of the given country
     * @param beginningOfPeriod                 The starting year of the time period
     * @param endingOfPeriod                    The ending year of the time period
     * @return the total number of cellular subscriptions, or  a message and -1.0 if the user's request for invalid data.
     */
    public double getNumSubscriptionsInCountryForPeriod(String targetConuntry, int beginningOfPeriod, int endingOfPeriod) {
        double totalSubscriptions = 0;
        double totalSubscriptionsForTheVaildSubPeriod = 0;
        int numYears = beginningOfPeriod - startingYear;
        int yearsOfPeriod = endingOfPeriod - beginningOfPeriod;
        for (int i = 0; i < country.length; i++) {
            if (targetConuntry.equalsIgnoreCase(country[i])) {
                for (int j = 0; j < numColumns; j++) {
                    totalSubscriptionsForTheVaildSubPeriod += partial[i][j];
                }
            }
        }
        if( endingOfPeriod - beginningOfPeriod >= 0){
            try {
                for (int i = 0; i < country.length; i++) {
                    if (targetConuntry.equalsIgnoreCase(country[i])) {
                        for (int j = 0; j < yearsOfPeriod + 1; j++) {
                            totalSubscriptions += partial[i][numYears];
                            numYears++;
                        }
                    }
                }
                return totalSubscriptions;
            } catch (Exception error) {
                System.out.print("\n" + "Illegal Argument Request of start year " + beginningOfPeriod + ". Valid period for " + targetConuntry + " is " + startingYear + " to " + endingYear + ".");
                return totalSubscriptionsForTheVaildSubPeriod;
            }
        }else{
            System.out.print("\n" + "Illegal Argument Request of start year " + beginningOfPeriod + ". Valid period for " + targetConuntry + " is " + startingYear + " to " + endingYear + ".");
            return totalSubscriptionsForTheVaildSubPeriod;
        }
    }

    /**
     * String representation of the array in order of:
     * country, data of each year
     */
    public String toString(){
        String year = "";
        for(int i = 0; i< numColumns; i++){
            year += String.format(" %55s",startingYear + i);
        }
        String datatable = "";
        for(int i = 0; i < numRows; i++){
            String partialList = "";
            for(int j = 0; j < numColumns; j++){
                partialList += String.format(" %55s", partial[i][j]);
            }
            datatable +=  String.format(" %55s",country[i]) + partialList + "\n";
        }
        return  String.format("  %50s","Country,Year") + year + "\n" + datatable;
    }


}
