public class MyStack<E extends Object> {

    private MyNode firstElement;
    private MyNode lastElement;
    private MyNode currentElement;
    private int size;

    public void push(E value) {
        if (firstElement == null) {
            firstElement = new MyNode<E>(value);
            lastElement = firstElement;
            size = 1;
            return;
        }
        MyNode newNode = new MyNode<E>(value);
        newNode.setPrevious(lastElement);
        lastElement = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        int counter = size - 1;
        currentElement = lastElement;
        MyNode target = null;

        if (counter == index) {
            lastElement = currentElement.getPrevious();
            currentElement = null;
            return;
        }

        while (counter > index + 1) {
            counter--;
            currentElement = currentElement.getPrevious();
        }

            target = currentElement.getPrevious();

            if (target.getPrevious() != null) {
                MyNode previousNode = target.getPrevious();
                currentElement.setPrevious(previousNode);
            } else {
                currentElement.setPrevious(null);
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
        return (E) lastElement.getValue();
    }

    public E pop() {
        MyNode target = lastElement;
        remove(size - 1);
        size--;
        return (E) target.getValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        currentElement = lastElement;
        while (currentElement != null) {
            stringBuilder.append(currentElement.getValue()).append(" ");
            currentElement = currentElement.getPrevious();
        }
        return stringBuilder.toString();
    }
}
