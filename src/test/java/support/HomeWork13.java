package support;

public class HomeWork13 {
    public static void main(String[] args){

        //1: Sort an array
        int[] number = {1,4,2,8,5,9,13,44,25,33,55};
        number = sortArray(number);
        for(int num : number){
            System.out.print(num+" ");
        }

        //2:  Find if 2 elements of an array results in sum number

        int sum = 99;
        System.out.println("The 2 elements of an array results in sum number: " + findSumNumberInArray(number, sum));


//        Calculate X series of a potential equity curve in trading Y number of trades with certain trading capital Z, keeping in mind:
//        - position size % out of total trading capital
//        - success rate of a trader
//        - risk / reward ratio

        //Did with class help:
        //trades();

    }

//public static void trades(int seriesCount){
//        int tradesCount = 100;
//
//}


    //1: Sort an array
    public static int[] sortArray(int[] numArray){
        int small = 0;
        for(int i = 0; i<numArray.length; i++){
            small = numArray[i];
            for(int j = i+1; j<numArray.length; j++){
                if(small > numArray[j]){
                    numArray[i] = numArray[j];
                    numArray[j] = small;
                    small = numArray[i];
                }
            }
        }

        return numArray;
    }

    //2:  Find if 2 elements of an array results in sum number
    public static boolean findSumNumberInArray(int[] array, int sum){
        int otherHalf = 0;
        for(int i=0; i<array.length; i++){
            otherHalf = sum - array[i];
            for(int j = i+1; j<array.length; j++){
                if(otherHalf == array[j]){
                    return true;
                }
            }
        }

        return false;
    }



}
