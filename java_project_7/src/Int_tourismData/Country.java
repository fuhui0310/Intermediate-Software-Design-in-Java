package Int_tourismData;

import java.util.Iterator;

/**
 * One object  contains the name of the country and the list of number of tourist
 */
public class Country {
    private String name;
    private int maxYear;
    private int minYear;
    private LinkedList<TourismYear> numberOfTourist;

    /**
     * Constructs a Country object with the specified country names, number of years, and list of TourismYear object.
     * @param newName                   name of the country.
     */
    public Country(String newName) {
        name = newName;
        maxYear = 9999;
        minYear = 0;
        numberOfTourist = new LinkedList<TourismYear>();
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
     * Returns the value of numberOfYears
     * @return size
     */
    public int getNumberOfYears(){
        return numberOfTourist.size();
    }

    /**
     * Returns the list of numberOfTourist
     * @return numberOfTourist
     */
    public LinkedList<TourismYear> getNumberOfTourist() {
        return numberOfTourist;
    }

    /**
     * Takes the year and a single subscription data from the user input.
     * Use this to create a new TourismYear object and save it in array.
     * @param newYearLabel                  the year for a tourism data.
     * @param newCountryData                    the number of numberOfTourist for a specific year.
     */
    public void addTourismYear(int newYearLabel, double newCountryData) {
        int yearLabel = newYearLabel;
        double CountryData = newCountryData;
        TourismYear current = new TourismYear(yearLabel, CountryData);
        numberOfTourist.add(current);
        if (numberOfTourist.size() == 1){
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
     *  Takes the start and end year are requested by the user, and returns  for the total number of numberOfTourist between start and end years.
     * @param newRequestedStart                 the starting year is requested by the user.
     * @param newRequestedEndYear                   the ending year is requested by the user.
     * @return the total number of numberOfTourist for specified period.
     * @throws IllegalArgumentException if the user request the invalid period .
     */
    public double getNumberOfTouristForPeriod(int newRequestedStart, int newRequestedEndYear) throws IllegalArgumentException {
        int requestedStart = newRequestedStart;
        int requestedEndYear = newRequestedEndYear;
        double numberOfTouristForPeriod = 0;
        double numberOfTouristForTheValidPeriod = 0;
        int startOfPeriod = requestedStart - minYear;
        int endOfPeriod = startOfPeriod + requestedEndYear - requestedStart;
        String message;
        Iterator<TourismYear> iterator = numberOfTourist.iterator();
        while (iterator.hasNext()) {
            numberOfTouristForTheValidPeriod += iterator.next().getTourists();
        }
        if ((requestedEndYear - requestedStart < 0) || (requestedStart > maxYear) || (requestedEndYear < minYear) || (requestedStart < minYear && requestedEndYear > maxYear)) {
            message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal numberOfTourist between %d - %d = %.2f\n",
                    requestedStart, requestedEndYear, name, minYear, maxYear, minYear, maxYear, numberOfTouristForTheValidPeriod);
            throw new IllegalArgumentException(message);
        } else {
            iterator = numberOfTourist.iterator();
            int counter = 0;
            if ((requestedStart >= minYear) && (requestedEndYear <= maxYear)) {
                while (iterator.hasNext()) {
                    double current = iterator.next().getTourists();
                    if (counter >= startOfPeriod && counter <= endOfPeriod) {
                        numberOfTouristForPeriod += current;
                    }
                    counter++;
                }
                return numberOfTouristForPeriod;
            } else{
                message = "";
                if ((requestedStart >= minYear) && (requestedEndYear > maxYear)) {
                    while (iterator.hasNext()) {
                        double current = iterator.next().getTourists();
                        if (counter >= startOfPeriod) {
                            numberOfTouristForPeriod += current;
                        }
                        counter++;
                    }
                    message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal numberOfTourist between %d - %d = %.2f\n",
                            requestedStart, requestedEndYear, name, minYear, maxYear, requestedStart, maxYear, numberOfTouristForPeriod);
                }
                if ((requestedStart < minYear) && (requestedEndYear <= maxYear)) {
                    while (iterator.hasNext()) {
                        double current = iterator.next().getTourists();
                        if (counter <= endOfPeriod) {
                            numberOfTouristForPeriod += current;
                        }
                        counter++;
                    }
                    message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal numberOfTourist between %d - %d = %.2f\n",
                            requestedStart, requestedEndYear, name, minYear, maxYear, minYear, requestedEndYear, numberOfTouristForPeriod);
                }
                throw new IllegalArgumentException(message);
            }
        }
    }

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
        for(TourismYear tourist: numberOfTourist){
            year += String.format(" %16s", tourist.getYear());
            partialList += String.format(" %16s", tourist.toString());
        }
        return  "\n" + String.format("  %20s","Country,Year") + year + "\n" + String.format("%22s",name) + partialList ;
    }

}
