package Homework;

public class HomeWork14 {
    public static void main(String[] args){
        //1: Write a program that finds the largest and smallest numbers in a given array using nested loops.
        int[] num ={2,-7,8,9,10};
        largSmallNumber(num);

        //2: Write a program that generates all possible combinations of
        // two letters from the English alphabet using nested loops. (hint: can use this: char i = 'a'; i <= 'z'; i++)
        combinationOfTwoLetters();

        //3:  Write a program that generates all possible combinations of
        // three letters from the word "cat" using nested loops.
        String word = "cat";
        //combinationOfGivenWord(word);e

        //4: Write a program that finds the index of the last occurrence of a given element
        //in a sorted array using binary search. (example array int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};)
        int[] arr = {1,2,2,3,4,4,4,5};
        int element  = 5;
        int originalIndex = indexOfGivenNumber(arr, element);
        System.out.println(originalIndex);
        System.out.println(checkForLastOccurrence(originalIndex, arr, element));

    }


    public static int checkForLastOccurrence(int index, int[] arr, int num){
        int first = index+1;
        int last = arr.length-1;
        int mid = (first+last)/2;
        while(first <= last) {
             mid = (first+last)/2;
             if(mid == first){
                 return mid;
             }
            if (arr[mid] == num) {
                first = mid;
            } else {
                last = mid;
//                if(arr[last-1] == mid){
//                    return last;
//                }
            }
        }
        return index;
    }

    public static int indexOfGivenNumber(int[] arr, int num){
        int first = 0;
        int last = (arr.length)-1;
        int mid = (first+last)/2;
        while(first<=last){
            mid = (first+last)/2;
            if(arr[mid] == num ){
                return mid;
            } else if (num > arr[mid]) {
                first = mid+1;
            }else {
                last = mid-1;
            }
        }
        return mid;

    }




    public static void combinationOfGivenWord(String word){
        for(int i=0; i<word.length(); i++){
            for (int j=0; j<word.length(); j++){
                //for(int k=0; )
                System.out.println(word.charAt(i)+word.charAt(j));
            }
        }

    }


    public static void combinationOfTwoLetters() {
        for(char i='a'; i<='z'; i++){
            for(char j = 'a'; j<='z'; j++){
                System.out.print(i+""+j+" ");
            }
            System.out.println();
        }
    }

    public static void largSmallNumber(int[] num){
        int small = num[0], large = num[0];
        for(int j=1; j< num.length; j++){
            if(num[j] < small) {
                small = num[j];
            }
            if(num[j] > large) {
                large = num[j];
            }
        }

        System.out.println("The smallest number in the given array is: " + small);
        System.out.println("The largest number in the given array is: " + large);
    }
}
