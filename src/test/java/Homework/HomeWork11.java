package Homework;

import java.util.Scanner;

public class HomeWork11 {

    public static void main(String[] args) {

        //Basic

        //1: Write a function to find max number in array
        int[] number = {-4, -30, -20, -10, -50};
        int result = maxNumberArray(number);
        System.out.println("The maximum number in a given array: " + result);


        //2:Find if a string a palindrome
        String str = "HolloH";
        System.out.print("The given String is a palindrome or not: ");
        System.out.println(isPalindrome(str));

        //3: Write a Java program that prompts the user to enter a year and then prints whether the year is a leap year or not.
        //(hint for requesting data from user:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the year to find is it a leap year or not: ");
        int year = scanner.nextInt();
        System.out.println("Is it a leap year or not? " + leapYear(year));

        //Medium:

        //4: Write a function to find two max numbers in array.
        int[] number1 = {10, 30, 20, 80, 100, 4, 200, -3, 90};
        twoMaxNumber(number1);

        //5: Name to initial
        //Write a function to convert a name into initials. Strictly takes two words with one space in between them.
        //The output should be two capital letters with a dot separating them.
        //It should look like this:
        //Sam Harris => S.H
        //patrick feeney => P.F
        String name = "Yadukumari";
        nameToInitial(name);


        //Advance:

        //6: Print a hollow square of asterisks
        //* * * * *
        //*       *
        //*       *
        //*       *
        //* * * * *
        System.out.println("Please Enter the size of hollow square of asterisks ");
        int size = scanner.nextInt();
        printHollowSquare(size);


    }

    //1: Write a function to find max number in array
    public static int maxNumberArray(int[] number) {
        int max = 0;
        if (number != null && number.length != 0) {
            max = number[0];
            for (int i = 1; i < number.length; i++) {
                if (max < number[i]) {
                    max = number[i];
                }
            }
        }

        return max;

    }

    //2:Find if a string a palindrome

    public static boolean isPalindrome(String str) {
        int j = str.length() - 1;
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }

    public static boolean leapYear(int year) {
//        Leap Years are any year that can be exactly divided by 4 (such as 2016, 2020, 2024, etc)
//        except if it can be exactly divided by 100, then it isn't (such as 2100, 2200, etc)
//        except if it can be exactly divided by 400, then it is (such as 2000, 2400)

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //Medium:

    //3: Write a function to find two max numbers in array.
    public static void twoMaxNumber(int[] arr) {
        int firstMax, secondMax, temp;
        if (arr.length >= 2) {
            if (arr[0] > arr[1]) {
                firstMax = arr[0];
                secondMax = arr[1];
            } else {
                firstMax = arr[1];
                secondMax = arr[0];
            }
            //20,30,10,4,80,40,100,84
            for (int i = 2; i < arr.length; i++) {
                if (firstMax < arr[i]) {
                    temp = firstMax;
                    firstMax = arr[i];
                    secondMax = temp;
                }
            }
            System.out.println("The two max numbers in array are:  " + firstMax + " " + secondMax);

        }
    }

    public static void nameToInitial(String fullName) {
        String[] nameArr = fullName.split(" ");
        String word = "";
        String Initial = "";
        for (int i = 0; i < nameArr.length; i++) {
            word = nameArr[i];
            Initial += word.charAt(0);
        }
        Initial = Initial.toUpperCase().replace("", ".");
        Initial = Initial.substring(1, (Initial.length() - 1));
        System.out.println(Initial);
    }

    //Advance:

    //6: Print a hollow square of asterisks
    //* * * * *
    //*       *
    //*       *
    //*       *
    //* * * * *

    public static void printHollowSquare(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == 0 || i == num - 1) {
                    System.out.print("* ");
                } else if (j == 0 || j == num - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
