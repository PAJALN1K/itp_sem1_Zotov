public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K incKey, V incValue) {
        key = incKey;
        value = incValue;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K incKey) {
       key = incKey;
    }

    public void setValue(V incValue) {
        value = incValue;
    }
}
