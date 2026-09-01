public class LinkedListStringDemo {
    public static void main(String[] args) {
        System.out.println("=== LINKED LIST DEMONSTRATION ===\n");
        testLinkedList();
        
        System.out.println("\n=== GENERIC LINKED LIST ===\n");
        testGenericLinkedList();
        
        System.out.println("\n=== DOUBLY LINKED LIST ===\n");
        testDoublyLinkedList();
        
        System.out.println("\n=== CUSTOM STRING CLASS ===\n");
        testMyString();
        
        System.out.println("\n=== ADVANCED STRING CLASS ===\n");
        testAdvancedString();
        
        System.out.println("\n=== STRING BUFFER IMPLEMENTATION ===\n");
        testMyStringBuffer();
    }
    
    private static void testLinkedList() {
        LinkedList list = new LinkedList();
        
        System.out.println("Adding elements:");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);
        list.display();
        System.out.println("Size: " + list.size());
        
        System.out.println("\nDeleting elements:");
        list.deleteFromBeginning();
        list.display();
        
        list.deleteFromEnd();
        list.display();
        
        list.deleteAtPosition(1);
        list.display();
        
        System.out.println("\nSearching:");
        System.out.println("Contains 20? " + list.search(20));
        System.out.println("Contains 100? " + list.search(100));
        
        System.out.println("\nReversing list:");
        list.reverse();
        list.display();
        
        System.out.println("\nElement at index 1: " + list.get(1));
    }
    
    private static void testGenericLinkedList() {
        GenericLinkedList<String> stringList = new GenericLinkedList<>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.addFirst("Java");
        stringList.add("Programming");
        stringList.display();
        
        System.out.println("Size: " + stringList.size());
        System.out.println("Get index 2: " + stringList.get(2));
        
        stringList.remove("World");
        System.out.println("After removing 'World':");
        stringList.display();
        
        GenericLinkedList<Integer> intList = new GenericLinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.display();
    }
    
    private static void testDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("Adding elements:");
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addAtPosition(2, 1);
        list.displayForward();
        list.displayBackward();
        
        System.out.println("\nRemoving elements:");
        list.removeFirst();
        list.displayForward();
        
        list.removeLast();
        list.displayForward();
        
        System.out.println("Size: " + list.size());
    }
    
    private static void testMyString() {
        MyString str1 = new MyString("Hello World");
        MyString str2 = new MyString("Hello");
        MyString str3 = new MyString("World");
        
        System.out.println("str1: " + str1);
        System.out.println("Length: " + str1.length());
        System.out.println("Char at index 1: " + str1.charAt(1));
        System.out.println("Substring (0, 5): " + str1.substring(0, 5));
        System.out.println("Concatenation: " + str1.concat(str3));
        System.out.println("Index of 'o': " + str1.indexOf('o'));
        System.out.println("Index of 'World': " + str1.indexOf(str3));
        System.out.println("Equals 'Hello'? " + str1.substring(0, 5).equals(str2));
        System.out.println("Compare to 'Hello': " + str2.compareTo(new MyString("Hello")));
        System.out.println("Uppercase: " + str1.toUpperCase());
        System.out.println("Lowercase: " + str1.toLowerCase());
        
        MyString str4 = new MyString("  Trim me  ");
        System.out.println("Trim: '" + str4.trim() + "'");
        
        MyString str5 = new MyString("apple,banana,orange,grape");
        MyString[] fruits = str5.split(',');
        System.out.print("Split: ");
        for (MyString fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        System.out.println("Replace 'o' with 'a': " + str1.replace('o', 'a'));
        System.out.println("Starts with 'Hello': " + str1.startsWith(new MyString("Hello")));
        System.out.println("Ends with 'World': " + str1.endsWith(new MyString("World")));
    }
    
    private static void testAdvancedString() {
        AdvancedString str1 = new AdvancedString("racecar");
        AdvancedString str2 = new AdvancedString("hello");
        AdvancedString str3 = new AdvancedString("listen");
        AdvancedString str4 = new AdvancedString("silent");
        
        System.out.println("str1: " + str1);
        System.out.println("Reverse: " + str1.reverse());
        System.out.println("Is palindrome? " + str1.isPalindrome());
        System.out.println("Is 'hello' palindrome? " + str2.isPalindrome());
        
        System.out.println("\nOccurrences of 'l' in 'hello': " + str2.countOccurrences('l'));
        System.out.println("Occurrences of 'll' in 'hello': " + str2.countOccurrences(new AdvancedString("ll")));
        
        AdvancedString str5 = new AdvancedString("programming");
        System.out.println("\nRemove duplicates from 'programming': " + str5.removeDuplicates());
        
        System.out.println("Is 'listen' anagram of 'silent'? " + str3.isAnagram(str4));
        System.out.println("First non-repeating in 'programming': " + str5.firstNonRepeating());
        
        System.out.println("\nAll substrings of 'abc':");
        AdvancedString str6 = new AdvancedString("abc");
        AdvancedString[] substrings = str6.getAllSubstrings();
        for (AdvancedString s : substrings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    private static void testMyStringBuffer() {
        MyStringBuffer sb = new MyStringBuffer("Hello");
        System.out.println("Initial: " + sb);
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
        
        sb.append(" World");
        System.out.println("After append: " + sb);
        
        sb.insert(5, " Beautiful");
        System.out.println("After insert: " + sb);
        
        sb.delete(6, 16);
        System.out.println("After delete: " + sb);
        
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);
        
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: " + sb);
        
        System.out.println("Substring (2, 4): " + sb.substring(2, 4));
    }
}