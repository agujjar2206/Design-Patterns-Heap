import static org.junit.Assert.*;

import org.junit.Test;

public class JunitMinHeap {

	@Test
    public void inser_new_node() {
		MinHeapSimulator minHeapSimulator = new MinHeapSimulator();
		HeapTree minHeap = minHeapSimulator.create_base_minHeap();
		
		// Actual Insertion based on the condition
		minHeap.add(50);
		assertTrue("Original value of 72 will be replaced by 50", minHeap.getRoot().getRight().getVal() != 72);
		assertEquals(minHeap.getRoot().getRight().getVal(), 50);
		assertEquals(minHeap.getRoot().getRight().getLeft().getVal(), 72);
		assertEquals(minHeap.getRoot().getRight().getLeft().getLeft().getVal(), 82);
    }

	@Test
	public void insert_new_node_with_null() {
		HeapTreeContext heapContext = new HeapTreeContext(new HeapTreeMin());
		HeapTree minHeap = heapContext.createHeap();
		// Insert a node with value 10
		minHeap.add(10);
		assertEquals(minHeap.getRoot().getVal(), 10);
	}

	@Test
	public void try_to_access_null() {
		HeapTreeContext heapContext = new HeapTreeContext(new HeapTreeMin());
		HeapTree minHeap = heapContext.createHeap();
		// Insert a node with value 10
		minHeap.add(10);
		// Value of root.right is null
		assertNull(minHeap.getRoot().getRight());
	}

	@Test
	public void false_value() {
		HeapTreeContext heapContext = new HeapTreeContext(new HeapTreeMin());
		HeapTree minHeap = heapContext.createHeap();
		// Insert a node with value 10
		minHeap.add(10);
		// Value of root.right is null
		assertFalse(minHeap.getRoot().getVal() == 20);
	}

	@Test
	public void same_value() {
		HeapTreeContext heapContext = new HeapTreeContext(new HeapTreeMin());
		HeapTree minHeap = heapContext.createHeap();
		// Insert a node with value 10
		minHeap.add(10);
		minHeap.add(10);
		minHeap.add(10);
		// Value of root.right is null
		assertSame(minHeap.getRoot().getLeft().getVal(), minHeap.getRoot().getRight().getVal());
	}

}
