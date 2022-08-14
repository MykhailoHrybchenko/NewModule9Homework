public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap();


        System.out.println("MAX SIZE: " + map.maxSize);
        System.out.println("SIZE: " + map.size());

        map.put("Pootis1", 1);
        map.put("Pootis2", 2);
        map.put("Pootis3", 3);
        map.put("Pootis4", 4);

        System.out.println("MAX SIZE: " + map.maxSize);
        System.out.println("SIZE: " + map.size());

        for (int i = 0; i < map.array.length; i++)
        {
            if(map.array[i] == null) continue;

            var currentElement = map.array[i].peek();
            while(currentElement != null)
            {
                System.out.println("KEY: " + currentElement.getKey() + " | " + " VALUE: " + currentElement.getValue());
                currentElement = currentElement.getNext();
            }
            System.out.println("------");
        }
    }
}
