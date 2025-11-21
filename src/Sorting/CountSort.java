package Sorting;

import java.sql.SQLOutput;
import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {23,45,12,90,78,45,34};
        countSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void countSort(int[] arr){
        if(arr==null || arr.length<=1)
            return;
        int max = arr[0];
        for(int num: arr){
            if(num>max)
                max=num;
        }
        // Creation an array of length max+1
        int [] freqArr = new int[max+1];

        // assigning freq of number of index
        for(int num: arr){
            freqArr[num]++;
        }
        int index=0;
        for(int i=0; i<=max; i++){
            while(freqArr[i]>0) {
                arr[index] = i;
                index++;
                freqArr[i]--;
            }
        }

    }
}
