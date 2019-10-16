package cellularData;

/**
 * One object contains the specified year and its subscription data.
 */
public class SubscriptionYear {
    private int year;
    private double subscriptions;

    /**
     * Constructs a SubscriptionYear object with the specified year label and subscription data.
     * @param newYear                   the year for a subscription data.
     * @param newSubscriptions                  the number of subscriptions for a specific year.
     */
    public SubscriptionYear(int newYear, double newSubscriptions){
        year = newYear;
        subscriptions = newSubscriptions;
    }

    /**
     * Sets the value for year to "newYear".
     * @param newYear                   the input value for year.
     */
    public void setYear(int newYear){
        year = newYear;
    }

    /**
     * Sets the value for subscriptions to "newSubscriptions".
     * @param newSubscriptions                  the input value for subscriptions.
     */
    public void setSubscriptions(double newSubscriptions){
        subscriptions = newSubscriptions;
    }

    /**
     * Returns the value of year.
     * @return the year for a subscription data.
     */
    public int getYear(){
        return year;
    }

    /**
     * Returns the value of subscriptions.
     * @return the number of subscriptions for a specific year.
     */
    public double getSubscriptions(){
        return subscriptions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SubscriptionYear){
            SubscriptionYear other = (SubscriptionYear)obj;
            if (other.year == this.year && other.subscriptions == this.subscriptions) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the only the number of subscriptions.
     * @return  the number of subscriptions for a specific year.
     */
    public String toString(){
        return String.format("%.2f",subscriptions);
    }
}
