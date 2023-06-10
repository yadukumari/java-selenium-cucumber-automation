package Homework;


import io.cucumber.java.sl.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HomeWork15 {
    public static void main(String[] args){

        //1:  Reverse a String: Write a Java method that takes a
        // String as input and returns a new String with the characters in reverse order.
        String word = "RaviYadu";
        System.out.println(reverseWord(word));

        //3: Palindrome Check: Write a Java method that takes a String as input and returns true
        // if the String is a palindrome (reads the same forwards and backwards), and false otherwise.
        word = "bjab";
        System.out.println("Is given word Palindrome or not? " + isPalindrome(word));

        //4:FizzBuzz: Write a Java method that takes an integer n as input and prints out the numbers from 1 to n,
        // replacing numbers divisible by 3 with "Fizz", numbers divisible by 5 with "Buzz",
        // and numbers divisible by both 3 and 5 with "FizzBuzz".
        int num = 20;
        fizzBuzz(num);

        //5: Array Max: Write a Java method that takes an array of integers as
        // input and returns the maximum value in the array.
        int[] arr = {1,3,4,-6,20,100};
        System.out.println("Maximum number in a given array is: " + maxNumberArray(arr));

        //6:  Binary Search: Write a Java method that takes a sorted array of integers
        // and a target value as input, and returns the index of the target value in the array
        // (or -1 if the value is not in the array) using the binary search algorithm.
        int[] sortedArr = {3, 4, 7, 9, 16, 19, 30};
        int target = 10;
        System.out.println("The index of the target value is: " + binarySearch(sortedArr, target));

//        //7: Merge Sort: Write a Java method that takes an array of integers as input and sorts
//        // the array in ascending order using the merge sort algorithm
//        int[] mergeArray = {4,2,19,15,1,9,14,17,30,25};
//        mergeSort(mergeArray, 0, mergeArray.length-1);

        //8: Prime Factorization: Write a Java method that takes an integer n as input and
        // returns a list of its prime factors.
        num = 30;
        List<Integer> list = primeFactorization(num);
        System.out.println("Prime Factorization");
        for(int l : list){
            System.out.println(l);
        }

        //9) Anagram Check: Write a Java method that takes two Strings as input and returns true
        // if they are anagrams (contain the same characters in a different order), and false otherwise.
        String str1 = "care", str2 = "race";
        System.out.println("Is it a given words are Anagram: " + isAnagram(str1, str2));

        //10: Linked List Reverse: Write a Java method that takes a singly linked list as input and
        // returns a new linked list with the nodes in reverse order.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(11);
        linkedList.add(33);

        System.out.println("The list before reverse  is: " + linkedList);

        System.out.println("The reversed list is: " + reverseLinkedList(linkedList));

    }

    public static String reverseWord(String word){
        String result = "";
        for(int i = word.length() - 1; i >=0;  i--){
            result += word.charAt(i);
        }

        return result;
    }

    public static boolean isPalindrome(String word){
        int j = word.length()-1;
        for(int i=0; i<word.length()/2 ; i++){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            j--;
        }

        return true;
    }

    public static void fizzBuzz(int num){
        for(int i=1; i<= num; i++){
            if(i%3 == 0 && i%5 == 0){
                System.out.println("FizzBuzz");
            } else if (i%3 == 0) {
                System.out.println("Fizz");
            }else if(i%5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }

    public static int maxNumberArray(int[] arr){
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    public static int binarySearch(int[] arr, int target){
        int index = -1;
        int high = 0, low = arr.length-1;
        int mid = (high+low)/2;
        while(high <= low){
            mid = (high+low)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                high = mid+1;
            }else {
                low = mid-1;
            }
        }
        
        
        return index;
    }

    public static List<Integer> primeFactorization(int num){
        boolean status = false;
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<= num; i++){
            for(int j=1; j<=i/2; j++){
                if(i%j == 0 && j != 1 && j != i){
                    status = true;
                }
            }
            if(status == false){
                list.add(i);
            }
            status = false;
        }

        return list;
    }


    public static boolean isAnagram(String str1, String str2){
        boolean status = true;
        char[] word1 = str1.toCharArray();
        char[] word2 = str2.toCharArray();
        if(word2.length != word1.length){
            return false;
        }
        Arrays.sort(word1);
        Arrays.sort(word2);
        for(int i=0; i<word1.length; i++){
            if(word1[i] != word2[i]){
                return false;
            }
        }
        return status;
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> linkedList){

        LinkedList<Integer> reversedList = new LinkedList<>();
        for(int i=linkedList.size()-1; i>=0; i--){
            reversedList.add(linkedList.get(i));
        }

        return reversedList;
    }

//    public static void mergeSort(int[] arr,int low, int high){
//        if(low<high) {
//            int mid = (low+high)/2;
//            for (int i = low; i<=high; i++) {
//                System.out.print(arr[i]+" ");
//            }
//            System.out.println();
//            mergeSort(arr, low, mid);
//            System.out.println();
//            mergeSort(arr,mid+1,high);
//            sortArr(arr,low,mid, high);
//        }
//    }
//
//    public static void sortArr(int[] arr, int low, int mid, int high){
//        int j = mid+1, temp ;
//        while(low<=mid){
//           if(arr[j] < arr[low]){
//               temp = arr[j];
//               arr[j] = arr[low];
//               arr[low] = temp;
//               low++;
//           }else{
//               j++;
//           }
//        }
//        for(int a: arr){
//            System.out.println(a);
//        }
//
//    }

}
