package cellularData;

import java.util.Iterator;

/**
 * One object  contains the name of the country and the list of subscriptions
 */
public class Country {
    private String name;
    private int maxYear;
    private int minYear;
    LinkedList<SubscriptionYear> subscriptions;

    /**
     * Constructs a Country object with the specified country names, number of years, and list of SubscriptionYear object.
     * @param newName                   name of the country.
     */
    public Country(String newName) {
        name = newName;
        maxYear = 9999;
        minYear = 0;
        subscriptions = new LinkedList<SubscriptionYear>();
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
        return subscriptions.size();
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
        SubscriptionYear current = new SubscriptionYear(yearLabel, CountryData);
        subscriptions.add(current);
        if (subscriptions.size() == 1){
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
        int startOfPeriod = requestedStart - minYear;
        int endOfPeriod = startOfPeriod + requestedEndYear - requestedStart;
        String message;
        Iterator<SubscriptionYear> iterator = subscriptions.iterator();
        while (iterator.hasNext()) {
            subscriptionsForTheVaildSubPeriod += iterator.next().getSubscriptions();
        }
        if ((requestedEndYear - requestedStart < 0) || (requestedStart > maxYear) || (requestedEndYear < minYear) || (requestedStart < minYear && requestedEndYear > maxYear)) {
            message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal subscriptions between %d - %d = %.2f\n",
                    requestedStart, requestedEndYear, name, minYear, maxYear, minYear, maxYear, subscriptionsForTheVaildSubPeriod);
            throw new IllegalArgumentException(message);
        } else {
            iterator = subscriptions.iterator();
            int counter = 0;
            if ((requestedStart >= minYear) && (requestedEndYear <= maxYear)) {
                while (iterator.hasNext()) {
                    double current = iterator.next().getSubscriptions();
                    if (counter >= startOfPeriod && counter <= endOfPeriod) {
                        subscriptionsForPeriod += current;
                    }
                    counter++;
                }
                    return subscriptionsForPeriod;
                } else{
                    message = "";
                    if ((requestedStart >= minYear) && (requestedEndYear > maxYear)) {
                        while (iterator.hasNext()) {
                            double current = iterator.next().getSubscriptions();
                            if (counter >= startOfPeriod) {
                                subscriptionsForPeriod += current;
                            }
                            counter++;
                        }
                        message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal subscriptions between %d - %d = %.2f\n",
                                requestedStart, requestedEndYear, name, minYear, maxYear, requestedStart, maxYear, subscriptionsForPeriod);
                    }
                    if ((requestedStart < minYear) && (requestedEndYear <= maxYear)) {
                        while (iterator.hasNext()) {
                            double current = iterator.next().getSubscriptions();
                            if (counter <= endOfPeriod) {
                                subscriptionsForPeriod += current;
                            }
                            counter++;
                        }
                        message = String.format("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d.\nTotal subscriptions between %d - %d = %.2f\n",
                                requestedStart, requestedEndYear, name, minYear, maxYear, minYear, requestedEndYear, subscriptionsForPeriod);
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
        for(SubscriptionYear subscription: subscriptions){
            year += String.format(" %16s", subscription.getYear());
            partialList += String.format(" %16s", subscription.toString());
        }
        return  "\n" + String.format("  %20s","Country,Year") + year + "\n" + String.format("%22s",name) + partialList ;
    }

}
