public class DoublyLinkedList<T> {
    private DoublyLinkedNode<T> first;
    private DoublyLinkedNode<T> last;
    int size = 0;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void addFirst(T data) {
        DoublyLinkedNode<T> temp = new DoublyLinkedNode<>(data);

        if (first == null && last == null) {
            first = temp;
            last = temp;
        }
        else {
            temp.setNext(first);
            first.setPrev(temp);
            first = temp;
        }
        size++;
    }

    public void addLast(T data) {
        DoublyLinkedNode<T> temp = new DoublyLinkedNode<>(data);
        if (first == null && last == null) {
            first = temp;
        }
        else {
            last.setNext(temp);
            temp.setPrev(last);
            temp.setNext(null);
        }
        last = temp;
        size++;
    }

    public T removeFirst() {
        DoublyLinkedNode<T> temp = first;
        //if empty
        if (first == null && last == null) {
            return null;
        }
        //if index is 1
        if (first == last) {
            first = null;
            last = null;
            return temp.getData();
        }
        //
        first = first.getNext();
        first.setPrev(null);
        size--;
        return temp.getData();

    }

    public T removeLast() {
       DoublyLinkedNode<T> temp = last;
        if (first == null)
            return null;
        if (first == last) {
            first = null;
            last = null;
            return temp.getData();
        }
        last = last.getPrev();
        last.setNext(null);
        return temp.getData();
    }

    public void addIndex(int loc, T data) {
        MyListNode<T> iData = new MyListNode<>(data);
        //edge cases
        if (first == null) {
            first = iData;
            return;
        }
        if (n >= size)
            throw new ArrayIndexOutOfBoundsException("N INDEX IS TOO BIG FOR LiST");

        //previous
        //current

        MyListNode<T> previous = first;
        MyListNode<T> current = first.getNext();
        if (n == 0) {
            iData.setNext(first);
            first = iData;
            return;
        }
        if (n == size) {
            MyListNode<T> lastVar = last;
            lastVar.setNext(iData);
        }
        for (int i = 1; i < n; i++) {
            previous = current;
            current = current.getNext();
        }//current = n

        previous.setNext(iData);
        iData.setNext(current);
    }

    public T removeInt(int loc) {
        return null;
    }

    public String toString() {
        DoublyLinkedNode<T> current = first;
        String out = "";
        while(current != null) {
            out += (current.getData() + "->");
            current = current.getNext();
        }
        out += "null";
        return out;
    }
}
