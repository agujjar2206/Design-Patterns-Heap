
public class HeapTreeContext {
	private HeapTreeStrategy strategy;

	   public HeapTreeContext(HeapTreeStrategy strategy){
	      this.strategy = strategy;
	   }

	   public HeapTree createHeap(){
	      return strategy.createHeap();
	   }
}
