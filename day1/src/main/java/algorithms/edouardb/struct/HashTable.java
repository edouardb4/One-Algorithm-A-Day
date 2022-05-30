package algorithms.edouardb.struct;

import java.util.Iterator;

public class HashTable<K, V> {

    private static int DEFAULT_LENGTH = 4;


    private ChainedList[] entries;
    private int occupied;
    private boolean shouldEnsure;
    public HashTable() {
        entries = new ChainedList[DEFAULT_LENGTH];
    }

    public void ensureCapacity() {
        if(entries.length * 2 < occupied) {
            move(entries, entries.length * 2);
        }
        else if(entries.length > 16 && entries.length / 2 > occupied) {
            move(entries, entries.length / 2);
        }
    }

    public int getOccupied() {
        return this.occupied;
    }

    public int size() {
        return entries.length;
    }

    public void move(ChainedList[] from, int size) {
        occupied = 0;
        this.entries = new ChainedList[size];
        for (ChainedList list : from) {
            if(list == null) {
                continue;
            }
            for (Entry<K, V> entry : list) {
                putSafely(entry.getKey(), entry.getValue());
            }
        }
    }

    public void putSafely(K key, V value) {
        int hashCode = key.hashCode();
        int intKey = hashCode % entries.length;
        ChainedList list = entries[intKey];
        if(list == null) {
            list = new ChainedList();
            entries[intKey] = list;
        }
        for(Entry entry : list) {
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        occupied++;
        list.add(new Entry(key, value));
    }

    public void put(K key, V value) {
        putSafely(key, value);
        ensureCapacity();
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int intKey = hashCode % entries.length;
        ChainedList list = entries[intKey];
        Iterator<Entry> iterator = list.iterator();
        while(iterator.hasNext()) {
            Entry<K, V> next = iterator.next();
            if (next.getKey().equals(key)) {
                return next.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int hashCode = key.hashCode();
        int intKey = hashCode % entries.length;
        ChainedList list = entries[intKey];
        Iterator<Entry> iterator = list.iterator();
        while(iterator.hasNext()) {
            Entry next = iterator.next();
            if(next.getKey().equals(key)) {
                iterator.remove();
                occupied--;
                break;
            }
        }
        if(list.size() == 0) {
            entries[intKey] = null;
        }
        ensureCapacity();
    }
}