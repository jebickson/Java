class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;
    
    public DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void addAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        
        if (position == 0) {
            addFirst(data);
            return;
        }
        
        if (position == size) {
            addLast(data);
            return;
        }
        
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }
    
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        DoublyNode current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        DoublyNode current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    
    public int size() {
        return size;
    }
}