public class MyMapLinkedList<K, V> {

    private MyMapNode<K, V> firstElement;
    private MyMapNode<K, V> lastElement;
    private MyMapNode<K, V> currentElement;
    private int size;

    public void add(K key, V value) {
        if (firstElement == null) {
            firstElement = new MyMapNode<>(key, value);
            lastElement = firstElement;
            size = 1;
            return;
        }
        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        lastElement.setNext(newNode);
        lastElement = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        int counter = 1;
        currentElement = firstElement;
        while (counter < index - 1) {
            counter++;
            currentElement = currentElement.getNext();
        }
        if (counter == 1) {
            firstElement = currentElement.getNext();
            size--;
            return;
        }
        if (currentElement.getNext() != null) {
            MyMapNode target = currentElement.getNext();
            MyMapNode nextNode = target.getNext();
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

    public MyMapNode<K, V> peek() {
        return firstElement;
    }

    public MyMapNode<K, V> poll() {
        MyMapNode<K, V> target = firstElement;
        remove(0);
        return (MyMapNode<K, V>) target.getValue();
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
