package dataSet;

/**
 * One object contains the specified year and its  data.
 */
public class DataPerYear {
    private int year;
    private double Data;

    /**
     * Constructs a DataPerYear object with the specified year label and  data.
     * @param newYear                   the year for a subscription data.
     * @param newData                  the number of subscriptions for a specific year.
     */
    public DataPerYear(int newYear, double newData){
        year = newYear;
        Data = newData;
    }

    /**
     * Sets the value for year to "newYear".
     * @param newYear                   the input value for year.
     */
    public void setYear(int newYear){
        year = newYear;
    }

    /**
     * Sets the value for subscriptions to "newData".
     * @param newData                  the input value for data.
     */
    public void setData(double newData){
        Data = newData;
    }

    /**
     * Returns the value of year.
     * @return the year for a  data.
     */
    public int getYear(){
        return year;
    }

    /**
     * Returns the value of data.
     * @return the number of data for a specific year.
     */
    public double getData(){
        return Data;
    }

    /**
     * Compares two object. If they have a same data, return true.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DataPerYear){
            DataPerYear other = (DataPerYear)obj;
            if (other.year == this.year && other.Data == this.Data) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the only the number of data.
     * @return  the number of data for a specific year.
     */
    public String toString(){
        return String.format("%.2f",Data);
    }
}