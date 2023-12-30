
public class MyLinkedList<T extends Comparable <T>> {

    private Node<T> head;


    private static class Node<T> {
        int size;
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.size = 0;

        }

        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void addFirst(T t) {
        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
    }

//    public int getSize() {
//        return size;
//    }

    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t);
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(t);
    }


    public int get(T t) {
        if (head == null) return -1;
        if (head.value == t) return 0;
        Node<T> currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            result++;
            if (currentNode.next.value == t) return result;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void remove(T t) {
        if (head == null) return;
        if (head.value == t) {
            head = head.next;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next == t) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }

    }

        public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }

}