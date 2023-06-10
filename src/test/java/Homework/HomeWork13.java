package Homework;

import java.util.Scanner;

public class HomeWork13 {
    public static void main(String[] args){

        //1: Write a program that calculates and prints out the sum of the first 100 even numbers.
        int num = 100;
        int sum = sumOfEvenNumber(num);
        System.out.println("The sum of the first " + num + " even numbers is: " + sum);

        //2: Write a program that calculates and prints out the sum of the first 10 square numbers.
        sum = sumOfSquareNumbers(5);
        System.out.println("The sum of the first " + num + " square numbers is: " + sum);

        //3: Write a program that asks the user for a number and then prints out whether that
        // number is a perfect square or not. A perfect square is a number that can be expressed
        // as the product of an integer by itself or as the second exponent of an integer. For example,
        // 25 is a perfect square because it is the product of integer 5 by itself, 5 × 5 = 25. However,
        // 21 is not a perfect square number because it cannot be expressed as the product of two same integers.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a number to verify is it a perfectSquare number or not?");
        int input = scanner.nextInt();

        boolean status = verifyPerfectSquare(input);
        System.out.println("Is it a perfect square or not: " + status);

        //4: Write a program that finds and prints out all the perfect numbers between
        // 1 and 1000. A perfect number is a positive integer that is equal to the sum of its proper divisors
        System.out.println("The perfect numbers between 1 and 1000:");
        for(int n=1; n<=1000; n++){
            if(sumOfPerfectInteger(n)) {
                System.out.println(n);
            }
        }


    }

    //1:Write a program that calculates and prints out the sum of the first 100 even numbers.
    public static int sumOfEvenNumber(int num){
        int result = 0;
        for (int i=1; i<=num; i++){
            if(i%2 == 0){
                result += i;
            }
        }

        return result;
    }

    //2: Write a program that calculates and prints out the sum of the first 10 square numbers.
    public static int sumOfSquareNumbers(int num){
        int result = 0;
        for(int i=1; i<=num; i++){
            result += i*i;
        }
        return result;
    }

    public static boolean verifyPerfectSquare(int num){
        int result = (int) Math.sqrt(num);
        return result * result == num;
    }

    //4: Write a program that finds and prints out all the perfect numbers between
    // 1 and 1000. A perfect number is a positive integer that is equal to the sum of its proper divisors
    public static boolean sumOfPerfectInteger(int num){
        int sum = 0;
        for(int i=1; i<=num/2; i++){
            if(num%i == 0){
                sum += i;
                if(sum > num){
                    return false;
                }
            }
        }
        return (num == sum);
    }


}
