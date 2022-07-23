/** Null Node for Null Object Pattern */

public class NullNode extends HeapNode{
    NullNode() {

    }
    public boolean isNull() {
        return true;
    }
    public Integer toArray() {
        return null;
    }
    public String toString() {
        return null;
    }
}