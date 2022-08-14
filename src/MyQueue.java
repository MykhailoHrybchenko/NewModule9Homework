public class MyQueue<E extends Object> {
    private MyNode firstElement;
    private MyNode lastElement;
    private MyNode currentElement;
    private int size;

    public void add(E value) {
        if (firstElement == null) {
            firstElement = new MyNode<>(value);
            lastElement = firstElement;
            size = 1;
            return;
        }
        MyNode newNode = new MyNode<>(value);
        lastElement.setNext(newNode);
        lastElement = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        int counter = 0;
        currentElement = firstElement;
        MyNode target = null;
        if (counter == index) {
            firstElement = currentElement.getNext();
            currentElement = null;
            return;
        }
        while (counter < index - 1) {
            counter++;
            currentElement = currentElement.getNext();
        }
        target = currentElement.getNext();
        if (target.getNext() != null) {
            MyNode nextNode = target.getNext();
            currentElement.setNext(nextNode);
        } else {
            currentElement.setNext(null);
        }
        size--;
    }

    public void clear() {
        firstElement = null;
        lastElement = null;
        currentElement = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) firstElement.getValue();
    }

    public E poll() {
        MyNode target = firstElement;
        remove(0);
        size--;
        return (E) target.getValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        currentElement = firstElement;
        while (currentElement != null) {
            stringBuilder.append(currentElement.getValue()).append(" ");
            currentElement = currentElement.getNext();
        }
        return stringBuilder.toString();
    }
}
