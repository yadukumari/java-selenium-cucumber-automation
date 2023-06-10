package support;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeChallenge {

    public static void main(String[] args) {

        reverseWordsFromSentence("Hi HOw Are you?");

        //Basic
        // Print numbers from 2 to 20 using a for loop with a step 2
        //Scanner scanner = new Scanner(System.in);
//        System.out.print("\n\nEnter the maximum number to print from 2: ");
//        int number = scanner.nextInt();
//         printNumber(number);

//        //Calculate the sum of the numbers from 1 to 100 using a for loop
//       calculateSumNumber();
//
//        //Print the numbers from 10 down to 1 using a for loop
//       printNumberReverse();
//
//       //Medium
//        //Print the first 10 square numbers using a for loop
//        printFirstSquareNumber();
//
//        //Write a function that reverses words in a sentence (hint - use split())
//        String s = "Hi How Are You?";
//        reverseWordsFromSentence(s);
//
//        //Print the multiplication table for a given number using a for loop
//        System.out.print("\n\nEnter the number for multiplication table: ");
//        int num = scanner.nextInt();
//        multiplicationTable(num);
//
//        // Write a function, accepts integer argument
//        //It should print all the numbers up to the argument
//        //BUT:
//        //if number is multiple of 3, it should print Fizz instead of number
//        //if number is multiple of 5, it should print Buzz instead of number
//        //if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
//        int argument = 20;
//        printFizzBuzzNumber(argument);
//
//        //Advanced:
//
//        //Print the ASCII value and corresponding character for each uppercase letter in the alphabet using a for loop (use char type)
//        upperCaseCharAsciiValue();
//
//        //Print the first 10 numbers in the Fibonacci sequence using a for loop (Each number in the sequence is the sum of the two numbers that precede it. So, the sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so on)
//        fibonacciSequence();
//
//        //Write a program that prints a pyramid made of asterisks to the console. The program should prompt the user for the height of the pyramid and then use a for loop to print the pyramid. For example, if the user enters a height of 5, the program should print the following pyramid:
//        //    *
//        //   ***
//        //  *****
//        // *******
//        //*********
//        System.out.print("\n\nEnter the height of the pyramid: ");
//        int height = scanner.nextInt();
//        printPyramid(height);

        //Basic :

        //Print every second character in a string on a single line using a for loop (hint - use str.charAt(i))
//        String str = "abcdefghijkl";
//        secondCharacter(str);

        //Write a function that counts the number of vowels (a, e, i, o, u) in a string using a for loop and returns the value
//        str = "Hi How Are you guys doing?";
//        System.out.println("\n\nThe String is: " + str);
//        int count = countVowels(str);
//        System.out.println("The total number of Vowels (a, e, i, o, u) in a string: " + count);


        //Write a function that reverses a string using a for loop and returns the value
//        str = "LifeIsBeautiful";
//        System.out.println("\n\nThe Actual String is: " + str);
//        String newString = reverseString(str);
//        System.out.println("The reverse string is: " + newString);


        // Remove all spaces from a string using a for loop and return the value
//        str = "print string without space on console";
//        System.out.println("\n\nThe String with space is: " + str);
//        newString = removeAllSpace(str);
//        System.out.println("The string after removing space is: " + newString);

        //Medium :

        // Check if a string is a palindrome using a for loop (palindrome is a word that read the same forward and backward, like racecar, mam, noon, etc.)
//        str = "raccar";
//        palindrome(str);


        //Find the longest word in a string using a for loop
//        str = "Coding is Challenging but exiting";
//        System.out.println("\n\nThe String is: " + str);
//        String longest = longestWord(str);
//        System.out.println("The longest word in the given string is: " + longest + " and the length is: " + longest.length());

        //Convert a sentence to title case using a for loop. Example ""the quick brown fox jumps over the lazy dog" => "The Quick Brown Fox Jumps Over The Lazy Dog"
//        str = "the quick brown fox jumps over the lazy dog";
//        System.out.println("The sentence is: " + str);
//        sentenceToTitle(str);

        //Count the occurrences of each letter in a string using a for loop (hint - character range from a to z is (ch >= 'a' && ch <= 'z'). Use char primitive type (same type returned by charAt())
        String str = "aaabb;;;hv";
        occurenceOfLetter(str);



        // Encrypt a string by shifting each letter by a given number of positions using a for loop. Example with param "hello world" with shift 3 => "khoor zruog"
        str = "Hello World";
        String newstr = encryptString(str);
        System.out.println(newstr);

    }

    public static String encryptString(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Enter the position:"));
        int num = scanner.nextInt();
        int numchar;
        String  encryptedChar = "";
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                numchar = str.charAt(i) + num;
                encryptedChar += (char) numchar + "";
            }else{
                encryptedChar += str.charAt(i);
            }
        }

        return encryptedChar;
    }

    //Count the occurrences of each letter in a string using a for loop (hint - character range from a to z is (ch >= 'a' && ch <= 'z'). Use char primitive type (same type returned by charAt())


    public static void occurenceOfLetter(String str) {
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= 'A' && charArray[i] <= 'Z')) {
                if (map.get(charArray[i]) == null) {
                    num = 1;
                } else {
                    num += map.get(charArray[i]);
                }
                map.put(charArray[i], num);
            }
        }
        System.out.println("The Letters in the String: " + map.keySet());
        System.out.println("The count of the occurence of each letter: " + map.values());
    }

    //Convert a sentence to title case using a for loop. Example ""the quick brown fox jumps over the lazy dog" => "The Quick Brown Fox Jumps Over The Lazy Dog"
    public static void sentenceToTitle(String str) {
        String[] sarr = str.split(" ");
        String temp;
        for (int i = 0; i < sarr.length; i++) {
            temp = " ";
            temp += sarr[i];
            temp = temp.replace((" " + temp.charAt(1)), (temp.charAt(1) + "").toUpperCase());
            sarr[i] = temp;
            System.out.print(sarr[i] + " ");
        }
    }


    //Find the longest word in a string using a for loop
    public static String longestWord(String str) {
        int max = 0;
        String newStr = "";
        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            if (max < (strArray[i]).length()) {
                max = strArray[i].length();
                newStr = strArray[i];
            }
        }
        return newStr;
    }


    // Check if a string is a palindrome using a for loop (palindrome is a word that read the same forward and backward, like racecar, mam, noon, etc.)
    public static void palindrome(String str) {
        int j = str.length() - 1;
        boolean status = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(j)) {
                status = false;
                break;
            }
            j--;
        }
        if (status) {
            System.out.println("The String is Palindrome");
        } else {
            System.out.println("The String is not palindrome");
        }

    }


    // Remove all spaces from a string using a for loop and return the value
    public static String removeAllSpace(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result += str.charAt(i);
            }
        }

        return result;
    }


    //Write a function that reverses a string using a for loop and returns the value
    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }

        return result;
    }


    //Write a function that counts the number of vowels (a, e, i, o, u) in a string using a for loop and returns the value
    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == 'a') || (str.charAt(i) == 'e') || (str.charAt(i) == 'i') || (str.charAt(i) == 'o') || (str.charAt(i) == 'u') || (str.charAt(i) == 'A') || (str.charAt(i) == 'E') || (str.charAt(i) == 'I') || (str.charAt(i) == 'O') || (str.charAt(i) == 'U')) {
                count++;
            }
        }
        return count;
    }

    // Print numbers from 2 to 20 using a for loop with a step 2
    public static void printNumber(int num) {
        System.out.println("Number prints from 2 to 20 using a for loop with a step 2: ");
        for (int i = 2; i < num; i += 2) {
            System.out.println(i);
        }
    }

    //Calculate the sum of the numbers from 1 to 100 using a for loop
    public static void calculateSumNumber() {
        System.out.println("\nCalculate the sum of the numbers from 1 to 100 using a for loop");
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            sum += i;
        }
        System.out.println("The sum of the numbers from 1 to 100 is: " + sum);
    }

    //Print the numbers from 10 down to 1 using a for loop
    public static void printNumberReverse() {
        System.out.println("\nPrint the numbers from 10 down to 1 using a for loop");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }

    //Print the first 10 square numbers using a for loop
    public static void printFirstSquareNumber() {
        System.out.println("\nPrint the first 10 square numbers using a for loop");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i * i);
        }
    }

    //Write a function that reverses words in a sentence (hint - use split())
    public static void reverseWordsFromSentence(String s) {
        System.out.println("\nGiven Sentence: " + s);
        String[] str = s.split(" ");
        String reverseSentence = " ";
        System.out.print("After Reverse: ");
        for (int i = str.length - 1; i >= 0; i--) {
            reverseSentence += str[i] + " ";
        }
        System.out.println(reverseSentence.length());
        System.out.println((reverseSentence.trim()).length());

        System.out.println(reverseSentence.trim());
    }

    //Print the multiplication table for a given number using a for loop
    public static void multiplicationTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + "*" + i + " = " + number * i);
        }
    }

    // Write a function, accepts integer argument
    //It should print all the numbers up to the argument
    //BUT:
    //if number is multiple of 3, it should print Fizz instead of number
    //if number is multiple of 5, it should print Buzz instead of number
    //if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
    public static void printFizzBuzzNumber(int arg) {
        System.out.println("\n");
        for (int i = 1; i <= arg; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz" + " ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz" + " ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz" + " ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    //Print the ASCII value and corresponding character for each uppercase letter in the alphabet using a for loop (use char type)
    public static void upperCaseCharAsciiValue() {
        System.out.println("\nThe ASCII value and Corresponding character for each uppercase letter: ");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(ch + ": " + (int) ch);
        }


    }

    //Print the first 10 numbers in the Fibonacci sequence using a for loop (Each number in the sequence is the sum of the two numbers that precede it. So, the sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so on)
    public static void fibonacciSequence() {
        System.out.println("\nThe Fibonacci Sequence: ");
        int oldnum = 0, num = 10, newnum = 1, sum;
        System.out.print(oldnum + ", " + newnum);

        for (int i = 1; i <= num; i++) {
            sum = oldnum + newnum;
            System.out.print(", " + sum);
            oldnum = newnum;
            newnum = sum;
        }
    }

    //Write a program that prints a pyramid made of asterisks to the console. The program should prompt the user for the height of the pyramid and then use a for loop to print the pyramid. For example, if the user enters a height of 5, the program should print the following pyramid:
    //    *
    //   ***
    //  *****
    // *******
    //*********

    public static void printPyramid(int num) {
        System.out.println("\n\nPrint a pyramid made of asterisks");
        String asterisk, space;
        for (int i = 1; i <= num; i++) {
            asterisk = "*".repeat(i * 2 - 1);
            space = " ".repeat(num - i);
            System.out.println(space + asterisk + space);

        }

    }

    //Print every second character in a string on a single line using a for loop (hint - use str.charAt(i))
    public static void secondCharacter(String str) {
        System.out.println("The given String is : " + str);
        System.out.print("Every second character in a string : ");
        for (int i = 0; i < str.length(); i += 2) {
            System.out.print(str.charAt(i));
        }
    }
}
