import java.util.Iterator;

abstract class HeapDecorator implements ICollection{
    protected ICollection iCollection;

    public HeapDecorator(ICollection iCollection) {
        this.iCollection = iCollection;
    }
    public String toString() {
        return this.iCollection.toString();
    }
    public Integer[] toArray() {
        return this.iCollection.toArray();
    }
    public Iterator<Integer> iterator() {
        return this.iCollection.iterator();
    }
}
