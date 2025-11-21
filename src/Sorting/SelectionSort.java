package Sorting;

public class SelectionSort {
    static void sorting(int arr[])
    {  
        int n=arr.length;

        for(int i=0; i<n-1; i++)
        {
            //assign low index to a temporary variable
            int min_indx = i;
            for (int j=i+1; j<n ; j++){
                // to find minimum element, iteration over jth index
                if (arr[j]<arr[min_indx]){
                    min_indx=j;  //assigning low index to minimum element
                }
            }
            //swapping the minimum element at ith index
            int temp = arr[min_indx];
            arr[min_indx] = arr[i];
            arr[i] = temp;
        }
    }
    // Method the print sorted array
    static void printArray(int[] arr){
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    } 
    public static void main (String [] args){
        int[] arr= {2,5,87,45,30,905,34,21,2};
        sorting(arr); 
        System.out.println("Sorted array: ");
        printArray(arr);
    }   
}