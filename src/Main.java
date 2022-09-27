public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(15);
        list.addFirst(20);
        list.addFirst(25);
        list.addLast(25);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);






        MyLinkedList<Integer> l =new MyLinkedList<>();

        /*
        list.addFirst(5);
        list.addFirst(53);
        list.addFirst(52);
        list.addFirst(51);
        list.addFirst(59);
        list.addLast(100);
        System.out.println(list);
        list.addIndex(0,0);
        System.out.println(list);

         */
        /*try {
            System.out.println(list.removeLast());
            System.out.println(list.removeLast());
            System.out.println(list.removeLast());
            System.out.println(list.removeLast());
            System.out.println(list.removeLast());
            System.out.println(list.removeLast());
        } catch(NullPointerException e) {
            System.out.println("RECOVERED: Attempted to remove item from emtpy list");
        }

         */

    }
}
