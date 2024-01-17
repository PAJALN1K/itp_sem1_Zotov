import java.util.LinkedList;

public class HashTable<K, V> {
    private final int DEFAULT_CAPACITY = 7;
    private int size;
    public LinkedList<Entry<K, V>>[] table;


    public HashTable() {
        size = 0;
        table = new LinkedList[DEFAULT_CAPACITY];
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry: table[index]) {
            if (entry.getKey().equals((key))) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).getKey().equals(key)) {
                    return table[index].get(i).getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).getKey().equals(key)) {
                    table[index].remove(i);
                    size--;
                }
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.format("Index %s: ", i);
            if (table[i] != null) {
                for (int j = 0; j < table[i].size(); j++) {
                    if (j != 0) System.out.print(" -> ");
                    System.out.format("(%s, %s)", table[i].get(j).getKey(), table[i].get(j).getValue());
                }
            }
            System.out.println();
        }
    }

    public int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
