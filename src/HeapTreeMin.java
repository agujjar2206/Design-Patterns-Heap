
public class HeapTreeMin implements HeapTreeStrategy{

	@Override
	public HeapTree createHeap() {
		return new HeapTree(HeapType.MIN_HEAP);
	}
	
}
