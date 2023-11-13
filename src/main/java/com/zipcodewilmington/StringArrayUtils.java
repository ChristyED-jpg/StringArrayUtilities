package com.zipcodewilmington;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];

    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean contains = false;
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }


        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
     /*   // convert array to list
        List<String> list = Arrays.asList(array);
        // reverse the list
        Collections.reverse(list);
        // convert the list back to array
        String[] result = list.toArray(new String[0]);
        // return array
        return result;*/
     int arrayLength = array.length/2;
     for( int i = 0 ; i < arrayLength; i++){
         int num = array.length - 1 -i;
         String temp = array[i];
         array[i]= array[num];
         array[num]= temp;
     }


      return array;

    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        // return true if  the same backwards and forward.
        boolean palindromic = false;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;

            } else {
                return true;
            }
        }

        return palindromic;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO

    public static boolean isPangramic(String[] array) {
        boolean[] alphabetPresent = new boolean[26]; // 26 letters in the  alphabet
        for (String str : array) {
            String cleanedString = str.replaceAll("", "").toLowerCase();
            for (char c : cleanedString.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    int index = c - 'a';
                    alphabetPresent[index] = true;
                }
            }
        }
        for ( boolean present: alphabetPresent){
            if(!present){
                return false;
            }
        }

        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (String arr : array) {
            if (arr == value){
                count += 1;
        }
    }
        return count;
    }

    /**
     * @param array array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
     String[] newArr = new String [array.length - 1];
     for(int i =0, k = 0; i < array.length;i++ ){
         if( array[i].equals(valueToRemove)){
          continue;
         }
         newArr [k++] = array[i];

     }

        return newArr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO

    public static String[] removeConsecutiveDuplicates(String[] array) {

        // return array of string without the consecutive Duplicate

        // Identifies consecutive duplicate.
        String current;
        String prev = "";
        Integer count = 0;

        for(int i =1; i< array.length; i++){ //  start at 1 to skip the 1st iteration to avoid index out of bounds error
             current = array[i];  //set to variable and  pull value.
           if ( i == 1 ){
               prev = array[i-1];
           }
            if (current.equals(prev)){
                // remove the Consecutive duplicate
                array[i] = null;
                count = count + 1;
            }
            prev = current;
        }

        //Create a new array to move the non-null values
           String [] result = new String [array.length - count];
        int newIndex = 0;// new index because result array is different size
        for( int i = 0; i< array.length; i++){
            if(array[i] != (null)){
                result [newIndex] = array[i] ;
                newIndex++;
            }
        }

        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
       String [] packArray = new String[array.length];
       int index = 0;

       boolean [] isDuplicate = new boolean [array.length];
     for(int i=0; i< array.length; i++) {
         if (isDuplicate[i]) {
             continue;
         }

         String current = array[i];
         String packString = current;
         for (int j = i + 1; j < array.length; j++) {
             String lookForward = array[j];
             if (current.equals(lookForward)) {
                 isDuplicate[j] = true;
                 packString = packString + lookForward;
             }
             if(!current.equals(lookForward)){
                 packArray[index] = packString;
                 index++;
             }
         }

         packArray[index] = packString;
         index++;
     }

     String [] result = new String[index];
       Integer resultIndex = 0;
     for(int i = 0; i < packArray.length; i++){
         String item = packArray[i];
         if( item != null){
             result [resultIndex] = item;//
             resultIndex++;
         }
     }



        return result;
    }










    public static String[] packDuplicates(String[] array) { // This version is an interview question
        String [] packArray = new String[array.length];
        int index = 0;

        boolean [] isDuplicate = new boolean [array.length];
        for(int i=0; i< array.length; i++) {
            if (isDuplicate[i]) {
                continue;
            }

            String current = array[i];
            String packString = current;
            for (int j = i + 1; j < array.length; j++) {
                String lookForward = array[j];
                if (current.equals(lookForward)) {
                    isDuplicate[j] = true;
                    packString = packString + lookForward;
                }
            }

            packArray[index] = packString;
            index++;
        }

        String [] result = new String[index];
        Integer resultIndex = 0;
        for(int i = 0; i < packArray.length; i++){
            String item = packArray[i];
            if( item != null){
                result [resultIndex] = item;//
                resultIndex++;
            }
        }



        return result;
    }
}
