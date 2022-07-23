/**This Decorator does not make sense because a decorator pattern is used to add additional responsibilities
 * to an object without altering its structure. Although we are not altering the structure, we are not adding
 * any new functionality.
*/
import java.util.ArrayList;

public class OddHeapDecorator extends HeapDecorator{

    public OddHeapDecorator(ICollection iCollection) {
        super(iCollection);
    }

    public String toString() {
        String str = "";
        OddFilter oddFilter = new OddFilter(this.iCollection.iterator());
        return oddFilter.next().toString();
    }

    public Integer[] toArray() {
        OddFilter oddFilter = new OddFilter(this.iCollection.iterator());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(oddFilter.hasNext())
            arr.add(oddFilter.next());
        Integer[] intArr = (Integer[])arr.toArray(new Integer[arr.size()]);
        return intArr;
    }
}
