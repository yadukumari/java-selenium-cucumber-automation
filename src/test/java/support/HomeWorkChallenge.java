package support;

import io.cucumber.plugin.event.Node;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkChallenge {
    public static  void main(String[] args){

        //Basic

        //1:Write a function that returns reversed string (do it again without looking at previous solution) Param - "Webdriver"
        String str = "webdriver";
        String result = reverseString(str);
        System.out.println("Reversed String: " + result);


        //2:Print reversed words in a sentence (use sentence.split(" ")). Param -"the quick brown fox jumps over the lazy dog"
        str = "the quick brown fox jumps over the lazy dog";
        reverseWordsSentence(str);


        //3:Print a square of at symbols (@) (refer to the square of asterisks we did in class)
//        Example for size 5:
//        @ @ @ @ @
//        @ @ @ @ @
//        @ @ @ @ @
//        @ @ @ @ @
//        @ @ @ @ @
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease Enter the square of asterisks size: ");
        int num = scanner.nextInt();
        squarAsterisks(num);


        //4:Print right-angled triangle of asterisks
//        example for size 5
//                *
//                * *
//                * * *
//                * * * *
//                * * * * *

        System.out.print("\nPlease Enter the triangle of asterisks size: ");
        num = scanner.nextInt();
        triangleAsterisks(num);


        //5:Print a square of numbers with certain size
//        example for size 5:
//        1 1 1 1 1
//        2 2 2 2 2
//        3 3 3 3 3
//        4 4 4 4 4
//        5 5 5 5 5
        System.out.print("\nPlease Enter the square of numbers size: ");
        num = scanner.nextInt();
        squarOfNumber(num);

        //6: Print the Fibonacci sequence up to a given limit (in Fibonacci sequence each number is the sum of the two preceding ones, example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)
        System.out.print("\nPlease Enter the number of limit for fibonacci sequence : ");
        num = scanner.nextInt();
        fibonacciSequence(num);

        //7:Print a reverse right-angled triangle of asterisks:
//        Example for size 5:
//        * * * * *
//        * * * *
//        * * *
//        * *
//        *
        System.out.print("\nPlease Enter the size for reverse right-angled triangle of asterisks: ");
        num = scanner.nextInt();
        reverseRightAngledTriangle(num);


      //8: Print chessboard pattern (remember % for even / odd switch)
//        Example:
//        X O X O X O X O
//        O X O X O X O X
//        X O X O X O X O
//        O X O X O X O X
//        X O X O X O X O
//        O X O X O X O X
//        X O X O X O X O
//        O X O X O X O X
        System.out.println("\nThe chessboard pattern:");
        chessBoardPattern(8);


        //Advance:

        //9: Print the sum of the digits of a given number
        System.out.print("\nPlease Enter the number : ");
        num = scanner.nextInt();
        int sum = sumOfDigits(num);
        System.out.println("the sum of the digits of a given number is: " + sum);


        //10: Reverse a given number
        System.out.print("\nPlease Enter the number : ");
        num = scanner.nextInt();
        reverseNumber(num);

        //11:Print diamond of asterisks.
        //Example:
        //        *
        //      * * *
        //    * * * * *
        //  * * * * * * *
        //* * * * * * * * *
        //  * * * * * * *
        //    * * * * *
        //      * * *
        //        *

        System.out.print("\n\nEnter the height of the pyramid: ");
        int height = scanner.nextInt();
        printPyramid(height);

    }

    //Basic:
    //1:Write a function that returns reversed string (do it again without looking at previous solution) Param - "Webdriver"

    public static String reverseString(String str){
        String[] s = str.split("");
        String temp = "";
        int j=s.length-1;
        for(int i=0; i< s.length/2; i++){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
        temp = String.join("",s);
        return temp;
    }


    //2:Print reversed words in a sentence (use sentence.split(" ")). Param -"the quick brown fox jumps over the lazy dog"
    public static void reverseWordsSentence(String str){
        String newString = "";
        String[] arrString = str.split(" ");
        for(int i=0; i<arrString.length; i++){
            newString += reverseString(arrString[i]) + " ";

        }
        System.out.println("\nReversed Words in a sentence: " + newString);
    }



    //3:Print a square of at symbols (@) (refer to the square of asterisks we did in class)
    public static void squarAsterisks(int num){
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                System.out.print("@ ");
            }
            System.out.println();
        }
    }

    //4:Print right-angled triangle of asterisks
    public static void triangleAsterisks(int num){
        for(int i=0; i<num; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    //5:Print a square of numbers with certain size
    public static void squarOfNumber(int size){
        for(int i=0; i<size; i++){
            for(int j=0; j< size; j++){
                System.out.print((i+1)+" ");
            }
            System.out.println();
        }
    }

    //6: Print the Fibonacci sequence up to a given limit (in Fibonacci sequence each number is the sum of the two preceding ones,
    // example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)
    public static void fibonacciSequence(int num){
        int j=0, k=1, temp=0, i = 0;
        while(num > i){
            System.out.print(j + ",");
            temp = j+k;
            j = k;
            k = temp;
            i++;
        }
        System.out.println();
    }

    //7:Print a reverse right-angled triangle of asterisks:
    public static void reverseRightAngledTriangle(int size){
        for(int i=0; i<size; i++){
            for(int j=size; j>i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //8: Print chessboard pattern (remember % for even / odd switch)
    public static void chessBoardPattern(int num){
        System.out.println();
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if((j+i)%2 == 0){
                    System.out.print("x ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static int sumOfDigits(int num){
        int result = 0;
        while(num != 0){
                result += num%10;
                num = num/10;
        }

        return result;
    }

    //11: Print diamond of asterisks.

    public static void printPyramid(int height){
        System.out.println("\n\nPrint a pyramid made of asterisks");
        String asterisk, space;
        for (int i = 1; i <= height; i++) {
            asterisk = "*".repeat(i * 2 - 1);
            space = " ".repeat(height - i);
            System.out.println(space + asterisk + space);
        }
        for(int i = height-1; i >= 1; i--){
            asterisk = "*".repeat(i * 2 - 1);
            space = " ".repeat(height - i);
            System.out.println(space + asterisk + space);
        }
    }

    public static void reverseNumber(int num){
        int temp = 0;
        System.out.println(num);
        while(num != 0){
            System.out.print(num%10);
            num = num/10;
        }
    }

}
