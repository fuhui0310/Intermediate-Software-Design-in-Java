package cellularData;

/**
 * One object holds linked list of CountryNode objects, that can store as many objects as the user might want to add to it.
 */
public class CountryList {
    private CountryNode head;
    private int size = 0;

    /**
     * Constructs an empty CountryList object.
     */
    public CountryList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructs a deep copy of the current list.
     */
    public CountryList(CountryList originalList) {
        CountryNode walker = originalList.head;
        while(walker != null){
            CountryNode current = new CountryNode(walker);
            add(current.getCountry());
            walker = walker.getNext();
        }
    }

    /**
     * Checks if head is pointing to any node.
     */
    public boolean isEmpty() {
        if (this.head == null)
            return true;
        return false;
    }

    /**
     * Mutator method get the head.
     * @return the head
     */
    public CountryNode getHead() {
        return this.head;
    }


    /**
     * Add a node to the end of the list.
     *
     * @param countryToAdd a new Country object to be added to our list.
     */
    public void add(Country countryToAdd) {
        CountryNode current = new CountryNode(countryToAdd);
        if (this.isEmpty()) {
            head = current;
            this.size++;
        } else {
            CountryNode walker = head;
            while (walker.getNext() != null) {
                walker = walker.getNext();
            }
            walker.setNext(current);
            this.size++;
        }
    }

    /**
     * Insert the country at the location specified by index.
     *
     * @param countryToAdd a new Country object to be added to our list.
     * @param index        adds the country on this index of list.
     * @throws IndexOutOfBoundsException
     */
    public void insertAtIndex(Country countryToAdd, int index) throws IndexOutOfBoundsException {
        CountryNode current = new CountryNode(countryToAdd);
        if (this.isEmpty()) {
            head = current;
            System.err.println("Warning: The list is empty!");
            System.out.printf("Adding country with name %s to the head of the list.\n", countryToAdd.getName());
            this.size++;
        } else {
            if (index < 0) {
                String message = "Warning: This index is invaild.";
                throw new IndexOutOfBoundsException(message);
            } else {
                if (index > size - 1) {
                    CountryNode walker = head;
                    while (walker.getNext() != null) {
                        walker = walker.getNext();
                    }
                    walker.setNext(current);
                    this.size++;
                } else {
                    CountryNode beforeTheIndex = head;
                    if (beforeTheIndex.getNext() == null) {
                        CountryNode saved = head;
                        head = current;
                        head.setNext(saved);
                    }
                    CountryNode afterTheIndex = beforeTheIndex.getNext();
                    if (index == 0) {
                        current.setNext(head);
                        head = current;
                        this.size++;
                    } else {
                        if (index == size - 1) {
                            CountryNode walker = head;
                            while (walker.getNext() != null) {
                                walker = walker.getNext();
                            }
                            walker.setNext(current);
                            this.size++;
                        } else {
                            for (int i = 1; i < index; i++) {
                                beforeTheIndex = afterTheIndex;
                                afterTheIndex = beforeTheIndex.getNext();
                            }
                            current.setNext(afterTheIndex);
                            beforeTheIndex.setNext(current);
                            this.size++;
                        }
                    }
                }
            }
        }
    }

    /**
     * Takes a int as parameter. If the index is valid, returns a Country object.
     * Otherwise, if the requested index < 0 or index >= the size of the list, then throw an IndexOutOfBoundsException.
     *
     * @param index the index of the list.
     * @return a Country object. if the index is valid.
     * @throws IndexOutOfBoundsException
     */
    public Country getIndex(int index) throws IndexOutOfBoundsException {
        CountryNode walker = head;
        int i = 0;
        if (index < 0 || index > size - 1) {
            String message = "Warning: This index is invaild.";
            throw new IndexOutOfBoundsException(message);
        } else {
            while (walker != null) {
                if (i == index) {
                    return walker.getCountry();
                } else {
                    walker = walker.getNext();
                    i++;
                }
            }
            return null;
        }
    }

    /**
     * Returns the number of nodes in the list.
     *
     * @return size
     */
    public int size() {
        return this.size;
    }

    /**
     * Takes a Country object as parameter and checks if the name of the country can be found in the list.
     *
     * @param tmpCountry a Country object
     * @return the result of searching.
     */
    public Country contains(Country tmpCountry) {
        CountryNode tmpCountryNode = new CountryNode(tmpCountry);
        CountryNode walker = head;
        Country result = null;
        while (walker != null) {
            if (walker.equals(tmpCountryNode)) {
                result = walker.getCountry();
            }
            walker = walker.getNext();
        }
        return result;
    }

    /**
     *  Replaces a CountryNode at a specified index in the list and takes two arguments:
     * @param index index that user want to replace.
     * @param countryToAdd  country will replace to the index.
     */
    public void replaceAtIndex(int index, Country countryToAdd) {
        CountryNode current = new CountryNode(countryToAdd);
        if (this.isEmpty()) {
            head = current;
            System.err.println("Warning: The list is empty!");
            System.out.printf("Replacing country with name %s to the head of the list.\n", countryToAdd.getName());
            this.size++;
        } else {
            if (index < 0) {
                String message = "Warning: This index is invaild.";
                throw new IndexOutOfBoundsException(message);
            } else {
                if (index > size - 1) {
                    String message = "Warning: This index is invaild.";
                    throw new IndexOutOfBoundsException(message);
                } else {
                    CountryNode selectedIndex = head;
                    CountryNode afterTheIndex = selectedIndex.getNext();
                    if (index == 0) {
                        head = current;
                        head.setNext(afterTheIndex);
                    } else {
                        if (index == size - 1) {
                            CountryNode walker = head;
                            while (walker.getNext() != null) {
                                walker = walker.getNext();
                            }
                            walker.setCountry(current.getCountry());
                        } else {
                            for (int i = 0; i < index; i++) {
                                selectedIndex = afterTheIndex;
                                afterTheIndex = selectedIndex.getNext();
                            }
                            selectedIndex.setCountry(current.getCountry());
                            selectedIndex.setNext(afterTheIndex);
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns a representation of the country in type String.
     * @return the list of countries.
     */
    @Override
    public String toString() {
        String toString = "";
        CountryNode walker = head;
        while (walker != null) {
            toString += walker.getCountry() + "\n";
            walker = walker.getNext();
        }
        return toString;
    }

}