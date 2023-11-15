package org.example;

public class HashTable2 {
    private class Entry {
        private int key;
        private String value;
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private Entry[] entries = new Entry[15];
    private int size;


    public void put(int key, String value){
        var index = hash(key);



        //Adding/Updating New Entry using Linear Probing
        while(entries[index] != null){
            //If there is something at that index, check if the key matches, and if so then update value.
            if(entries[index].key == key){
                entries[index].value = value;
            }
            //Keep incrementing index until you find an empty slot or find the key you're looking for.
            index++;
            if(index>entries.length-1){
                throw new NullPointerException();
            }
        }
        entries[index] = new Entry(key, value);
        size++;
    }

    public String get(int key){
        var index = hash(key);
        //Increment index until you find the key you're looking for
        while(entries[index].key != key){
            index++;
            if(entries[index] == null || index>entries.length-1){
                return "Entry not Found";
            }
        }
        return entries[index].value;
    }

    public void remove(int key){
        var index = hash(key);
        //Search for entry using linear probing
        while(entries[index].key != key) {
            index++;
            if(index>entries.length-1){
                System.out.println("Entry not found");
            }
        }
        //If you do find the entry - set to null
        if(entries[index].key == key){
            entries[index] = null;
            size--;
        }
    }

    public int size(){
        return size;
    }

    private int hash(int key){
        return key%entries.length;
    }

}
