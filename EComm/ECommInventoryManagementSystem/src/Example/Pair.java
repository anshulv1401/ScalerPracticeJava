package Example;

import java.util.Comparator;

class Pair<K, V> implements Comparable {
    private K first;
    private V second;


    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }


    public K getFirst() {
        return first;
    }


    public V getSecond() {
        return second;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}