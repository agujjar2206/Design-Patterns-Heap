import java.util.Iterator;

public class MainExecutor {

	public static void main(String[] args) {
		System.out.println("====== Min Heap =======");
		HeapTreeContext heapContext = new HeapTreeContext(new HeapTreeMin());
		HeapTree minHeap = heapContext.createHeap();
		minHeap.add(100);
		minHeap.add(50);
		minHeap.add(150);
		minHeap.add(25);
		minHeap.add(75);
		minHeap.add(12);
		minHeap.add(125);
		System.out.println(minHeap);
		minHeap.postOrderTraversal();
		minHeap.inOrderTraversal();
		
		
		System.out.println("====== Max Heap =======");
		heapContext = new HeapTreeContext(new HeapTreeMax());
		HeapTree maxHeap = heapContext.createHeap();
		maxHeap.add(100);
		maxHeap.add(50);
		maxHeap.add(150);
		maxHeap.add(25);
		maxHeap.add(75);
		maxHeap.add(12);
		maxHeap.add(125);
		System.out.println(maxHeap);
		maxHeap.postOrderTraversal();
		maxHeap.inOrderTraversal();

		System.out.println("===== Odd Filter ======");
		OddFilter oddFilter = new OddFilter(minHeap.iterator());
		while (oddFilter.hasNext()) {
			System.out.println("hasNext(): " + oddFilter.hasNext());
			System.out.println("next(): " + oddFilter.next());
		}
		System.out.println("After all odd elements");
		System.out.println("hasNext(): " + oddFilter.hasNext());
  
        // Using iterator to print the values of minHeap using InOrder Traversal
		System.out.println("====== MinHeap values using InOrder Iteration");
        Iterator<Integer> it = maxHeap.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
		
		minHeap.printOddNumbersInPreOrderTraversal();

		//Odd Heap Decorator
//		OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(minHeap);
	}

}
