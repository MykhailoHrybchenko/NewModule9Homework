import java.util.Arrays;


public class MyArrayList<E extends Object> {

    private E[] arr;

    public MyArrayList(E[] arr) {
        this.arr = arr;
    }

    public MyArrayList() {
    }

    public void add(Object value) {
        if (arr == null) {
            arr = (E[]) new Object[1];
            arr[0] = (E)value;
        } else {
             E tempArr[] = Arrays.copyOf(arr, arr.length + 1);
             arr = tempArr;
             arr[arr.length - 1] = (E)value;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E element : arr) {
            if (element == null) {
                stringBuilder.append("null" + " ");
            } else {
                stringBuilder.append(element.toString() + " ");
            }
        }
        return stringBuilder.toString();
    }

    public void remove(int index) {
        try {
            E[] newArr = (E[]) new Object[arr.length - 1];
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != index) {
                    newArr[j] = arr[i];
                    j++;
                }
            }
            arr = newArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is out of bounds");
        } catch (NullPointerException c) {
            System.out.println("Array is not initialized");
        } catch (Exception f) {
            System.out.println("Oops, something went wrong");
        }
    }

    public void clear() {
        arr = null;
    }

    public int size() {
        if (arr == null) {
            return 0;
        }
        return arr.length;
    }

    public E get(int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is out of bounds");
        } catch (NullPointerException c) {
            System.out.println("Array is not initialized");
        } catch (Exception f) {
            System.out.println("Oops, something went wrong");
        }
        return null;
    }
}
