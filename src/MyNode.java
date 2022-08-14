public class MyNode<E extends Object> {

    private E value;
    private MyNode previous;
    private MyNode next;

    public MyNode(E value) {
        this.value = value;
    }

    public MyNode getPrevious() {
        return previous;
    }

    public void setPrevious(MyNode previous) {
        this.previous = previous;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
