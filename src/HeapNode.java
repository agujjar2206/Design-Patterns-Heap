

public class HeapNode {
	
	// To Hold Node value
	private int val; 
	
	// Left Child of Node
	private HeapNode left;
	
	// Right Child of Node
	private HeapNode right;
	
	// To hold the parent of any node so that we can traverse upwards, similar to doubly linked list
	private HeapNode parent;
	
	// To hold the height, this property is required for insertion so maintaining for each node and gets updated on insertion (all ancestors) 
	private int height; 
	
	// While creating a new Node, always links its parent
	public HeapNode(int val, HeapNode parent) {
		super();
		this.val = val;
		this.parent = parent;
	}
	
	public HeapNode(int val) {
		super();
		this.val = val;
	}

	public HeapNode() {

	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public HeapNode getLeft() {
		return left;
	}
	public void setLeft(HeapNode left) {
		this.left = left;
	}
	public HeapNode getRight() {
		return right;
	}
	public void setRight(HeapNode right) {
		this.right = right;
	}
	public HeapNode getParent() {
		return parent;
	}
	public void setParent(HeapNode parent) {
		this.parent = parent;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		// overriding so that we can print the MinHeap object
		return "Node [val=" + val +  ", height=" + height + ", left=" + left + ", right=" + right
				+ "]";
	}

	public boolean isNull() {
		return false;
	}

	public void heapByType(int val, String type) {

	}
}
