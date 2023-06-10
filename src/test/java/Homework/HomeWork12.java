package Homework;

public class HomeWork12 {

    public static void main(String[] args){

        //a) User inputs two numbers which are divided by 5. If a number is in a range of 1..10 -
        // print it saying it is in the range of 1 from 10.
        // If a number is in the range of 10..20 - print it saying it's in the range of 10..20.
        numberDivisibleByFive(40,20);

        //Write a method to check if array contains duplicates

        int[] arr ={4,2,6,8,3,8,9};
        System.out.println(duplicateNumber(arr));

    }

    //a) User inputs two numbers which are divided by 5. If a number is in a range of 1..10 -
    // print it saying it is in the range of 1 from 10.
    // If a number is in the range of 10..20 - print it saying it's in the range of 10..20.
    public static void numberDivisibleByFive(int num1 , int num2){
        int min = Math.min(num1, num2);
        int max = Math.max(num1,num2);
        if(((min/5)%2) != 0){
            min = min-5;
        }
        if(((max/5)%2) != 0){
            max = max+5;
        }
        System.out.println("It saying it is in the range of " + min + " from " + max);
    }

    public static Boolean duplicateNumber(int[] array){
        int findingNumber;
        for(int i=0; i<array.length; i++){
            findingNumber = array[i];
            for(int j=i+1; j<array.length; j++){
                if(findingNumber == array[j]){
                   return true;
                }
            }
        }
        return false;
    }
}
