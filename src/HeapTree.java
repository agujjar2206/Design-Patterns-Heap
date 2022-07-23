import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
* <h1>Min Heap without utilizing Array</h1>
* Implementing Min Heap using Binary Tree without Array.
* Maintaining Height for each node which is updated every time a new node is inserted (only for ancestor)
* <h2>Time Complexity for Insert Node : O(log n) </h2>
* <h2>Space Complexity for Insert Node : O(n) </h2>
* 
* <h2>Time Complexity for Post Order Traversal : O(log n) </h2>
* <h2>Time Complexity for Pre Order Traversal (only Odd Number) : O(log n) </h2>
* 
* @author  Himanshi Shukla
* @version 1.0
* @since   2021-09-17
*/
public class HeapTree extends AbstractCollection<Integer> implements Iterable<Integer> {
	private HeapNode root;
	

	private int totalNodes;
	private HeapType heapType;
	
	public HeapTree(HeapType heapType) {
		super();
		this.root = new NullNode();
		this.heapType = heapType;
		this.totalNodes = 0;
	}
	
	public int getTotalNodes() {
		return totalNodes;
	}

	private void setTotalNodes(int totalNodes) {
		this.totalNodes = totalNodes;
	}
	
	public HeapNode getRoot() {
		return root;
	}

	public void setRoot(HeapNode root) {
		this.root = root;
	}

	/**
	 * @param currentNode : Node to be updated with Height 
	 */
	private void updateParentHeight(HeapNode currentNode) {
		// Only called for Node and its ancestor, NOT for all nodes.
        if (currentNode == null) {
            return;
        }

        // Increment the height of current Node by 1, considering the max height of Left or Right Subtree
//        currentNode.height = Math.max(currentNode.left != null ? currentNode.left.height : 0, currentNode.right != null ? currentNode.right.height : 0) + 1;
        int newHeight = Math.max(currentNode.getLeft() != null ? currentNode.getLeft().getHeight() : 0, currentNode.getRight() != null ? currentNode.getRight().getHeight() : 0) + 1;
        currentNode.setHeight(newHeight);
        
        this.updateParentHeight(currentNode.getParent());
    }
	
	// This method is only required while creating MinHeap (figure 1) and won't be used for actual insertion
	private int updateHeightOfCurrentNode(HeapNode currentNode) {
         if (currentNode==null) {
             return 0;
         }

         int newHeight = Math.max(updateHeightOfCurrentNode(currentNode.getLeft()), updateHeightOfCurrentNode(currentNode.getRight())) + 1;

         currentNode.setHeight(newHeight);
         return currentNode.getHeight();
     }
	
	// This method is only required while creating MinHeap (figure 1) and won't be used for actual insertion
	public void updateHeightOfAllNodes() {
        if (this.root.isNull()) {
            return;
        }

        updateHeightOfCurrentNode(this.root);
    }
	
	
	private void addHelper(HeapNode currentNode, int valueToBeInserted){
		if (
				(heapType==HeapType.MIN_HEAP && currentNode.getVal() > valueToBeInserted) || 
				(heapType==HeapType.MAX_HEAP && currentNode.getVal() < valueToBeInserted)) {
            int tempSwapVar = valueToBeInserted;
            valueToBeInserted = currentNode.getVal();
            currentNode.setVal(tempSwapVar);
        }
       
        if (currentNode.getLeft()==null) {
        	// Checking left side at Leaf level and Inserting
            HeapNode newNode = new HeapNode(valueToBeInserted, currentNode); 
            currentNode.setLeft(newNode);
            this.updateParentHeight(newNode.getParent());
        } else if (currentNode.getRight() == null) {
        	 // Checking left side at Leaf level and Inserting
            HeapNode newNode = new HeapNode(valueToBeInserted, currentNode);
            currentNode.setRight(newNode);
            this.updateParentHeight(newNode.getParent());
        } else {
        	// Traversal until reached Leaf node for inserting new Node
            // both present, check lesser height
            if (currentNode.getRight().getHeight() < currentNode.getLeft().getHeight()) { // Left Side takes priority if Height is same
            	addHelper(currentNode.getRight(), valueToBeInserted);
            } else {
            	addHelper(currentNode.getLeft(), valueToBeInserted);
            }
        }
    }
	
	// The actual insert node method for MinHeap
	public boolean add(int val) {
        if (this.root.isNull()) {
            this.root = new HeapNode(val, null);
            return true;
        }
        addHelper(this.root, val);
        setTotalNodes(getTotalNodes()+1);
        return true;
    }

	
	private  void postOrderTraversalHelper(HeapNode currentNode) {
        if (currentNode==null) {
            return;
        }

        postOrderTraversalHelper(currentNode.getLeft());
        postOrderTraversalHelper(currentNode.getRight());
        System.out.println(currentNode.getVal());
    }
	
	public void postOrderTraversal() {
        if (this.root.isNull()) {
            return;
        }
        
        System.out.println("Post Order Traversal : Starts");
        postOrderTraversalHelper(this.root);
        System.out.println("Post Order Traversal : Ends");
    }
	
	private  void inOrderTraversalHelper(HeapNode currentNode) {
        if (currentNode==null) {
            return;
        }

        inOrderTraversalHelper(currentNode.getLeft());
        System.out.println(currentNode.getVal());
        inOrderTraversalHelper(currentNode.getRight());
    }
	
	public void inOrderTraversal() {
        if (this.root.isNull()) {
            return;
        }
        
        System.out.println("In Order Traversal : Starts");
        inOrderTraversalHelper(this.root);
        System.out.println("In Order Traversal : Ends");
    }

	private  void printOddNumbersInPreOrderTraversalHelper(HeapNode currentNode) {
        if (currentNode==null) {
            return;
        }

        if (currentNode.getVal() % 2 != 0) {
        	System.out.println(currentNode.getVal());
        }

        printOddNumbersInPreOrderTraversalHelper(currentNode.getLeft());
        printOddNumbersInPreOrderTraversalHelper(currentNode.getRight());
    }
	
    public void printOddNumbersInPreOrderTraversal() {
        if (this.root.isNull()) {
            return;
        }

        System.out.println("Pre Order Traversal -> Printing Odd Numbers : Starts");
        printOddNumbersInPreOrderTraversalHelper(this.root);
        System.out.println("Pre Order Traversal -> Printing Odd Numbers : Ends");
    }
    
	@Override
	public String toString() {
		return "MinHeapTree [root = " + root + "]";
	}

	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new InOrderIterator();
    }

    @Override
    public int size() {
        return getTotalNodes();
    }

    // Inner class example
    private class InOrderIterator implements
                    Iterator<Integer> {
       
        private HeapNode cursor;
    
        public InOrderIterator() {
        	cursor = root;
            if(cursor == null)
                return;

            while (cursor.getLeft() != null)
            	cursor = cursor.getLeft();
        }

        public boolean hasNext() {
        	return cursor != null;
        }
        
 
        public Integer next(){
            if(!hasNext()) throw new NoSuchElementException();
            HeapNode r = cursor;

           
            if(cursor.getRight() != null) {
                cursor = cursor.getRight();
                while (cursor.getLeft() != null)
                    cursor = cursor.getLeft();
                return r.getVal();
            }

            while(true) {
                if(cursor.getParent() == null) {
                	cursor = null;
                    return r.getVal();
                }
                if(cursor.getParent().getLeft() == cursor) {
                	cursor = cursor.getParent();
                   return r.getVal();
                }
                cursor = cursor.getParent();
            }
         }
        

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
