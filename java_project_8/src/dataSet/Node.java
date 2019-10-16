package dataSet;

/**
 * Holds data for one node in a data structure.
 */
public class Node<T> {
    private T data;
    private Node next;

    /**
     * Constructs an object to hold a object.
     * and point to null as the next node.
     * @param data
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Constructs an object to hold a object.
     * and point to another Country as the next node.
     * @param data			The data portion of this node.
     * @param anotherNode		The node following this node.
     */
    public Node(T data, Node<T> anotherNode) {
        this.data = data;
        this.next = anotherNode;
    }

    /**
     * Mutator method sets the data.
     * @param anotherData		The node replacing this node.
     */
    public void setData(T anotherData){
        this.data = anotherData;
    }

    /**
     * Mutator method sets the next node.
     * @param anotherNode		The node following this node.
     */
    public void setNext(Node<T> anotherNode) {
        this.next = anotherNode;
    }

    /**
     * Mutator method returns the data portion of the node.
     * @return the data object
     */
    public T getData() {
        return this.data;
    }

    /**
     * Mutator method get the next node.
     * @return the next node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Returns a representation of the country in type String.
     *@return the country name and data of each year.
     */
    @Override
    public String toString()
    {
        String result = "";
        result += this.data;
        return result;
    }
}