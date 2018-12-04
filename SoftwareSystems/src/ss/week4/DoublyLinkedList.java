package ss.week4;

public class DoublyLinkedList<E> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, E element) {
        Node newNode = new Node(element);
        Node prevNode = getNode(index - 1);
        Node nextNode = prevNode.next;
        
        prevNode.next = newNode;
        newNode.previous = prevNode;
        newNode.next = nextNode;
        nextNode.previous = newNode;
        
        size++;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
    	Node oldNode = getNode(index);
    	Node prevNode = oldNode.previous;
    	Node nextNode = oldNode.next;
    	
    	if (prevNode != null) {
    		prevNode.next = nextNode;
    	}
    	if (nextNode != null) {
    		nextNode.previous = prevNode;
    	}
    	
    	size--;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public E get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private E element;
        public Node next;
        public Node previous;

        public E getElement() {
            return element;
        }
    }
}
