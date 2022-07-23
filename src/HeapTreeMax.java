
public class HeapTreeMax implements HeapTreeStrategy{

	@Override
	public HeapTree createHeap() {
		return new HeapTree(HeapType.MAX_HEAP);
	}
}
