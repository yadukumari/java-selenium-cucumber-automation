package support;

public class ClassChallenges {
    public static void main(String[] args){
        String str = "Hi How are you";
        int result = numberOfVowels(str);
        System.out.println("The total number of Vowels in a given String is: " + result);

        result = numberOfVowelsRegEX(str);
        System.out.println("The total number of Vowels in a given String using regular expression is: " + result);

        String[] arr = {};
        Boolean status = arrayEmpty(arr);
        System.out.println(status);
        tryCathExample(5);
    }

    public static int numberOfVowels(String sentence){
        int count = 0;
        for(int i =0; i<sentence.length(); i++){
            if(sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u'){
                count ++;
            }
        }
        return count;
    }

    public static int numberOfVowelsRegEX(String str){
        String newString = str.replaceAll("[^aeiouAEIOU]", "");
       return newString.length();
    }

    public static boolean arrayEmpty(String[] arr){
        return arr == null || arr.length == 0;
    }

    public static void tryCathExample(int tries){
        String str = null;
        try{
            System.out.println(str.length());
        }catch (Exception e){  // str.length() first try to get if it has any exception then here it catches
            System.out.println(e.getMessage());
            System.out.println("Exception Handling");
//            str="";
//            System.out.println(str.length());
            System.out.println("Exception Handling, Retry: " + tries);
            if(tries > 0) {
                tryCathExample(tries - 1);
            }else{
                throw new Error(e);
            }
        }
//        finally { // this we use when the catch exception is different then the actual exception error
//            //before show or execute exception error do this bunch of code or execute after try
//            System.out.println("Finally");
//        }

        System.out.println("After Exception block");
    }
}
