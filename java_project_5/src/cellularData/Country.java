package cellularData;

/**
 * One object  contains the name of the country and the list of subscriptions
 */
public class Country {
    private String name;
    private int numberOfYears;
    private SubscriptionYear[] subscriptions;
    private int count = 0;

    /**
     * Constructs a Country object with the specified country names, number of years, and array of SubscriptionYear object.
     * @param newName                   name of the country.
     * @param newNumberOfYears                  number of years.
     */
    public Country(String newName, int newNumberOfYears) {
        name = newName;
        numberOfYears = newNumberOfYears;
        subscriptions = new SubscriptionYear[numberOfYears];
    }

    /**
     * Constructs a Country object with only country names.
     * @param countryNameToFind                 name of the country.
     */
    public Country(String countryNameToFind) {
        name = countryNameToFind;
    }

    /**
     * Constructs a deep copy of the current list.
     * @param anotherCountry
     */
    public Country(Country anotherCountry){
        this(anotherCountry.name, anotherCountry.numberOfYears);
        for(int i = 0; i < numberOfYears; i++){
            addSubscriptionYear(anotherCountry.subscriptions[i].getYear(),anotherCountry.subscriptions[i].getSubscriptions());
        }

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
     * @return
     */
    public int getNumberOfYears(){
        return numberOfYears;
    }

    /**
     * Sets the value to specific index in the subscription list.
     * @param index
     * @param newCountryData
     * @throws IndexOutOfBoundsException
     */
    public void setSubscriptions(int index, double newCountryData) throws IndexOutOfBoundsException {
        if (index > subscriptions.length - 1) {
            String message = "Warning: This index is invaild.";
            throw new IndexOutOfBoundsException(message);
        } else {
            subscriptions[index].setSubscriptions(newCountryData);
        }
    }

    /**
     * Takes the year and a single subscription data from the user input.
     * Use this to create a new SubscriptionYear object and save it in array.
     * @param newYearLabel                  the year for a subscription data.
     * @param newCountryData                    the number of subscriptions for a specific year.
     */
    public void addSubscriptionYear(int newYearLabel, double newCountryData) {
        int yearLabel = newYearLabel;
        double CountryData = newCountryData;
        subscriptions[count] = new SubscriptionYear(yearLabel, CountryData);
        count++;
    }

    /**
     *  Takes the start and end year are requested by the user, and returns  for the total number of subscriptions between start and end years.
     * @param newRequestedStart                 the starting year is requested by the user.
     * @param newRequestedEndYear                   the ending year is requested by the user.
     * @return the total number of subscriptions for specified period.
     * @throws IllegalArgumentException if the user request the invalid period .
     */
    public double getNumSubscriptionsForPeriod(int newRequestedStart, int newRequestedEndYear) throws IllegalArgumentException {
        int requestedStart = newRequestedStart;
        int requestedEndYear = newRequestedEndYear;
        double subscriptionsForPeriod = 0;
        double subscriptionsForTheVaildSubPeriod = 0;
        int startingYear = subscriptions[0].getYear();
        int endingYear = subscriptions[numberOfYears - 1].getYear();
        int startOfPeriod = requestedStart - startingYear;
        int yearsOfPeriod = requestedEndYear - requestedStart +1;
        String message;
        for (int i = 0; i < numberOfYears; i++)
            subscriptionsForTheVaildSubPeriod += subscriptions[i].getSubscriptions();
        if ((requestedEndYear - requestedStart < 0)||(requestedStart > endingYear)||(requestedEndYear < startingYear)||(requestedStart < startingYear && requestedEndYear > endingYear)) {
            message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal subscriptions between %d - %d = %.2f\n",
                    requestedStart, requestedEndYear, name, startingYear, endingYear, startingYear, endingYear ,subscriptionsForTheVaildSubPeriod);
            throw new IllegalArgumentException(message);
        }else {
            if ((requestedStart >= startingYear) && (requestedEndYear <= endingYear)) {
                for (int i = 0; i < yearsOfPeriod; i++) {
                    subscriptionsForPeriod += subscriptions[startOfPeriod].getSubscriptions();
                    startOfPeriod++;
                }
                return subscriptionsForPeriod;
            } else {
                message = "";
                if ((requestedStart >= startingYear) && (requestedEndYear > endingYear)) {
                    for (int i = 0; i <= endingYear - requestedStart; i++) {
                        subscriptionsForPeriod += subscriptions[startOfPeriod].getSubscriptions();
                        startOfPeriod++;
                    }
                    message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal subscriptions between %d - %d = %.2f\n",
                            requestedStart, requestedEndYear, name, startingYear, endingYear, requestedStart, endingYear, subscriptionsForPeriod);
                }
                if ((requestedStart < startingYear) && (requestedEndYear <= endingYear)) {
                    for (int i = 0; i <= requestedEndYear - startingYear; i++) {
                        subscriptionsForPeriod += subscriptions[i].getSubscriptions();
                        startOfPeriod++;
                    }
                    message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal subscriptions between %d - %d = %.2f\n",
                            requestedStart, requestedEndYear, name, startingYear, endingYear, startingYear, requestedEndYear, subscriptionsForPeriod);
                }
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Returns a representation of the country in type String.
     * @return the country name and data of each year.
     */
    public String toString(){
        String year = "";
        for(int i = 0; i< numberOfYears; i++){
            year += String.format(" %16s", subscriptions[i].getYear());
        }
        String partialList = "";
        for(int i = 0; i < numberOfYears; i++) {
            partialList += String.format(" %16s", subscriptions[i].toString());
        }
        return  "\n" + String.format("  %20s","Country,Year") + year + "\n" + String.format("%22s",name) + partialList ;
    }

}