import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class ThreadSafeBST {
    private TreeNode root;
    private final ReentrantReadWriteLock treeLock = new ReentrantReadWriteLock();
    
    // Insert operation with fine-grained locking
    public void insert(int data) {
        treeLock.writeLock().lock();
        try {
            if (root == null) {
                root = new TreeNode(data);
                System.out.println(Thread.currentThread().getName() + " inserted " + data + " as root");
                return;
            }
        } finally {
            treeLock.writeLock().unlock();
        }
        
        insertRecursive(root, data);
    }
    
    private void insertRecursive(TreeNode node, int data) {
        node.lock.writeLock().lock();
        try {
            if (data < node.data) {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                    System.out.println(Thread.currentThread().getName() + " inserted " + data + " to left of " + node.data);
                } else {
                    node.left.lock.readLock().lock();
                    try {
                        insertRecursive(node.left, data);
                    } finally {
                        node.left.lock.readLock().unlock();
                    }
                }
            } else if (data > node.data) {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                    System.out.println(Thread.currentThread().getName() + " inserted " + data + " to right of " + node.data);
                } else {
                    node.right.lock.readLock().lock();
                    try {
                        insertRecursive(node.right, data);
                    } finally {
                        node.right.lock.readLock().unlock();
                    }
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " duplicate value " + data + " - not inserted");
            }
        } finally {
            node.lock.writeLock().unlock();
        }
    }
    
    // Search operation with read locks
    public boolean search(int data) {
        treeLock.readLock().lock();
        try {
            return searchRecursive(root, data);
        } finally {
            treeLock.readLock().unlock();
        }
    }
    
    private boolean searchRecursive(TreeNode node, int data) {
        if (node == null) return false;
        
        node.lock.readLock().lock();
        try {
            if (data == node.data) {
                System.out.println(Thread.currentThread().getName() + " found " + data);
                return true;
            } else if (data < node.data) {
                return searchRecursive(node.left, data);
            } else {
                return searchRecursive(node.right, data);
            }
        } finally {
            node.lock.readLock().unlock();
        }
    }
    
    // Delete operation
    public boolean delete(int data) {
        treeLock.writeLock().lock();
        try {
            if (root == null) return false;
            
            // Handle root deletion specially
            if (root.data == data) {
                root = deleteNode(root);
                System.out.println(Thread.currentThread().getName() + " deleted root " + data);
                return true;
            }
            return deleteRecursive(root, data);
        } finally {
            treeLock.writeLock().unlock();
        }
    }
    
    private boolean deleteRecursive(TreeNode parent, int data) {
        parent.lock.writeLock().lock();
        try {
            TreeNode child = null;
            boolean isLeft = false;
            
            if (parent.left != null && parent.left.data == data) {
                child = parent.left;
                isLeft = true;
            } else if (parent.right != null && parent.right.data == data) {
                child = parent.right;
                isLeft = false;
            } else if (data < parent.data && parent.left != null) {
                parent.left.lock.readLock().lock();
                try {
                    return deleteRecursive(parent.left, data);
                } finally {
                    parent.left.lock.readLock().unlock();
                }
            } else if (data > parent.data && parent.right != null) {
                parent.right.lock.readLock().lock();
                try {
                    return deleteRecursive(parent.right, data);
                } finally {
                    parent.right.lock.readLock().unlock();
                }
            } else {
                return false;
            }
            
            if (child != null) {
                child.lock.writeLock().lock();
                try {
                    TreeNode newNode = deleteNode(child);
                    if (isLeft) {
                        parent.left = newNode;
                    } else {
                        parent.right = newNode;
                    }
                    System.out.println(Thread.currentThread().getName() + " deleted " + data);
                    return true;
                } finally {
                    child.lock.writeLock().unlock();
                }
            }
            return false;
        } finally {
            parent.lock.writeLock().unlock();
        }
    }
    
    private TreeNode deleteNode(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        
        // Node with two children - find inorder successor
        TreeNode successor = findMin(node.right);
        successor.right = deleteMin(node.right);
        successor.left = node.left;
        return successor;
    }
    
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    
    // In-order traversal
    public void inorderTraversal() {
        treeLock.readLock().lock();
        try {
            System.out.print("In-order traversal: ");
            inorderRecursive(root);
            System.out.println();
        } finally {
            treeLock.readLock().unlock();
        }
    }
    
    private void inorderRecursive(TreeNode node) {
        if (node == null) return;
        
        node.lock.readLock().lock();
        try {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        } finally {
            node.lock.readLock().unlock();
        }
    }
    
    // Get size of tree
    public int size() {
        treeLock.readLock().lock();
        try {
            return sizeRecursive(root);
        } finally {
            treeLock.readLock().unlock();
        }
    }
    
    private int sizeRecursive(TreeNode node) {
        if (node == null) return 0;
        
        node.lock.readLock().lock();
        try {
            return 1 + sizeRecursive(node.left) + sizeRecursive(node.right);
        } finally {
            node.lock.readLock().unlock();
        }
    }
    
    // Get height of tree
    public int height() {
        treeLock.readLock().lock();
        try {
            return heightRecursive(root);
        } finally {
            treeLock.readLock().unlock();
        }
    }
    
    private int heightRecursive(TreeNode node) {
        if (node == null) return 0;
        
        node.lock.readLock().lock();
        try {
            return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
        } finally {
            node.lock.readLock().unlock();
        }
    }
}

