import java.util.Iterator;

public class OddFilter implements Iterator<Integer> {
    Iterator<Integer> iterator;
    public OddFilter(Iterator<Integer> input) {
        this.iterator = input;
    }
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Integer next() {
        while (true) {
            if (this.iterator.hasNext()) {
                int nextElement = this.iterator.next();
                if (nextElement % 2 == 1)
                    return nextElement;
            }
        }
    }
}
