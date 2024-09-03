package labprogram;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericList<T> {
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class main3 {
    public static void main(String[] args) {
        GenericList<Integer> integerList = new GenericList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        System.out.println("Integer List:");
        integerList.display();

        GenericList<Double> doubleList = new GenericList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        System.out.println("Double List:");
        doubleList.display();
    }
}

