package Sorting;

import java.util.Arrays;

public class Quick_sort_pivot {

    static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static int partition(int[] arr,int low, int high){
        int pivot=arr[high];

        int i=(low-1);
        for(int j=low; j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    static void quicksort(int arr[], int low, int high){
        if(low>=high){
            return;
        }
        int pi = partition(arr,low,high);

        quicksort(arr, low, pi-1);
        quicksort(arr, pi+1, high);
    }

    public static void main(String[] args) {
        int[] arr = {12,45,7,0,98,7,6,0,5,3,2,1,90};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
