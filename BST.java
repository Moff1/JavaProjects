public class BST {
    
    public static class Node {

        private int key;
        private Node parent;
        private Node leftChild;
        private Node rightChild;
        
        public Node() {
            key = 0;
            parent = null;
            leftChild = null;
            rightChild = null;
        }            

        public Node(int key) {
            this.key = key;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }
        
        public Node(int key, Node parent, Node leftChild, Node rightChild) {
            this.key = key;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
        
    } // Node Class
    
    private Node root;
    private int counter;
    
    public BST() {
        root = null;
        counter = 0;
    }
    
    public int size () {
        return counter;
    }
    
    public void insert (int key) {
        Node temp = search(this.root, key);
        
       if (temp != null) {
            System.out.println("This element is already present in our tree.");
        } else {
            root = recursiveInsert(root, key);
        }
        
    }
    
    public Node recursiveInsert (Node root, int key) {
        
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.getKey()) {
            root.setLeftChild(recursiveInsert(root.getLeftChild(), key));
        } else if ( key > root.getKey()) {
            root.setRightChild(recursiveInsert(root.getRightChild(), key));
        }
        
        return root;
        
    }
    
    //Helper Function
    public Node search(Node root, int key) {
        // Base Case
        if (root==null || root.getKey()==key)
            return root;
     
        if (root.getKey() < key)
           return search(root.getLeftChild(), key);
        else {
           return search(root.getRightChild(), key);
        }
        
    }
    
    public void inorder() {
        recursiveInorder(root);
    }
    
    public void recursiveInorder(Node root) {
        if (root != null) {
            recursiveInorder(root.getLeftChild());
            System.out.println(root.getKey());
            recursiveInorder(root.getRightChild());
        }
    }
    
    

}
