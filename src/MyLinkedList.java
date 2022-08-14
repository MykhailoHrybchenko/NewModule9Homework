public class MyLinkedList<E extends Object> {
    private MyNode headElement;
    private MyNode tail;
    private MyNode current;
    private int size;

   public void add(E value) {
        if (headElement == null) {
            headElement = new MyNode<E>(value);
            tail = headElement;
            size = 1;
            return;
        }
        MyNode newNode = new MyNode<E>(value);
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void remove(int index) {
       if (index < 0 || index > size) {
           System.out.println("Index out of bounds");
           return;
       }
       int counter = 1;
       current = headElement;
       while (counter != index) {
            counter++;
            current = current.getNext();
       }
       if (current.getNext() != null) {
           MyNode previousNode = current.getPrevious();
           MyNode nextNode = current.getNext();
           previousNode.setNext(nextNode);
       } else {
           current.getPrevious().setNext(null);
       }
       size--;
    }

    public void clear() {
       headElement = null;
       tail = null;
       current = null;
       size = 0;
    }

    public int size() {
       return size;
    }

    public E get(int index) {
       int counter = 1;
       current = headElement;
       while (counter != index) {
           MyNode nextNode = current.getNext();
           current = nextNode;
           counter++;
       }
       return (E) current.getValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        current = headElement;
        while (current != null) {
            stringBuilder.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }
}
