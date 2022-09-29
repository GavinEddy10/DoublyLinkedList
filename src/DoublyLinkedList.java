public class DoublyLinkedList <T> {
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
        if (first == null) {
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
        size--;
        return temp.getData();
    }

    public void addIndex(int loc, T data) {
        DoublyLinkedNode<T> dataNode = new DoublyLinkedNode<>(data);
        if (loc > size || loc < 0)//loc > size
            throw new ArrayIndexOutOfBoundsException("INDEX IS NOT IN LIST");

        if (first == null) {//empty
            addFirst(dataNode.getData());
            return;
        }

        if (loc == 0) {
            addFirst(dataNode.getData());
            return;
        }
        if (loc == size) {
            addLast(dataNode.getData());
            return;
        }

        DoublyLinkedNode<T> previous = first;
        DoublyLinkedNode<T> current = first.getNext();
        for (int i = 1; i < loc; i++) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(dataNode);
        dataNode.setNext(current);
        size++;
    }

    public T removeIndex(int loc) {
        if (loc > size || loc < 0)//loc > size loc < 0
            throw new ArrayIndexOutOfBoundsException("INDEX LOC IS NOT IN LIST");

        if (first == null) {
            throw new ArrayIndexOutOfBoundsException("LIST IS EMPTY");
        }

        if (loc == 0) {
            T data = removeFirst();
            return data;
        }
        if (loc == size) {
            T data = removeLast();
            return data;
        }

        DoublyLinkedNode<T> previous = first;
        DoublyLinkedNode<T> current = first.getNext();
        for (int i = 1; i < loc; i++) {
            previous = current;
            current = current.getNext();
        }
        T removedData = current.getData();
        current = current.getNext();
        previous.setNext(current);
        size--;
        return removedData;
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