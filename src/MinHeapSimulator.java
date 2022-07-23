/**
* <h1>Min Heap creation</h1>
* ⭐️ To create the MinHeap (figure 1) as that is NOT feasible based on problem constraint for inserting node
* So creating it manually to simulate figure 1
* 
* @author  Himanshi Shukla
* @version 1.0
* @since   2021-09-17
*/
public class MinHeapSimulator {

	public HeapTree create_base_minHeap() {
		HeapTreeContext heapContext = new HeapTreeContext(new HeapTreeMin());
		HeapTree minHeap = heapContext.createHeap();
		
		minHeap.setRoot(new HeapNode(45));

		minHeap.getRoot().setLeft(new HeapNode(65, minHeap.getRoot()));
		minHeap.getRoot().setRight(new HeapNode(72, minHeap.getRoot()));

		minHeap.getRoot().getLeft().setLeft(new HeapNode(90, minHeap.getRoot().getLeft()));
		minHeap.getRoot().getLeft().setRight( new HeapNode(81, minHeap.getRoot().getLeft()));

		minHeap.getRoot().getRight().setLeft(new HeapNode(82, minHeap.getRoot().getRight()));
		minHeap.getRoot().getRight().setRight(new HeapNode(96, minHeap.getRoot().getRight()));

		minHeap.getRoot().getLeft().getLeft().setLeft(new HeapNode(99, minHeap.getRoot().getLeft().getLeft()));
		minHeap.getRoot().getLeft().getLeft().setRight(new HeapNode(95, minHeap.getRoot().getLeft().getLeft()));

		minHeap.updateHeightOfAllNodes();
		
		return minHeap;
	}
}
