package cellularData;

import java.util.Iterator;

/**
 * One object holds linked list of Node objects, that can store as many objects as the user might want to add to it.
 */
public class LinkedList<T> implements Iterable<T> {
    private Node head;
    private int size = 0;

    /**
     * Nested class, which iterates over the elements of the outer class.
     */
    private class ListIterator implements Iterator<T> {
        private Node current;
        public ListIterator() {
            current = head;
        }

        public boolean hasNext()
        {
            if (current == null)
                return false;
            return true;
        }

        public T next() {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            T data = (T) current.getData();
            current = current.getNext();
            return data;
        }
    }

    /**
     * Constructs an empty LinkedList object.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
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
    public Node<T> getHead() {
        return this.head;
    }


    /**
     * Add a node to the end of the list.
     *
     * @param newData a new Country object to be added to our list.
     */
    public void add(T newData) {
        Node<T> current = new Node<T>(newData);
        if (this.isEmpty()) {
            head = current;
            this.size++;
        } else {
            Node<T> walker = head;
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
     * @param newData a new Country object to be added to our list.
     * @param index        adds the country on this index of list.
     * @throws IndexOutOfBoundsException
     */
    public void insertAtIndex(T newData, int index) throws IndexOutOfBoundsException {
        Node<T> current = new Node<T>(newData);
        if (this.isEmpty()) {
            head = current;
            System.err.println("Warning: The list is empty!");
            System.out.println("Replacing Object to the head of the list.");
            this.size++;
        } else {
            if (index < 0) {
                String message = "Warning: This index is invaild.";
                throw new IndexOutOfBoundsException(message);
            } else {
                if (index > size - 1) {
                    Node<T> walker = head;
                    while (walker.getNext() != null) {
                        walker = walker.getNext();
                    }
                    walker.setNext(current);
                    this.size++;
                } else {
                    Node<T> beforeTheIndex = head;
                    if (beforeTheIndex.getNext() == null) {
                        Node saved = head;
                        head = current;
                        head.setNext(saved);
                    }
                    Node<T> afterTheIndex = beforeTheIndex.getNext();
                    if (index == 0) {
                        current.setNext(head);
                        head = current;
                        this.size++;
                    } else {
                        if (index == size - 1) {
                            Node walker = head;
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
     * Takes a int as parameter. If the index is valid, returns a  object.
     * Otherwise, if the requested index < 0 or index >= the size of the list, then throw an IndexOutOfBoundsException.
     *
     * @param index the index of the list.
     * @return a Country object. if the index is valid.
     * @throws IndexOutOfBoundsException
     */
    public T getIndex(int index) throws IndexOutOfBoundsException {
        Node<T> walker = head;
        int i = 0;
        if (index < 0 || index > size - 1) {
            String message = "Warning: This index is invaild.";
            throw new IndexOutOfBoundsException(message);
        } else {
            while (walker != null) {
                if (i == index) {
                    return walker.getData();
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
     * Takes a  object as parameter and checks if the name of the country can be found in the list.
     *
     * @param tmpData a Country object
     * @return the result of searching.
     */
    public T contains(T tmpData) {
        if(this.isEmpty()) {
            return null;
        }
        else {
            Node<T> current = head;
            while (current != null) {
                if (current.getData().equals(tmpData)) {
                    return current.getData();
                }
                current = current.getNext();
            }
            return null;
        }
    }

    /**
     *  Replaces an Node at a specified index in the list and takes two arguments:
     * @param index index that user want to replace.
     * @param newData  country will replace to the index.
     */
    public void replaceAtIndex(int index, T newData) {
        Node<T> current = new Node<T>(newData);
        if (this.isEmpty()) {
            head = current;
            System.err.println("Warning: The list is empty!");
            System.out.println("Replacing Object to the head of the list.");
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
                    Node selectedIndex = head;
                    Node afterTheIndex = selectedIndex.getNext();
                    if (index == 0) {
                        head = current;
                        head.setNext(afterTheIndex);
                    } else {
                        if (index == size - 1) {
                            Node<T> walker = head;
                            while (walker.getNext() != null) {
                                walker = walker.getNext();
                            }
                            walker.setData(current.getData());
                        } else {
                            for (int i = 0; i < index; i++) {
                                selectedIndex = afterTheIndex;
                                afterTheIndex = selectedIndex.getNext();
                            }
                            selectedIndex.setData(current.getData());
                            selectedIndex.setNext(afterTheIndex);
                        }
                    }
                }
            }
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Returns a representation  in type String.
     * @return the list of countries.
     */
    @Override
    public String toString() {
        String toString = "";
        Node<T> walker = head;
        while (walker != null) {
            toString += walker.getData() + "\n";
            walker = walker.getNext();
        }
        return toString;
    }


}