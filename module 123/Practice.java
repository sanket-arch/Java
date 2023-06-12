public class Practice {
    private static class Node {
        int data;
        Node next;
    }

    final double PI = 3.0;

    void callMe() {
        
        System.out.println(PI);
    }

    static void nonStatic() {

    }

    static class LL {
        Node head = null;
        Node tail = null;

        public void create(int x) {

            if (head == null) {
                Node node = new Node();
                node.data = x;
                head = node;
                tail = node;
                node.next = null;
            } else {
                Node node = new Node();
                node.data = x;
                tail.next = node;
                tail = tail.next;
            }
        }
    }

    public static void main(String[] args) {
        // LL list1 = new LL();
        // list1.create(10);
        // list1.create(40);
        // Node i = list1.head;
        // while (i != null) {
        // System.out.println(i.data);
        // i = i.next;
        // }

        Practice p = new Practice();
        int[] x = { 1, 2, 3 };
        p.callMe();
    }
}