// Producer thread for inserting nodes
class InsertProducer implements Runnable {
    private ThreadSafeBST bst;
    private int[] values;
    
    public InsertProducer(ThreadSafeBST bst, int[] values) {
        this.bst = bst;
        this.values = values;
    }
    
    @Override
    public void run() {
        for (int value : values) {
            bst.insert(value);
            try {
                Thread.sleep(50); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer thread for searching nodes
class SearchConsumer implements Runnable {
    private ThreadSafeBST bst;
    private int[] values;
    
    public SearchConsumer(ThreadSafeBST bst, int[] values) {
        this.bst = bst;
        this.values = values;
    }
    
    @Override
    public void run() {
        for (int value : values) {
            boolean found = bst.search(value);
            System.out.println(Thread.currentThread().getName() + " search for " + value + ": " + (found ? "FOUND" : "NOT FOUND"));
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Delete thread
class DeleteThread implements Runnable {
    private ThreadSafeBST bst;
    private int[] values;
    
    public DeleteThread(ThreadSafeBST bst, int[] values) {
        this.bst = bst;
        this.values = values;
    }
    
    @Override
    public void run() {
        for (int value : values) {
            boolean deleted = bst.delete(value);
            System.out.println(Thread.currentThread().getName() + " delete " + value + ": " + (deleted ? "SUCCESS" : "FAILED"));
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class MultithreadedBST {
    public static void main(String[] args) {
        ThreadSafeBST bst = new ThreadSafeBST();
        
        // Test data
        int[] insertData = {50, 30, 70, 20, 40, 60, 80, 25, 35, 45, 55, 65, 75, 85};
        int[] searchData = {20, 40, 60, 80, 90, 100};
        int[] deleteData = {30, 70, 25, 65};
        
        // Create threads
        Thread insertThread1 = new Thread(new InsertProducer(bst, insertData), "InsertThread-1");
        Thread insertThread2 = new Thread(new InsertProducer(bst, new int[]{15, 90, 10, 95}), "InsertThread-2");
        Thread searchThread = new Thread(new SearchConsumer(bst, searchData), "SearchThread");
        Thread deleteThread = new Thread(new DeleteThread(bst, deleteData), "DeleteThread");
        Thread statsThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println("\n=== TREE STATISTICS ===");
                    System.out.println("Size: " + bst.size());
                    System.out.println("Height: " + bst.height());
                    bst.inorderTraversal();
                    System.out.println("=====================\n");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "StatsThread");
        
        // Start all threads
        System.out.println("Starting all threads...\n");
        long startTime = System.currentTimeMillis();
        
        insertThread1.start();
        insertThread2.start();
        searchThread.start();
        deleteThread.start();
        statsThread.start();
        
        // Wait for all threads to complete
        try {
            insertThread1.join();
            insertThread2.join();
            searchThread.join();
            deleteThread.join();
            statsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("\n=== FINAL TREE STATE ===");
        bst.inorderTraversal();
        System.out.println("Final Size: " + bst.size());
        System.out.println("Final Height: " + bst.height());
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}