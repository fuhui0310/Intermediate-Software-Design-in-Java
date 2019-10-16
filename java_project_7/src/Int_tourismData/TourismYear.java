package Int_tourismData;

/**
 * One object contains the specified year and its subscription data.
 */
public class TourismYear {
    private int year;
    private double tourists;

    /**
     * Constructs a SubscriptionYear object with the specified year label and subscription data.
     * @param newYear                   the year for a subscription data.
     * @param newTourists                  the number of tourists for a specific year.
     */
    public TourismYear(int newYear, double newTourists){
        year = newYear;
        tourists = newTourists;
    }

    /**
     * Sets the value for year to "newYear".
     * @param newYear                   the input value for year.
     */
    public void setYear(int newYear){
        year = newYear;
    }

    /**
     * Sets the value for tourists to "newTourists".
     * @param newTourists                  the input value for tourists.
     */
    public void setTourists(double newTourists){
        tourists = newTourists;
    }

    /**
     * Returns the value of year.
     * @return the year for a tourism data.
     */
    public int getYear(){
        return year;
    }

    /**
     * Returns the value of tourists.
     * @return the number of tourists for a specific year.
     */
    public double getTourists(){
        return tourists;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TourismYear){
            TourismYear other = (TourismYear)obj;
            if (other.year == this.year && other.tourists == this.tourists) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the only the number of tourists.
     * @return  the number of tourists for a specific year.
     */
    public String toString(){
        return String.format("%.2f",tourists);
    }
}