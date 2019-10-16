package cellularData;

/**
 * Holds data for one node in a data structure.
 */
public class CountryNode {
	private Country country;
    private CountryNode next;

    /**
     * Constructs an object to hold a Country object.
     * and point to null as the next node.
     * @param country
     */
    public CountryNode(Country country) {
        this.country = country;
        this.next = null;
    }

    /**
     * Constructs an object to hold a Country object.
     * and point to another Country as the next node.
     * @param country			The data portion of this node.
     * @param anotherCountry		The node following this node.
     */
    public CountryNode(Country country, CountryNode anotherCountry) {
        this.country = country;
        this.next = anotherCountry;
    }

    /**
     * Checks if the other node has the same name of the country as this one.
     * @param other
     */
    public boolean equals(Object other) {
        if (other instanceof CountryNode)
        {
            CountryNode current = (CountryNode)other;
            if (current.country.getName().equalsIgnoreCase(this.country.getName()))
                return true;
        }
        return false;
    }

    /**
     * Mutator method returns the data portion of the node.
     * @return the Country object
     */
    public Country getCountry()
    { 	return this.country; }

    /**
     * Mutator method sets the next node.
     * @param anotherCountry		The node following this node.
     */
    public void setNext(CountryNode anotherCountry)
    {	this.next = anotherCountry; }

    /**
     * Mutator method get the next node.
     * @return the next node
     */
    public CountryNode getNext()
    {	return this.next; }

    /**
     * Returns a representation of the country in type String.
     *@return the country name and data of each year.
     */
    @Override
    public String toString()
    {
        return country.toString();
    }
}
