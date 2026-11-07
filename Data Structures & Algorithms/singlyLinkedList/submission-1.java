class LinkedList {
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        
        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }

        size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            size--;


            if (size == 0) {
                tail = null;
            }

            return true;
        }

        Node previous = head;

        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }

        Node nodeToRemove = previous.next;
        previous.next = nodeToRemove.next;

        if (nodeToRemove == tail) {
            tail = previous;
        }

        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head; // skip the dummy node
        while (curr != null) {
        values.add(curr.val);
        curr = curr.next;
        }
        return values;
    }
}