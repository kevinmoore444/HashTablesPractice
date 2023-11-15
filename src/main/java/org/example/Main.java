package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    }


    public static char firstNonRepeat(String string){
        Map<Character, Integer> map = new HashMap<>();
        var chars = string.toCharArray();

        for(var character : chars){
            if(!map.containsKey(character)){
                map.put(character, 1);
            }
            else{
                map.put(character, map.get(character) + 1);
            }
        }
        for(var character : chars){
            if(map.get(character) == 1){
                return character;
            }
        }
        return Character.MIN_VALUE;
    }

    public static char firstRepeat(String string){
        Map<Character, Integer> map= new HashMap<>();
        var chars = string.toCharArray();

        for(var character : chars){
            if(!map.containsKey(character)){
                map.put(character, 1);
            }
            else{
                return character;
            }
        }
        return Character.MIN_VALUE;
    }

    public static int mostFrequent(int[] integers){
        if(integers.length == 0)
            throw new IllegalArgumentException();

        //Build Map of Integers and Occurances
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : integers){
            if(map.containsKey( number))
                map.put(number, (map.get(number)+1));
            else
                map.put(number, 1);
        }
        //Iterate over map,
        int max = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }



    public static int countPairsWithDiff(int[] integers, int k){
        int count = 0;
        //Build HashSet
        Set<Integer> set = new HashSet<>();
        for(int number : integers){
            set.add(number);
        }
        //Iterate over HashSet
        for(int number : set){
            if(set.contains(number+k))
                count++;
        }
        return count;
    }


    public static int[] twoSum(int[]integers, Integer target){
       int[]result = new int[2];
       //Build HashMap which stores each number as a key and it's index as a value
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<integers.length; i++){
            map.put(integers[i], i);
        }

        for(Integer number : map.keySet()){
            if(map.containsKey(target-number)){
                result[0] = map.get(number);
                result[1] = map.get(target-number);
                return result;
            }
        }
        return null;
    }
}

//Input: [1, 7, 5, 9, 2, 12, 3] K=2
//Go through each number and if it has
