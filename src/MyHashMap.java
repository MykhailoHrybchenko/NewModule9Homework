import java.lang.reflect.Array;
import java.util.Arrays;


public class MyHashMap<K, V> {
    public MyMapLinkedList<K,V>[] array;
    private int size = 0;
    public int maxSize = 16;

    public MyHashMap()
    {
        MyMapLinkedList<K,V> clazz = new MyMapLinkedList<>();
        array = (MyMapLinkedList<K, V>[]) Array.newInstance(clazz.getClass(), maxSize);
    }

    public void put(K key, V value)
    {
        int index = key.hashCode() & (maxSize - 1);

        if(array[index] == null)
        {
            array[index] = new MyMapLinkedList<>();
        }
        MyMapLinkedList<K,V> bucketElements = array[index] ;

        if(bucketElements.size() > 0)
        {
            addOrReplace(bucketElements, key, value);
        }
        else
        {
            add(bucketElements, key, value);
        }
    }

    private void addOrReplace(MyMapLinkedList<K,V> bucketElements, K key, V value)
    {
        MyMapNode<K,V> currentElement = bucketElements.peek();
        int counter = 0;
        while(currentElement != null)
        {
            if(currentElement.getKey().equals(key))
            {
                bucketElements.remove(counter);
                add(bucketElements, key, value);
                return;
            }
            currentElement = currentElement.getNext();
            counter++;
        }
        add(bucketElements, key, value);
    }

    private void add(MyMapLinkedList<K,V> bucketElements, K key, V value)
    {
        bucketElements.add(key, value);
        size++;
        if((double)size / maxSize > 0.75d)
        {
            expandArray();
        }
    }

    private void expandArray()
    {
        maxSize *= 2;
        array = Arrays.copyOf(array, maxSize);
    }

    public int size()
    {
        return size;
    }

    public V get(K key)
    {
        for(int i = 0; i < maxSize; i++)
        {
            if(array[i] == null) continue;

            var currentElement = array[i].peek();
            while(currentElement != null)
            {
                if(currentElement.getKey() == key)
                {
                    return (V) currentElement.getValue();
                }
                currentElement = currentElement.getNext();
            }
        }

        return null;
    }

    public void remove(K key)
    {
        for(int i = 0; i < maxSize; i++)
        {
            if(array[i] == null) continue;

            var currentElement = array[i].peek();

            int counter = 0;
            while(currentElement != null)
            {
                if(currentElement.getKey() == key)
                {
                    array[i].remove(counter);
                }
                currentElement = currentElement.getNext();
                counter++;
            }
        }
    }

    public void clear() {
        MyMapLinkedList<K,V> clazz = new MyMapLinkedList<>();
        array = (MyMapLinkedList<K, V>[]) Array.newInstance(clazz.getClass(), maxSize);
        size = 0;
        maxSize = 16;
    }
}
