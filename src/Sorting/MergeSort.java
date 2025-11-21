package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void conquer(int arr[], int low, int mid, int high){
        int merge_arr[]=new int[high-low+1];
        int indx1 = low;
        int indx2 = mid+1;
        int indx=0;
        while(indx1<=mid && indx2<=high){
            if(arr[indx1]<=arr[indx2]){
                merge_arr[indx++]=arr[indx1++];
            }
            else{
                merge_arr[indx++]=arr[indx2++];
            }
        }
        while(indx1<=mid){
            merge_arr[indx++]=arr[indx1++];
        }
        while(indx2<=high){
            merge_arr[indx++]=arr[indx2++];
        }
        for(int i=0, j=low; i<merge_arr.length; i++,j++){
            arr[j]=merge_arr[i];
        }

    }
    public static void divide(int arr[], int low, int high){
        if(low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        divide(arr, low, mid);
        divide(arr, mid+1, high);
        conquer(arr, low, mid, high);

    }
    public static void main(String[] args) {
        int[] arr={20,12,34,89,9,67,51,28,43,56,56,07,};
        int n = arr.length;
        divide(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
