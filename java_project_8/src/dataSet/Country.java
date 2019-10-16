package dataSet;

import java.util.Iterator;

/**
 * One object  contains the name of the country and the list of subscriptions
 */
public class Country {
    private String name;
    private int maxYear;
    private int minYear;
    private LinkedList<DataPerYear> Dataset;


    /**
     * Constructs a Country object with the specified country names, number of years, and list of DataPerYear object.
     * @param newName                   name of the country.
     */
    public Country(String newName) {
        name = newName;
        maxYear = 9999;
        minYear = 0;
        Dataset = new LinkedList<DataPerYear>();
    }

    /**
     * Mutator method sets the name.
     * @param newName
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Returns the value of name.
     * @return the name of the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the value of maxYear.
     * @return the end year of the country's data.
     */
    public int getMaxYear() {return  maxYear;}

    /**
     * Returns the value of minYear
     * @return the start  year of the country's data.
     */
    public int getMinYear() {return  minYear;}

    /**
     * Returns the value of numberOfYears
     * @return size
     */
    public int getNumberOfYears(){
        return Dataset.size();
    }

    /**
     * Returns the list of subscriptions
     * @return subscriptions
     */
    public LinkedList<DataPerYear> getDataSet() {
        return Dataset;
    }

    /**
     * Takes the year and a single subscription data from the user input.
     * Use this to create a new DataPerYear object and save it in array.
     * @param newYearLabel                  the year for a subscription data.
     * @param newCountryData                    the number of subscriptions for a specific year.
     */
    public void addDataYear(int newYearLabel, double newCountryData) {
        int yearLabel = newYearLabel;
        double CountryData = newCountryData;
        DataPerYear current = new DataPerYear(yearLabel, CountryData);
        Dataset.add(current);
        if (Dataset.size() == 1){
            minYear = yearLabel;
            maxYear = yearLabel;
        }else {
            if (yearLabel < minYear) {
                minYear = yearLabel;
            }
            if (yearLabel > maxYear) {
                maxYear = yearLabel;
            }
        }
    }

    /**
     *  Takes the start and end year are requested by the user, and returns  for the total number of data between start and end years.
     * @param newRequestedStart                 the starting year is requested by the user.
     * @param newRequestedEndYear                   the ending year is requested by the user.
     * @return the total number of data for specified period.
     * @throws IllegalArgumentException if the user request the invalid period .
     */
    public double getNumDataSetForPeriod(int newRequestedStart, int newRequestedEndYear) throws IllegalArgumentException {
        int requestedStart = newRequestedStart;
        int requestedEndYear = newRequestedEndYear;
        double DataForPeriod = 0;
        double DataForInvalidPeriod = 0;
        int startOfPeriod = requestedStart - minYear;
        int endOfPeriod = startOfPeriod + requestedEndYear - requestedStart;
        String message;
        Iterator<DataPerYear> iterator = Dataset.iterator();
        while (iterator.hasNext()) {
            DataForInvalidPeriod += iterator.next().getData();
        }
        if ((requestedEndYear - requestedStart < 0) || (requestedStart > maxYear) || (requestedEndYear < minYear) || (requestedStart < minYear && requestedEndYear > maxYear)) {
            message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal data between %d - %d = %.2f\n",
                    requestedStart, requestedEndYear, name, minYear, maxYear, minYear, maxYear, DataForInvalidPeriod);
            throw new IllegalArgumentException(message);
        } else {
            iterator = Dataset.iterator();
            int counter = 0;
            if ((requestedStart >= minYear) && (requestedEndYear <= maxYear)) {
                while (iterator.hasNext()) {
                    double current = iterator.next().getData();
                    if (counter >= startOfPeriod && counter <= endOfPeriod) {
                        DataForPeriod += current;
                    }
                    counter++;
                }
                return DataForPeriod;
            } else{
                message = "";
                if ((requestedStart >= minYear) && (requestedEndYear > maxYear)) {
                    while (iterator.hasNext()) {
                        double current = iterator.next().getData();
                        if (counter >= startOfPeriod) {
                            DataForPeriod += current;
                        }
                        counter++;
                    }
                    message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal data between %d - %d = %.2f\n",
                            requestedStart, requestedEndYear, name, minYear, maxYear, requestedStart, maxYear, DataForPeriod);
                }
                if ((requestedStart < minYear) && (requestedEndYear <= maxYear)) {
                    while (iterator.hasNext()) {
                        double current = iterator.next().getData();
                        if (counter <= endOfPeriod) {
                            DataForPeriod += current;
                        }
                        counter++;
                    }
                    message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal data between %d - %d = %.2f\n",
                            requestedStart, requestedEndYear, name, minYear, maxYear, minYear, requestedEndYear, DataForPeriod);
                }
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Compares two object, and returns true if they have a same name.
     * @param obj the object to compare
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Country)
        {
            Country other = (Country)obj;
            if (other.name.equals(this.name))
                return true;
        }
        return false;
    }

    /**
     * Returns a representation of the country in type String.
     * @return the country name and data of each year.
     */
    public String toString(){
        String year = "";
        String partialList = "";
        for(DataPerYear Data: Dataset){
            year += String.format(" %16s", Data.getYear());
            partialList += String.format(" %16s", Data.toString());
        }
        return  "\n" + String.format("  %20s","Country,Year") + year + "\n" + String.format("%22s",name) + partialList ;
    }

}