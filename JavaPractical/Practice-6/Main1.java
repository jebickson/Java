// Generic Node
class GenericNode<T> {
    T data;
    GenericNode<T> next;
    
    public GenericNode(T data) {
        this.data = data;
        this.next = null;
    }
}

// Generic Linked List
class GenericLinkedList<T> {
    private GenericNode<T> head;
    private int size;
    
    public GenericLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public void add(T data) {
        GenericNode<T> newNode = new GenericNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            GenericNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    public void addFirst(T data) {
        GenericNode<T> newNode = new GenericNode<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public boolean remove(T data) {
        if (head == null) return false;
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        
        GenericNode<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        GenericNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        GenericNode<T> current = head;
        System.out.print("Generic LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}