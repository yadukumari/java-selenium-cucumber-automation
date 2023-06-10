package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import pages.*;

import java.util.*;

import static support.TestContext.getDriver;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello World");
        String str1 = "Hello There";
        String name = "John";
        System.out.println(str1 + " " + name);

    }

    @And("I say {string}")
    public void iSay(String arg0) {
        System.out.println(arg0 + " John");
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("\nFist Variable: " + str1);
        System.out.println("Second Variable: " + str2);
        System.out.println("\nUppercase:");
        System.out.println("First Variable = " + str1.toUpperCase() + "\nSecond Variable: " + str2.toUpperCase());
        System.out.println("\nLength:");
        System.out.println(str1 + "= " + str1.length() + "   " + str2 + "= " + str2.length());
        System.out.println("\nComparison between two variables:  \nFirst Variable: " + str1 + " and second Variables: " + str2 + " result is " + str1.equals(str2));
        System.out.println("\nComparison with ignoring cases between two variables:  \nFirst Variable: " + str1 + " and second Variables: " + str2 + " result is " + str1.equalsIgnoreCase(str2));
        System.out.println("\nPartial Comparison between two variables:  \nFirst Variable: " + str1 + " and second Variable: " + str2 + " result is " + str1.contains(str2));


    }

    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("Equal!");
        } else {
            System.out.println("Not Equal!");
        }
    }

    @Then("I print url for {string} page")
    public void iPrintUrlForPage(String str1) {
        switch (str1) {
            case "google":
                System.out.println("https://www.google.com");
                break;
            case "sample":
                System.out.println("https://skryabin.com/webdriver/html/sample.html");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com");
                break;
            default:
                System.out.println("Unknown site name");
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num >= 0) {
            System.out.println("Number is Positive");
        } else {
            System.out.println("Number is negative");
        }
    }

    @And("I print {int}th day of week")
    public void iPrintThDayOfWeek(int num) {
        switch (num) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Out of range(1-7)");
        }
    }

    @Given("I work with numbers")
    public void iWorkWithNumbers() {
        int i = 5;
        double price = 5.5;
        price = price - 0.5;
        System.out.println(i);
        System.out.println(price);
        System.out.println(i == price);

        Double priceInDouble = 5.5;
        priceInDouble = priceInDouble - 0.5;
        Integer iInInteger = 5;
        Integer aInInteger = 5;
        System.out.println(iInInteger == aInInteger);
        System.out.println(iInInteger.equals(priceInDouble));
        System.out.println(10 / 3);
        System.out.println(10 / 3.0);

    }

    @And("I work with array")
    public void iWorkWithArray() {
        System.out.println("int array:");
        int i = 5;
        int[] nums = {2, 9, 5, 3, 1, 7};
        //System.out.println("Length is " + nums.length);
        //System.out.println("3rd element of an array is " + nums[2]);
        //System.out.println("last element of an array is " + nums[nums.length - 1]);
        for (int num : nums) {
            num = 0; //can't change the value of array
        }
        for (int num : nums) {
            System.out.println(num + " ");
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] = 0; // it change the value of array
        }
        for (int num : nums) {
            System.out.println(num + " ");
        }

        //List<String> fruitsList = Arrays.asList("apple","pear", "plum");
        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("apple");
        fruitsList.add("pear");
        fruitsList.add("plum");
        fruitsList.set(0,"kiwi");
        // List fruitsList = List.of("apple", "pear", "plum");
        System.out.println(fruitsList.get(0));
        System.out.println(fruitsList.get(fruitsList.size()-1));
        //for(Object fruit: fruitsList)  --> can do but don't look good
        for(String fruit: fruitsList){
            System.out.println(fruit + " ");
        }
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(1);
        intList.add(7);
        intList.set(0,4);
        intList.add(8);
        intList.add(1);

        for(Integer intItem: intList){
            System.out.println(intItem + " ");
        }

        String str  = "abcdef";
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(str.length() - 1));

       // String str2 = new String("abcdef"); --> old way of assigning
        //Integer num = new Integer(6);

        List<Integer> intList2 = new ArrayList<>();
        




    }

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        int[] fruit = new int[0];
        String[] car = {"Honda", "Toyota","BMW"};
        int[] array1 = {1, 4, 2, 8, 5, 6, 16, 17};
        printNumbers(-5);
        printIntegerArray(array1);
        printArray(array1);
        checkForEmpty(fruit);
        containElement(car,"Tesla");



    }

    public void printNumbers(int n) {
        System.out.println("Numbers 0 to n: ");
        if (n > 0) {
            System.out.println("For Positive Number:");
            for (int i = 0; i < n + 1; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("For Negative Number:");
            for (int i = 0; i > n - 1; i--) {
                System.out.println(i);
            }
        }
        System.out.println("\n");
    }
    public void printIntegerArray(int[] n) {
        System.out.println("Print All Integer Array");
        for (int num : n) {
            System.out.println(num);
        }
        System.out.println("\n");
    }

    public void printArray(int[] n) {
        System.out.println("All even numbers in array");
        for (int num : n) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
        System.out.println();
    }

    public void checkForEmpty(int[] arr) {
        System.out.print("Is it a given array is an empty/not?  ");
        System.out.println(arr.length == 0);
    }

    public void containElement(String[] str, String item){
        boolean status = false;
        for(String value: str){
            if(value.equals(item)){
                status = true;
                break;
            }
        }
        System.out.println("The result is: "+status);
    }

    //4) Write a function that reverses string
    @Then("I reverse the given string {string}")
    public void iReverseTheGivenString(String str) {
        String temp="";
        for(int i=str.length()-1; i>0; i--){
            temp += str.charAt(i);
        }
        System.out.println("New Reversed String: "+temp);
    }

    @Then("I find the largest number in an array")
    public void iFindTheLargestNumberInAnArray() {
        int[] integerArray = {2,3,41,7,3,9,11};
        int max=0;
        for(int i =0; i<integerArray.length; i++){
            if(max<integerArray[i]){
                max = integerArray[i];
            }
        }
        System.out.println("The largest integer in an array: "+max);
    }

    @And("I swap two elements of an array")
    public void iSwapTwoElementsOfAnArray() {
        int[] arr = {3,4,6,7,9,10,4,2};
        int third = arr[2];
        arr[2] = arr[4];
        arr[4] = third;
        System.out.println("After swap: ");
        for(int num: arr){
            System.out.print(num+" ");
        }
    }

    @Then("I check the given number {int} is divisible by {int} or {int}")
    public void iCheckTheGivenNumberIsDivisibleByOr(int num, int div1, int div2) {
        if(num%div1 == 0 && num%div2 == 0){
            System.out.println("The number is divisible by both "+div1+" and "+div2);
        } else if (num%div2 == 0) {
            System.out.println("The number is divisible by "+div2);
        }else if(num%div1 == 0){
            System.out.println("The number is divisible by "+div1);
        }else{
            System.out.println("The number is not divisible by both "+div1+" and "+div2);
        }
    }


    @And("I work with maps")
    public void iWorkWithMaps() {
        Map<String ,String> user = new HashMap<>();
        user.put("username","Jdoe");
        user.put("firstName","John");
        user.put("lastName","Doe");
        user.put("address","123 Main st");
        user.put("e-mail","jdoe@example.com");
        user.put("password","welcome");
        user.put("password", "123");
        user.put("confirmPassword","welcome");
        user.put("phone","123-456-789");


        Map<String ,String> user2 = new LinkedHashMap<>();
        user2.put("username","Jdoe");
        user2.put("firstName","John");
        user2.put("lastName","Doe");
        user2.put("address","123 Main st");
        user2.put("e-mail","jdoe@example.com");
        user2.put("password","welcome");
        user2.put("password", "123");
        user2.put("confirmPassword","welcome");
        user2.put("phone","123-456-789");


        //using an Object
        System.out.println(user);
        System.out.println(user2);

        Set<String> userKey = user.keySet();
        Set<String> user2Key = user2.keySet();


        System.out.println(userKey);
        System.out.println(user2Key);


        System.out.println(user.get("password"));

        Set<String> set = new LinkedHashSet<>();  // if we use Hashset the order can mess up, in linkedHash set it won't becase of linkbetween value
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("four"); // it won't add because "four" is already exists... that's the beauty of set...No duplicate

        for(String s : set){
            System.out.println(s);
        }
    }

    @And("I work with classes")
    public void iWorkWithClasses() {
        Cat cat1 = new Cat("kitty");
        cat1.sleep();
        cat1.eat("cookies");

        Cat cat2 = new Cat();
        cat2.sleep();
        cat2.eat("cake");
        System.out.println(Cat.isCat(cat1));

        Animals dog1 = new Dog("Blacky");
        dog1.eat("bone");
        System.out.println(Cat.isCat(dog1));
        dog1.talk();

        Animals dino1 = new Dino();
        dino1.talk();
        System.out.println(dino1.getName());
      //  dino1.specialMethod(); ---> can't use the method which is not present in Animal or not abstract method for Animal.
        ((Dino) dino1).specialMethod();

        Animals lion1 = new Lion("Yogi");
        lion1.eat("meat");


        //get all the name from Animals
        System.out.println("Print the name: ");
        List<Animals> animals = new ArrayList<>();
        animals.add(cat1);
        animals.add(cat2);
        animals.add(dog1);
        animals.add(dino1);
        animals.add(lion1);
        for(Animals animal : animals){
            System.out.println(animal.getName());
            if(Cat.isCat(animal)){
                ((Cat) animal).specialCheckMethod();
            }
        }


    }
}
