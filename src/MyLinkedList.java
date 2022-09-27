public class MyLinkedList <T>{

    private MyListNode<T> first;
    private MyListNode<T> last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;

    }

    public void addFirst(T data) {
        MyListNode<T> temp = new MyListNode<>(data);

        //edge case
        if (first == null && last == null) {
            first = temp;
            last = temp;
        }
        else {
            //pointnew node to first
            temp.setNext(first);
            first = temp;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        MyListNode<T> temp = first;
        if (first == null) {
            throw new NullPointerException("MYLINKED LIST IS EMPTY");
        }
        if (first == last) {
            T data = first.getData();
            first = null;
            last = null;
            return data;
        }


        //current.getNext() != last run
        while(temp.getNext() != last) {
            temp = temp.getNext();
        }

        T lastData = last.getData();
        temp.setNext(null);
        last = temp;
        size--;
        return lastData; //last node
    }

    public void addLast(T data) {
        MyListNode<T> temp = new MyListNode<>(data);

        //edge case empty list
        if (first == null && last == null) {
            first = temp;
            last = temp;
        }
        else {
            //pointnew node to first
            last.setNext(temp);
            last = temp;
        }
        size++;
    }

    public void addIndex(int n, T data) {
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

    public T removeIndex(int n) {
        //edge cases
        //empty list
        if (first == null)
            throw new NullPointerException("EMPTY LIST");
        //n greater than list
        if (n >= size)
            throw new ArrayIndexOutOfBoundsException("NUM PASSED IN IS GREATER THAN LIST LENGTH");


        MyListNode<T> previous = first; //first node
        MyListNode<T> current = first.getNext(); //second node
        MyListNode<T> next = current.getNext(); //third node

        if (n == size-1)
            return removeLast();
        else if (n == 0) {
            return removeFirst();
        }

        for (int i = 1; i < n; i++) { //makes current = n //previous = n-1
            previous = current;
            current = current.getNext();
            next = next.getNext();
        }
        previous.setNext(next); //points n-1 -> n+1 //lose connection n-1 -> n
        current.setNext(null); //n is floating, hes lonely
        size--;
        return current.getData(); //return n data
    }


    public T removeFirst() {
        MyListNode<T> temp = first;

        if (first == null)
            throw new NullPointerException("MYLINKED LIST IS EMPTY");
        else {
            first = temp.getNext();
            temp.setNext(null);//breaks off connection
        }
        size--;
        return temp.getData();
    }

    //finish
    public T removeInt(int loc) {
        if (size == loc)
            return removeLast();
        else if (loc > size)
            throw new ArrayIndexOutOfBoundsException("OUT OF LIST SIZE");
        else if (loc == 1) {
            return removeFirst();
        }

        else if(size<3){
            MyListNode<T> temp1 = first.getNext();
            first.setNext(last);
            return temp1.getData();
        }
        else {
            MyListNode<T> temp1 = first;
            MyListNode<T> temp2 = temp1.getNext();
            MyListNode<T> temp3 = temp2.getNext();
            for (int i = 0; i < loc - 2; i++) {
                temp1 = temp2;
                temp2 = temp2.getNext();
                temp3 = temp3.getNext();
            }
            temp1.setNext(temp3);
            size--;
            return temp2.getData();
        }

    }

    public String toString() {
        MyListNode<T> current = first;
        String out = "";
        while(current != null) {
            out += (current.getData() + "->");
            current = current.getNext();
        }
        out += "null";
        return out;
    }
}
