package algorithms.edouardb;

import algorithms.edouardb.struct.HashTable;

import java.util.concurrent.ThreadLocalRandom;

public class Main
{

    private static int HASH_LENGTH = 6563;

    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<Integer, String>();
        for(int i = 0; i < HASH_LENGTH; i++) {
            table.put(i, generateRandomString(ThreadLocalRandom.current().nextInt(5, 20)));
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(table.get(i));
        }
        System.out.println(table.size() + "," + table.getOccupied());
    }

    private static String generateRandomString(int length) {
        int threshold = 26;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++ ){
            sb.append((char)('a' + (int)(Math.random() * threshold)));
        }
        return sb.toString();
    }
}
