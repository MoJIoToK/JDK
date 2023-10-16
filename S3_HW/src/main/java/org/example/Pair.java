package org.example;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getFirst() {
        return key;
    }

    public V getSecond() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Type of key is " + key.getClass().getName() +", key = " + getFirst() +
                " type of value is" + value.getClass().getSimpleName() + " value = " + getSecond());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Pair pair1 = new Pair(1, 2);
        pair1.toString();
        System.out.println(pair1);
    }
}
